package controladores;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidades.ComentarioFix;
import entidades.UsuarioFix;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import objetosnegocio.Normal;
import objetosnegocio.Usuario;
import respositorios.Control;

/**
 *
 * @author Daniel Parra
 */
@MultipartConfig
public class ServletUsuario extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        String url = "";

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

        String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        UsuarioFix uf = gson.fromJson(json, UsuarioFix.class);

        Normal usr = uf.toNormal();
        
        System.out.println(usr.getFechaNacimiento());
        
        usr.setAvatar(Base64.getDecoder().decode(uf.getAvatar()));
        
        if (uf.getContrasenia().equals(uf.getConfCon())) {

            boolean repetido = false;
            ArrayList<Usuario> usuariosRegistrados = Control.getUsuarioRepository().consultarTodos();

            for (Usuario ur : usuariosRegistrados) {
                if (ur.getNombreCompleto().equals(uf.getNombreCompleto())) {
                    repetido = true;
                    break;
                }
            }

            if (!repetido) {
                Control.getNormalRepository().guardar(usr);
                url = "./MainPage.jsp";

            } else {
                url = "./Register.jsp";
            }

        }
        
        response.setContentType("application/json");

        try (PrintWriter out = response.getWriter()) {
            out.write(gson.toJson(url));
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

package controladores;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import objetosnegocio.Normal;
import respositorios.Control;

/**
 *
 * @author Daniel Parra
 */
@MultipartConfig
public class ServletUsuario extends HttpServlet {
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

    }

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

        String message;
        String url;
        Normal usr = new Normal();

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String birthday = request.getParameter("birthday");
        char genero = request.getParameter("gender").charAt(0);
        Part filePart = request.getPart("avatar"); // Retrieves <input type="file" name="avatar">

        //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        if (username == null || email == null || password == null || birthday == null || filePart == null
                || username.isEmpty() || email.isEmpty() || password.isEmpty() || birthday.isEmpty()) {

            message = "Rellena todos los campos.";
            url = "/Register.jsp";

        } else {

            if (password.equals(confirmPassword)) {

                InputStream fileContent = filePart.getInputStream();
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte[] buffer = new byte[10240];
                for (int length = 0; (length = fileContent.read(buffer)) > 0;) {
                    output.write(buffer, 0, length);
                }

                byte[] image = output.toByteArray();

                LocalDate bday = LocalDate.parse(birthday);

                usr.setNombreCompleto(username);
                usr.setCorreo(email);
                usr.setContrasenia(password);
                usr.setFechaNacimiento(bday);
                usr.setGenero(genero);
                usr.setAvatar(image);
                usr.setTelefono(null);
                usr.setCiudad(null);
                
                Control c = new Control();
                c.getNormalRepository().guardar(usr);

                message = "Operacion realizada con exito.";
                url = "/MainPage.jsp";

            } else {
                message = "Confirme bien su contrasenia.";
                url = "/Register.jsp";
            }

        }

        request.setAttribute("message", message);
        request.setAttribute("user", usr);
        
        getServletContext().getRequestDispatcher(url).forward(request, response);

//        try (PrintWriter out = response.getWriter()) {
//            out.println(username);
//            out.println(email);
//            out.println(password);
//            out.println(confirmPassword);
//            out.println(genero);
//            out.println(Arrays.toString(image));
//        } catch (Exception e) {
//        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

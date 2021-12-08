/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.google.gson.Gson;
import entidades.UsuarioFix;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetosnegocio.Usuario;
import respositorios.Control;

/**
 *
 * @author Daniel Parra
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String usernameLogin = req.getParameter("username-login");
        String passwordLogin = req.getParameter("password-login");
        
        Usuario user = null;
        boolean esAdmin = false;
        
        ArrayList<Usuario> usrs = Control.getUsuarioRepository().consultarTodos();
        
        if (!(usernameLogin == null || passwordLogin == null || usernameLogin.isEmpty() || passwordLogin.isEmpty())) {
            for (Usuario usuario : usrs) {
                if (usuario.getNombreCompleto().equals(usernameLogin) && usuario.getContrasenia().equals(passwordLogin)) {
                    if ((Control.getAdmorRepository().buscarPorId(usuario.getId())) != null) {
                        esAdmin = true;
                    }
                    
                    // Login exitoso
                    user = usuario;
                    break;   
                }
            }
        }
        
        UsuarioFix usuarioJson = new UsuarioFix(user, esAdmin);
        
        Gson gson = new Gson();
        resp.setContentType("application/json");
        
        try (PrintWriter out = resp.getWriter()) {
            out.write(gson.toJson(usuarioJson));
        }
        
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

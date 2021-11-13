/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

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
        
        String usernameLogin = request.getParameter("username-login");
        String passwordLogin = request.getParameter("password-login");
        
        String message = "";
        String url = "";
        
        Usuario user = null;
        
        ArrayList<Usuario> usrs = Control.getUsuarioRepository().consultarTodos();
        
        if (usernameLogin == null || passwordLogin == null || usernameLogin.isEmpty() || passwordLogin.isEmpty()) {
            
            url = "./LogIn.html";
            message = "Campos no llenos.";
            
        } else {
            
            for (Usuario usuario : usrs) {
                
                if (usuario.getNombreCompleto().equals(usernameLogin) && usuario.getContrasenia().equals(passwordLogin)) {
                    
                    message = "Login exitoso.";
                    user = usuario;
                    url = "./ObtenerPostsServlet?action=\"join\"";
                    break;
                    
                }
                
                message = "Usuario no existe.";
                url = "./Register.jsp";
                
                
            }
            
        }
        
        if (user != null) {
            request.getSession().setAttribute("user", user);
        }
        
        request.getSession().setAttribute("message", message);
        
        // getServletContext().getRequestDispatcher(url).forward(request, response);
        
        response.sendRedirect(url);
        
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

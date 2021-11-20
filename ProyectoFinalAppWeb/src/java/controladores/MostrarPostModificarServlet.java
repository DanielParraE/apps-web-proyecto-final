/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetosnegocio.Anclado;
import objetosnegocio.Comun;
import objetosnegocio.Post;
import respositorios.Control;

/**
 *
 * @author Daniel Parra
 */
public class MostrarPostModificarServlet extends HttpServlet {
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
        
        Comun postComun = Control.getComunRepository().buscarPorId(Integer.valueOf(request.getParameter("idpost")));
        String url;
        
        
        if(postComun != null) {
            
            String nombreAutor = postComun.getUsuario().getNombreCompleto();
            request.getSession().setAttribute("postmodify", postComun);
            request.getSession().setAttribute("postmodifyautor", nombreAutor);
            url = "./Edit.jsp";
            
        } else {
            
            Anclado postAnclado = Control.getAncladoRepository().buscarPorId(Integer.valueOf(request.getParameter("idpost")));
            
            String nombreAutor = postAnclado.getAdministrador().getNombreCompleto();
            request.getSession().setAttribute("postmodify", postAnclado);
            request.getSession().setAttribute("postmodifyautor", nombreAutor);
            
            url = "./Edit.jsp";
            
        }
        
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
    }// </editor-fold>

}

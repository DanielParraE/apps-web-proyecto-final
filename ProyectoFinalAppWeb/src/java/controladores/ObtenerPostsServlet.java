/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetosnegocio.Anclado;
import objetosnegocio.Comentario;
import objetosnegocio.Comun;
import respositorios.Control;

/**
 *
 * @author Daniel Parra
 */
public class ObtenerPostsServlet extends HttpServlet {

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
        
        // Obtiene todos los posrs anclados.
        ArrayList<Anclado> postsAncladosRegistrados = Control.getAncladoRepository().consultarTodos();
        Collections.reverse(postsAncladosRegistrados);
        
        // Obtiene todos los posts comunes.
        ArrayList<Comun> postsComunesRegistrados = Control.getComunRepository().consultarTodos();
        Collections.reverse(postsComunesRegistrados);
        
        // Obtiene todos los comentarios.
        ArrayList<Comentario> cmts = Control.getComentarioRepository().consultarTodos();
        Collections.reverse(cmts);
        
        // Mete los posts a la sesion.
        request.getSession().setAttribute("postsComunes", postsComunesRegistrados);
        request.getSession().setAttribute("postsAnclados", postsAncladosRegistrados);
        
        // Mete los comentarios a la sesion.
        request.getSession().setAttribute("cmts", cmts);
        
        response.sendRedirect("./MainPage.jsp");
        
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

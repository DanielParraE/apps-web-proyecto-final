/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetosnegocio.Post;
import respositorios.Control;

/**
 *
 * @author Daniel Parra
 */
public class ModificarPostServlet extends HttpServlet {

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
        
        String idPostModificar = request.getParameter("idpost");
        int idPost = Integer.valueOf(idPostModificar);
        
        Post postModificar = Control.getPostRepository().buscarPorId(idPost);
        
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        
        postModificar.setTitulo(titulo);
        postModificar.setContenido(contenido);
        postModificar.setFechaHoraEdicion(Timestamp.valueOf(LocalDateTime.now()));
        
        Control.getPostRepository().actualizar(postModificar);
        
        response.sendRedirect("./MisPostsServlet");
        
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

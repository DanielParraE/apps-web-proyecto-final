/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.google.gson.Gson;
import entidades.ComentarioFix;
import entidades.PostFix;
import java.io.IOException;
import java.io.PrintWriter;
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
        
        // Obtiene todos los posts anclados.
        ArrayList<Anclado> postsAncladosRegistrados = Control.getAncladoRepository().consultarTodos();
        Collections.reverse(postsAncladosRegistrados);
        
        ArrayList<PostFix> postsAncladosRegistradosCopy = new ArrayList<>();
        
        for (Anclado post : postsAncladosRegistrados) {
            postsAncladosRegistradosCopy.add(new PostFix(post));
        }
        
        // Obtiene todos los posts comunes.
        ArrayList<Comun> postsComunesRegistrados = Control.getComunRepository().consultarTodos();
        Collections.reverse(postsComunesRegistrados);
        
        ArrayList<PostFix> postsComunesRegistradosCopy = new ArrayList<>();
        
        for (Comun post : postsComunesRegistrados) {
            postsComunesRegistradosCopy.add(new PostFix(post));
        }
        
        // Obtiene todos los comentarios.
        ArrayList<Comentario> cmts = Control.getComentarioRepository().consultarTodos();
        Collections.reverse(cmts);
        
        ArrayList<ComentarioFix> cmtsCopy = new ArrayList<>();
        
        for (Comentario cmt : cmts) {
            cmtsCopy.add(new ComentarioFix(cmt));
        }
        
        // agrega todas las listas en una lista para mandar en formato JSON
        ArrayList<Object> listas = new ArrayList<>();
        listas.add(postsComunesRegistradosCopy);
        listas.add(cmtsCopy);
        listas.add(postsAncladosRegistradosCopy);
        
        Gson gson = new Gson();
        response.setContentType("application/json");
        
        try (PrintWriter out = response.getWriter()) {
            out.write(gson.toJson(listas));
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

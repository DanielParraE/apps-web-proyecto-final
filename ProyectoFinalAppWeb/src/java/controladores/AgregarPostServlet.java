/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.google.gson.Gson;
import entidades.PostFix;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetosnegocio.Anclado;
import objetosnegocio.Comun;
import objetosnegocio.Usuario;
import respositorios.Control;

/**
 *
 * @author Daniel Parra
 */
public class AgregarPostServlet extends HttpServlet {

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

        //String titulo = request.getParameter("titulo");
        //String contenido = request.getParameter("contenido");
        //Usuario usr = (Usuario) request.getSession().getAttribute("user");
        String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Gson gson = new Gson();
        PostFix pf = gson.fromJson(json, PostFix.class);

        // System.out.println(pf.toString() + " - " + pf.isAnclado());

        if (pf.isAnclado() && pf.getUsrFix().getEsAdmin()) {
            Anclado post = new Anclado(Timestamp.valueOf(LocalDateTime.now()), pf.getTitulo(), pf.getContenido(), null);
            
            post.setAdministrador(Control.getAdmorRepository().buscarPorId(pf.getUsrFix().getId()));
            Control.getAncladoRepository().guardar(post);
            
            response.setContentType("application/json");
            
            try (PrintWriter out = response.getWriter()) {
                out.write(gson.toJson(new PostFix(post)));
            }

        } else {
            Comun post = new Comun(Timestamp.valueOf(LocalDateTime.now()), pf.getTitulo(), pf.getContenido(), null);
            
            post.setUsuario(Control.getUsuarioRepository().buscarPorId(pf.getUsrFix().getId()));
            Control.getComunRepository().guardar(post);
            
            response.setContentType("application/json");
            
            try (PrintWriter out = response.getWriter()) {
                out.write(gson.toJson(new PostFix(post)));
            }
            
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

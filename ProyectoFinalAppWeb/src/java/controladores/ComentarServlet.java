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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetosnegocio.Comentario;
import objetosnegocio.Comun;
import objetosnegocio.Normal;
import objetosnegocio.Usuario;
import respositorios.Control;

/**
 *
 * @author Daniel Parra
 */
public class ComentarServlet extends HttpServlet {

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
        
        String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        
        Gson gson = new Gson();
        ComentarioFix cf = gson.fromJson(json, ComentarioFix.class);
        
        Normal nrm = Control.getNormalRepository().buscarPorId(cf.getUsrFix().getId());
        Comun postComun = Control.getComunRepository().buscarPorId(cf.getIdPost());

        Comentario cmt = new Comentario();
        cmt.setContenido(cf.getContenido());
        cmt.setUsuarioNormal(nrm);
        cmt.setPostComun(postComun);
        cmt.setFechaHora(LocalDateTime.now());
        
        Control.getComentarioRepository().guardar(cmt);

        response.setContentType("application/json");

        try (PrintWriter out = response.getWriter()) {
            out.write(gson.toJson(new ComentarioFix(cmt)));
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

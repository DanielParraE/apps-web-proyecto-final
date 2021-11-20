/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.time.LocalDateTime;
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
        
        int idpost = Integer.valueOf(request.getParameter("idpostcomentar"));
        Usuario usrTemp = (Usuario) request.getSession().getAttribute("user");
        String contenido = request.getParameter("comentarioContenido");
        
        Normal nrm = Control.getNormalRepository().buscarPorId(usrTemp.getId());
        Comun postComun = Control.getComunRepository().buscarPorId(idpost);
        
        Comentario cmt = new Comentario();
        cmt.setFechaHora(LocalDateTime.now());
        cmt.setUsuarioNormal(nrm);
        cmt.setContenido(contenido);
        cmt.setPostComun(postComun);
        
        Control.getComentarioRepository().guardar(cmt);
        
        response.sendRedirect("./ObtenerPostsServlet");
        
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

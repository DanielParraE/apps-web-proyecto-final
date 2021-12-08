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
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetosnegocio.Anclado;
import objetosnegocio.Comun;
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
        
        String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Gson gson = new Gson();
        PostFix pf = gson.fromJson(json, PostFix.class);
        
        Comun postComun = Control.getComunRepository().buscarPorId(pf.getId());
        
        if(postComun != null) {
            
            response.setContentType("application/json");
            
            try (PrintWriter out = response.getWriter()) {
                out.write(gson.toJson(new PostFix(postComun)));
            }
            
        } else {
            
            Anclado postAnclado = Control.getAncladoRepository().buscarPorId(pf.getId());
            
            response.setContentType("application/json");
            
            try (PrintWriter out = response.getWriter()) {
                out.write(gson.toJson(new PostFix(postAnclado)));
            }
            
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
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

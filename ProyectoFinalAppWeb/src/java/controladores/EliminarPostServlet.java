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
public class EliminarPostServlet extends HttpServlet {

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
        //processRequest(request, response);
        
        Gson gson = new Gson();
        
        //Post postEliminar = Control.getPostRepository().buscarPorId();
        
        Control.getPostRepository().eliminar(Integer.valueOf(request.getParameter("idpost")));
        
        response.setContentType("application/json");
            
            try (PrintWriter out = response.getWriter()) {
                out.write(gson.toJson("confirmao"));
            }
        
        // response.sendRedirect("./ObtenerPostsServlet");
        
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

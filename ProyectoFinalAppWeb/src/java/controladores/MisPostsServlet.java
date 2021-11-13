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
import objetosnegocio.Admor;
import objetosnegocio.Anclado;
import objetosnegocio.Comun;
import objetosnegocio.Post;
import objetosnegocio.Usuario;
import respositorios.Control;

/**
 *
 * @author Daniel Parra
 */
public class MisPostsServlet extends HttpServlet {

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

        //ArrayList<Post> allPosts = Control.getPostRepository().consultarTodos();
        //Collections.reverse(allPosts);
        ArrayList<Post> misPosts = new ArrayList<>();

        Usuario usr = (Usuario) request.getSession().getAttribute("user");

        String nombre = usr.getNombreCompleto();

//        for (Admor admin : administradores) {
//            if (admin.getNombreCompleto().equals(nombre)) {
//                esNormal = false;
//            }
//        }
//        if (esNormal) {
        ArrayList<Anclado> postsAnclados = Control.getAncladoRepository().consultarTodos();

        Collections.reverse(postsAnclados);

        for (Anclado postsAnclado : postsAnclados) {
            if (postsAnclado.getAdministrador().getNombreCompleto().equals(nombre)) {

                misPosts.add(postsAnclado);

            }
        }

        ArrayList<Comun> postsComunes = Control.getComunRepository().consultarTodos();

        Collections.reverse(postsComunes);

        for (Comun post : postsComunes) {
            if (post.getUsuario().getNombreCompleto().equals(nombre)) {
                misPosts.add(post);
            }
        }
//        } else {

//        }
        request.getSession().setAttribute("misPosts", misPosts);

        response.sendRedirect("./Home.jsp");

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

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
        ArrayList<Anclado> misPostsAnclados = new ArrayList<>();
        ArrayList<Comun> misPostsComunes = new ArrayList<>();

        boolean esAdmin = (Boolean) request.getSession().getAttribute("esAdmin");
        Usuario usr = (Usuario) request.getSession().getAttribute("user");

        String nombre = usr.getNombreCompleto();

        ArrayList<Anclado> postsAnclados = Control.getAncladoRepository().consultarTodos();

        Collections.reverse(postsAnclados);

        if (esAdmin) {
            for (Anclado postAnclado : postsAnclados) {
                if (postAnclado.getAdministrador().getNombreCompleto().equals(nombre)) {
                    misPostsAnclados.add(postAnclado);
                }
            }
        }

        ArrayList<Comun> postsComunes = Control.getComunRepository().consultarTodos();

        Collections.reverse(postsComunes);

        for (Comun post : postsComunes) {
            if (post.getUsuario().getNombreCompleto().equals(nombre)) {
                misPostsComunes.add(post);
            }
        }

        request.getSession().setAttribute("misPostsAnclados", misPostsAnclados);
        request.getSession().setAttribute("misPostsComunes", misPostsComunes);

        response.sendRedirect("./Home.jsp");

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

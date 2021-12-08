/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Timestamp;
import objetosnegocio.Comentario;
import objetosnegocio.Comun;
import objetosnegocio.Normal;

/**
 *
 * @author Daniel Parra
 */
public class ComentarioFix {

    private int id;
    //idPost usado para obtener el post y agregar el comentario a dicho post
    private int idPost;
    private Timestamp fechaHora;
    private String contenido;
    private Comun postComun;
    private Normal usuarioNormal;
    private UsuarioFix usrFix;

    public ComentarioFix() {
    }

    public ComentarioFix(int id, Timestamp fechaHora, String contenido, Comun postComun, Normal usuarioNormal) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.postComun = postComun;
        this.usuarioNormal = usuarioNormal;
    }

    public ComentarioFix(Timestamp fechaHora, String contenido, Comun postComun, Normal usuarioNormal) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.postComun = postComun;
        this.usuarioNormal = usuarioNormal;
    }

    public ComentarioFix(Comentario cmt) {
        this.contenido = cmt.getContenido();
        this.usuarioNormal = new UsuarioFix(cmt.getUsuarioNormal(), false).toNormal();
        this.fechaHora = cmt.getFechaHora();
        this.id = cmt.getId();
        this.postComun = new PostFix(cmt.getPostComun()).toComun();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Comun getPostComun() {
        return postComun;
    }

    public void setPostComun(Comun postComun) {
        this.postComun = postComun;
    }

    public Normal getUsuarioNormal() {
        return usuarioNormal;
    }

    public void setUsuarioNormal(Normal usuarioNormal) {
        this.usuarioNormal = usuarioNormal;
    }

    public UsuarioFix getUsrFix() {
        return usrFix;
    }

    public void setUsrFix(UsuarioFix usrFix) {
        this.usrFix = usrFix;
    }
    
    public Comentario toComentario() {
        Comentario cmt = new Comentario();
        cmt.setContenido(contenido);
        cmt.setUsuarioNormal(usuarioNormal);
        cmt.setPostComun(postComun);
        cmt.setFechaHora(fechaHora.toLocalDateTime());
        cmt.setId(id);
        return cmt;
    }

}

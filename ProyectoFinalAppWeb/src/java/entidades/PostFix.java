/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Timestamp;
import objetosnegocio.Admor;
import objetosnegocio.Anclado;
import objetosnegocio.Comun;
import objetosnegocio.Usuario;

/**
 *
 * @author Daniel Parra
 */
public class PostFix {

    private int id;
    protected Timestamp fechaHoraCreacion;
    protected String titulo;
    protected String contenido;
    protected Timestamp fechaHoraEdicion;
    //Parametro para obtener un usuarioFixeado el agregar post;
    private UsuarioFix usrFix;
    //Parametro para saber si el post tiene que ser anclado o no
    private boolean esAnclado;
    //Parametro usuario para los fix de posts comunes
    private Usuario usuario;
    //Parametro de administrador para los fix de posts anclados
    private Admor administrador;

    public PostFix(int id, Timestamp fechaHoraCreacion, String titulo, String contenido, Timestamp fechaHoraEdicion) {
        this.id = id;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    public PostFix(Timestamp fechaHoraCreacion, String titulo, String contenido, Timestamp fechaHoraEdicion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    public PostFix(Comun post) {
        this.id = post.getId();
        this.contenido = post.getContenido();
        this.fechaHoraCreacion = Timestamp.valueOf(post.getFechaHoraCreacion());
        this.fechaHoraEdicion = post.getFechaHoraEdicion();
        this.titulo = post.getTitulo();
        this.usuario = new UsuarioFix(post.getUsuario(), false).toUsuario();
    }

    public PostFix(Anclado post) {
        this.id = post.getId();
        this.contenido = post.getContenido();
        this.fechaHoraCreacion = Timestamp.valueOf(post.getFechaHoraCreacion());
        this.fechaHoraEdicion = post.getFechaHoraEdicion();
        this.titulo = post.getTitulo();
        this.usuario = new UsuarioFix(post.getAdministrador(), true).toUsuario();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(Timestamp fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Timestamp getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    public void setFechaHoraEdicion(Timestamp fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Admor getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Admor administrador) {
        this.administrador = administrador;
    }

    public UsuarioFix getUsrFix() {
        return usrFix;
    }

    public void setUsrFix(UsuarioFix usrFix) {
        this.usrFix = usrFix;
    }

    public boolean isAnclado() {
        return esAnclado;
    }

    public void setEsAnclado(boolean esAnclado) {
        this.esAnclado = esAnclado;
    }

    public Comun toComun() {
        Comun cmn = new Comun(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        cmn.setId(id);
        return cmn;
    }

    public Anclado toAnclado() {
        Anclado anc = new Anclado(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        anc.setId(id);
        return anc;
    }

    @Override
    public String toString() {
        return "PostFix{" + "titulo=" + titulo + ", contenido=" + contenido + ", usrFix=" + usrFix.getNombreCompleto() + '}';
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosnegocio;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author Daniel Parra
 */
@Entity
@Table(name="posts")
@Inheritance(strategy = InheritanceType.JOINED)
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id_post")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="fechaHoraCreacion")
    protected Timestamp fechaHoraCreacion;
    
    @Column(name="titulo")
    protected String titulo;
    
    @Column(name="contenido")
    protected String contenido;
    
    @Column(name="fechaHoraEdicion")
    protected Timestamp fechaHoraEdicion;

    public Post() {
    }
    
    public Post(Timestamp fechaHoraCreacion, String titulo, String contenido, Timestamp fechaHoraEdicion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion.toLocalDateTime();
    }

    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = Timestamp.valueOf(fechaHoraCreacion);
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", fechaHoraCreacion=" + fechaHoraCreacion + ", titulo=" + titulo + ", contenido=" + contenido + ", fechaHoraEdicion=" + fechaHoraEdicion + '}';
    }
    
}

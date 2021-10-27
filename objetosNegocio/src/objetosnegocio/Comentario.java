/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosnegocio;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Daniel Parra
 */
@Entity
@Table(name="comentarios")
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id_comentario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="fechaHora")
    private Timestamp fechaHora;
    
    @Column(name="contenido")
    private String contenido;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_comentario")
    private List<Comentario> comentarios;
    
//    @ManyToOne
//    @JoinColumn(name="id_comentario", nullable = false)
//    private Comentario comentario;
    
    @ManyToOne
    @JoinColumn(name="id_post", nullable = false)
    private Comun postComun;
    
    @ManyToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Normal usuarioNormal;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = Timestamp.valueOf(fechaHora);
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

//    public Comentario getComentario() {
//        return comentario;
//    }
//
//    public void setComentario(Comentario comentario) {
//        this.comentario = comentario;
//    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosnegocio.Comentario[ id=" + id + " ]";
    }
    
}

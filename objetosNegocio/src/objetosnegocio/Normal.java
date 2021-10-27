/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosnegocio;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Daniel Parra
 */
@Entity
@Table(name="normales")
@PrimaryKeyJoinColumn(name="usuario")
public class Normal extends Usuario{

    public Normal() {
    }

    public Normal(String nombreCompleto, String correo, String contrasenia, String telefono, byte[] avatar, String ciudad, Date fechaNacimiento, Genero genero) {
        super(nombreCompleto, correo, contrasenia, telefono, avatar, ciudad, fechaNacimiento, genero);
    }

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="id_comentario")
    private List<Comentario> comentarios;

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
}

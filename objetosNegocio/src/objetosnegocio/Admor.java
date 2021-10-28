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
@Table(name="administradores")
@PrimaryKeyJoinColumn(name="usuario")
public class Admor extends Usuario{

    public Admor() {
    }

    public Admor(String nombreCompleto, String correo, String contrasenia, String telefono, byte[] avatar, String ciudad, Date fechaNacimiento, char genero) {
        super(nombreCompleto, correo, contrasenia, telefono, avatar, ciudad, fechaNacimiento, genero);
    }
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="id_post")
    private List<Anclado> postsAnclados;
    
    public List<Anclado> getPostsAnclados() {
        return postsAnclados;
    }

    public void setPostsAnclados(List<Anclado> postsAnclados) {
        this.postsAnclados = postsAnclados;
    }
    
}

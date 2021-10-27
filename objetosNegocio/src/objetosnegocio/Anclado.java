/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosnegocio;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Daniel Parra
 */
@Entity
@Table(name="anclados")
@PrimaryKeyJoinColumn(name="post")
public class Anclado extends Post {

    public Anclado() {
    }

    public Anclado(Timestamp fechaHoraCreacion, String titulo, String contenido, Timestamp fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
    }
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Admor administrador;

    public Admor getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Admor administrador) {
        this.administrador = administrador;
    }

}

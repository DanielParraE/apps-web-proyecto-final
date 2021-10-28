/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosnegocio;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
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
@Table(name="usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    public int getId() {
        return id;
    }

    @Column(name="nombreCompleto")
    private String nombreCompleto;
    
    @Column(name="correo")
    private String correo;
    
    @Column(name="contrasenia")
    protected String contrasenia;
    
    @Column(name="telefono")
    protected String telefono;
    
    @Column(name="avatar")
    protected byte[] avatar;
    
    @Column(name="ciudad")
    protected String ciudad;
    
    @Column(name="fechaNacimiento")
    protected Date fechaNacimiento;
    
    @Column(name="genero")
    protected char genero;

    public Usuario() {
    }
    
    public Usuario(String nombreCompleto, String correo, String contrasenia, String telefono, byte[] avatar, String ciudad, Date fechaNacimiento, char genero) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.avatar = avatar;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento.toLocalDate();
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = Date.valueOf(fechaNacimiento);
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosnegocio.Usuario[ id=" + id + " ]";
    }
    
}

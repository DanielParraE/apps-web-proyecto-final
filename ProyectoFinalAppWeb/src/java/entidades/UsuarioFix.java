/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Base64;
import objetosnegocio.Normal;
import objetosnegocio.Usuario;

/**
 *
 * @author Daniel Parra
 */
public class UsuarioFix {
    
    private int id;
    private String nombreCompleto;
    private String correo;
    private String contrasenia;
    private String telefono;
    private String avatar;
    private String ciudad;
    private Date fechaNacimiento;
    private char genero;
    private boolean esAdmin;
    //Parametro que se usa solo apra agregar un nuevo usuario.
    private String confCon;
    
    public UsuarioFix() {
    }
    
    public UsuarioFix(Usuario user, boolean admin) {
        this.id = user.getId();
        this.nombreCompleto = user.getNombreCompleto();
        this.correo = user.getCorreo();
        this.contrasenia = user.getContrasenia();
        this.telefono = user.getTelefono();
        if (user.getAvatar() == null) {
            this.avatar = "";
        } else {
            this.avatar = Base64.getEncoder().encodeToString(user.getAvatar());
        }
        this.ciudad = user.getCiudad();
        this.fechaNacimiento = Date.valueOf(user.getFechaNacimiento());
        this.genero = user.getGenero();
        this.esAdmin = admin;
    }
    
    public UsuarioFix(String nombreCompleto, String correo, String contrasenia, String telefono, String avatar, String ciudad, Date fechaNacimiento, char genero) {
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
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
    
    public boolean getEsAdmin() {
        return esAdmin;
    }
    
    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getConfCon() {
        return confCon;
    }

    public void setConfCon(String confCon) {
        this.confCon = confCon;
    }
    
    public Usuario toUsuario() {
        return new Usuario(nombreCompleto, correo, contrasenia, telefono, null, ciudad, fechaNacimiento, genero);
    }
    
    public Normal toNormal() {
        return new Normal(nombreCompleto, correo, contrasenia, telefono, null, ciudad, fechaNacimiento, genero);
    }
    
}

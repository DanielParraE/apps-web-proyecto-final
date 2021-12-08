/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Daniel Parra
 */
public class Estado {
    
    private String clave;
    private String nombre;
    private String[] municipios;

    public Estado() {
    }
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getMunicipios() {
        return municipios;
    }

    public void setMunicipios(String[] municipios) {
        this.municipios = municipios;
    }
    
}

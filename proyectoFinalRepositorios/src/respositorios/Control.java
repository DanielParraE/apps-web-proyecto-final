/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package respositorios;

/**
 *
 * @author Daniel Parra
 */
public class Control {
    
    private static AdmorRepository adr;
    private static AncladoRepository acr;
    private static ComentarioRepository comenr;
    private static ComunRepository comunr;
    private static NormalRepository nr;
    private static PostRepository pr;
    private static UsuarioRepository ur;
    
    public static AdmorRepository getAdmorRepository() {
        if (adr == null) {
            adr = new AdmorRepository();
            return adr;
        } else {
            return adr;
        }
    }
    
    public static AncladoRepository getAncladoRepository() {
        if (acr == null) {
            acr = new AncladoRepository();
            return acr;
        } else {
            return acr;
        }
    }
    
    public static ComentarioRepository getComentarioRepository() {
        if (comenr == null) {
            comenr = new ComentarioRepository();
            return comenr;
        } else {
            return comenr;
        }
    }
    
    public static ComunRepository getComunRepository() {
        if (comunr == null) {
            comunr = new ComunRepository();
            return comunr;
        } else {
            return comunr;
        }
    }
    
    public static NormalRepository getNormalRepository() {
        if (nr == null) {
            nr = new NormalRepository();
            return nr;
        } else {
            return nr;
        }
    }
    
    public static PostRepository getPostRepository() {
        if (pr == null) {
            pr = new PostRepository();
            return pr;
        } else {
            return pr;
        }
    }
    
    public static UsuarioRepository getUsuarioRepository() {
        if (pr == null) {
            ur = new UsuarioRepository();
            return ur;
        } else {
            return ur;
        }
    }
    
}

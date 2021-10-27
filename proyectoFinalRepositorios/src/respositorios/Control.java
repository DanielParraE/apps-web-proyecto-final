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
    
    AdmorRepository adr;
    AncladoRepository acr;
    ComentarioRepository comenr;
    ComunRepository comunr;
    NormalRepository nr;
    PostRepository pr;
    UsuarioRepository ur;
    
    public AdmorRepository getAdmorRepository() {
        if (adr == null) {
            adr = new AdmorRepository();
            return adr;
        } else {
            return adr;
        }
    }
    
    public AncladoRepository getAncladoRepository() {
        if (acr == null) {
            acr = new AncladoRepository();
            return acr;
        } else {
            return acr;
        }
    }
    
    public ComentarioRepository getComentarioRepository() {
        if (comenr == null) {
            comenr = new ComentarioRepository();
            return comenr;
        } else {
            return comenr;
        }
    }
    
    public ComunRepository getComunRepository() {
        if (comunr == null) {
            comunr = new ComunRepository();
            return comunr;
        } else {
            return comunr;
        }
    }
    
    public NormalRepository getNormalRepository() {
        if (nr == null) {
            nr = new NormalRepository();
            return nr;
        } else {
            return nr;
        }
    }
    
    public PostRepository getPostRepository() {
        if (pr == null) {
            pr = new PostRepository();
            return pr;
        } else {
            return pr;
        }
    }
    
    public UsuarioRepository getUsuarioRepository() {
        if (pr == null) {
            ur = new UsuarioRepository();
            return ur;
        } else {
            return ur;
        }
    }
    
}

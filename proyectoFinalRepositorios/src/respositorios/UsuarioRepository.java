/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package respositorios;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import objetosnegocio.Usuario;

/**
 *
 * @author Daniel Parra
 */
public class UsuarioRepository extends BaseRepository<Usuario>{

    @Override
    public void guardar(Usuario entidad) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        em.persist(entidad);
        em.getTransaction().commit();
    }

    @Override
    public void eliminar(int id) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Usuario elm = em.find(Usuario.class, id);
        if (elm != null) {
            em.remove(elm);
        }
        em.getTransaction().commit();
    }

    @Override
    public void actualizar(Usuario entidad) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Usuario act = em.find(Usuario.class, entidad.getId());
        if (act != null) {
            act.setAvatar(entidad.getAvatar());
            act.setCiudad(entidad.getCiudad());
            act.setContrasenia(entidad.getContrasenia());
            act.setCorreo(entidad.getCorreo());
            act.setFechaNacimiento(entidad.getFechaNacimiento());
            act.setGenero(entidad.getGenero());
            act.setNombreCompleto(entidad.getNombreCompleto());
            act.setTelefono(entidad.getTelefono());
        }
        em.getTransaction().commit();
    }

    @Override
    public Usuario buscarPorId(int id) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Usuario usr = em.find(Usuario.class, id);
        em.getTransaction().commit();
        return usr;
    }

    @Override
    public ArrayList<Usuario> consultarTodos() {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        
        criteria.select(criteria.from(Usuario.class));
        Query query = em.createQuery(criteria);
        ArrayList<Usuario> todos = new ArrayList(query.getResultList());
        
        em.getTransaction().commit();
        return todos;
    }
    
}

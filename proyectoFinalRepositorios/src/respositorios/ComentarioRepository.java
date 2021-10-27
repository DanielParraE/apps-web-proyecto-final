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
import objetosnegocio.Comentario;

/**
 *
 * @author Daniel Parra
 */
public class ComentarioRepository extends BaseRepository<Comentario>{

    @Override
    public void guardar(Comentario entidad) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        em.persist(entidad);
        em.getTransaction().commit();
    }

    @Override
    public void eliminar(int id) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Comentario elm = em.find(Comentario.class, id);
        if (elm != null) {
            em.remove(elm);
        }
        em.getTransaction().commit();
    }

    @Override
    public void actualizar(Comentario entidad) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Comentario act = em.find(Comentario.class, entidad.getId());
        if (act != null) {
            act.setContenido(entidad.getContenido());
            act.setFechaHora(entidad.getFechaHora().toLocalDateTime());
            act.setPostComun(entidad.getPostComun());
            act.setUsuarioNormal(entidad.getUsuarioNormal());
        }
        em.getTransaction().commit();
    }

    @Override
    public Comentario buscarPorId(int id) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Comentario cmt = em.find(Comentario.class, id);
        em.getTransaction().commit();
        return cmt;
    }

    @Override
    public ArrayList<Comentario> consultarTodos() {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        
        criteria.select(criteria.from(Comentario.class));
        Query query = em.createQuery(criteria);
        ArrayList<Comentario> todos = new ArrayList(query.getResultList());
        
        em.getTransaction().commit();
        return todos;
    }
    
}

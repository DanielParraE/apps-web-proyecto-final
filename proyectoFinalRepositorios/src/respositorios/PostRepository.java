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
import objetosnegocio.Post;

/**
 *
 * @author Daniel Parra
 */
public class PostRepository extends BaseRepository<Post>{

    @Override
    public void guardar(Post entidad) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        em.persist(entidad);
        em.getTransaction().commit();
    }

    @Override
    public void eliminar(int id) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Post elm = em.find(Post.class, id);
        if (elm != null) {
            em.remove(elm);
        }
        em.getTransaction().commit();
    }

    @Override
    public void actualizar(Post entidad) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Post act = em.find(Post.class, entidad.getId());
        if (act != null) {
            act.setContenido(entidad.getContenido());
            act.setFechaHoraCreacion(entidad.getFechaHoraCreacion());
            act.setFechaHoraEdicion(entidad.getFechaHoraEdicion());
            act.setTitulo(entidad.getTitulo());
        }
        em.getTransaction().commit();
    }

    @Override
    public Post buscarPorId(int id) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Post pst = em.find(Post.class, id);
        em.getTransaction().commit();
        return pst;
    }

    @Override
    public ArrayList<Post> consultarTodos() {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        
        criteria.select(criteria.from(Post.class));
        Query query = em.createQuery(criteria);
        ArrayList<Post> todos = new ArrayList(query.getResultList());
        
        em.getTransaction().commit();
        return todos;
    }
    
}

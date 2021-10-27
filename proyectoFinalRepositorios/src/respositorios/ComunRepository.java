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
import objetosnegocio.Comun;

/**
 *
 * @author Daniel Parra
 */
public class ComunRepository extends BaseRepository<Comun>{

    @Override
    public void guardar(Comun entidad) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        em.persist(entidad);
        em.getTransaction().commit();
    }

    @Override
    public void eliminar(int id) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Comun elm = em.find(Comun.class, id);
        if (elm != null) {
            em.remove(elm);
        }
        em.getTransaction().commit();
    }

    @Override
    public void actualizar(Comun entidad) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Comun act = em.find(Comun.class, entidad.getId());
        if (act != null) {
            act.setContenido(entidad.getContenido());
            act.setFechaHoraCreacion(entidad.getFechaHoraCreacion());
            act.setFechaHoraEdicion(entidad.getFechaHoraEdicion());
            act.setTitulo(entidad.getTitulo());
        }
        em.getTransaction().commit();
    }

    @Override
    public Comun buscarPorId(int id) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Comun cmn = em.find(Comun.class, id);
        em.getTransaction().commit();
        return cmn;
    }

    @Override
    public ArrayList<Comun> consultarTodos() {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        
        criteria.select(criteria.from(Comun.class));
        Query query = em.createQuery(criteria);
        ArrayList<Comun> todos = new ArrayList(query.getResultList());
        
        em.getTransaction().commit();
        return todos;
    }
    
}

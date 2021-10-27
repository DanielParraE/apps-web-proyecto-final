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
import objetosnegocio.Anclado;
import objetosnegocio.Comun;

/**
 *
 * @author Daniel Parra
 */
public class AncladoRepository extends BaseRepository<Anclado>{

    @Override
    public void guardar(Anclado entidad) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        em.persist(entidad);
        em.getTransaction().commit();
    }

    @Override
    public void eliminar(int id) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Anclado elm = em.find(Anclado.class, id);
        if (elm != null) {
            em.remove(elm);
        }
        em.getTransaction().commit();
    }

    @Override
    public void actualizar(Anclado entidad) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Anclado act = em.find(Anclado.class, entidad.getId());
        if (act != null) {
            act.setContenido(entidad.getContenido());
            act.setFechaHoraCreacion(entidad.getFechaHoraCreacion());
            act.setFechaHoraEdicion(entidad.getFechaHoraEdicion());
            act.setTitulo(entidad.getTitulo());
        }
        em.getTransaction().commit();
    }

    @Override
    public Anclado buscarPorId(int id) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Anclado anc = em.find(Anclado.class, id);
        em.getTransaction().commit();
        return anc;
    }

    @Override
    public ArrayList<Anclado> consultarTodos() {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        
        criteria.select(criteria.from(Anclado.class));
        Query query = em.createQuery(criteria);
        ArrayList<Anclado> todos = new ArrayList(query.getResultList());
        
        em.getTransaction().commit();
        return todos;
    }
    
}

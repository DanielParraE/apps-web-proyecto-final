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
import objetosnegocio.Admor;

/**
 *
 * @author Daniel Parra
 */
public class AdmorRepository extends BaseRepository<Admor>{

    @Override
    public void guardar(Admor entidad) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        em.persist(entidad);
        em.getTransaction().commit();
    }

    @Override
    public void eliminar(int id) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Admor elm = em.find(Admor.class, id);
        if (elm != null) {
            em.remove(elm);
        }
        em.getTransaction().commit();
    }

    @Override
    public void actualizar(Admor entidad) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Admor act = em.find(Admor.class, entidad.getId());
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
    public Admor buscarPorId(int id) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Admor adm = em.find(Admor.class, id);
        em.getTransaction().commit();
        return adm;
    }

    @Override
    public ArrayList<Admor> consultarTodos() {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        
        criteria.select(criteria.from(Admor.class));
        Query query = em.createQuery(criteria);
        ArrayList<Admor> todos = new ArrayList(query.getResultList());
        
        em.getTransaction().commit();
        return todos;
    }
    
}

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
import objetosnegocio.Normal;

/**
 *
 * @author Daniel Parra
 */
public class NormalRepository extends BaseRepository<Normal>{

    @Override
    public void guardar(Normal entidad) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        em.persist(entidad);
        em.getTransaction().commit();
    }

    @Override
    public void eliminar(int id) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Normal elm = em.find(Normal.class, id);
        if (elm != null) {
            em.remove(elm);
        }
        em.getTransaction().commit();
    }

    @Override
    public void actualizar(Normal entidad) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Normal act = em.find(Normal.class, entidad.getId());
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
    public Normal buscarPorId(int id) {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Normal nrm = em.find(Normal.class, id);
        em.getTransaction().commit();
        return nrm;
    }

    @Override
    public ArrayList<Normal> consultarTodos() {
        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        
        criteria.select(criteria.from(Normal.class));
        Query query = em.createQuery(criteria);
        ArrayList<Normal> todos = new ArrayList(query.getResultList());
        
        em.getTransaction().commit();
        return todos;
    }
    
}

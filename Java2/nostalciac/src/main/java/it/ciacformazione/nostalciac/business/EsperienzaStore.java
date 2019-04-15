/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.business;

import it.ciacformazione.nostalciac.entity.Esperienza;
import it.ciacformazione.nostalciac.entity.Tag;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class EsperienzaStore {
    
    @PersistenceContext
    EntityManager em;
    
    public Esperienza find(Integer id) {
        return em.find(Esperienza.class, id);
    }
    
    public Esperienza save(Esperienza e) {
        return em.merge(e);
    }
    
    public void remove(Integer id) {
        em.remove(find(id));
    }
    
    public List<Esperienza> findAll() {
        return em.createQuery("select e from Esperienza e order by e.fine desc", Esperienza.class)
                .getResultList();
    }
    
    public List<Esperienza> findByAnag(Integer anagId){
                            //select e from Corso e where e.sede.id= :sede_id order by e.nome
        return em.createQuery("select e from Esperienza e where e.anagrafica.id=:anag_id order by e.fine desc", Esperienza.class)
                .setParameter("anag_id", anagId)
                .getResultList();
    }

    public List<Tag> findTags(Integer id) {
               
       return em.createQuery("select e.tags from Esperienza e where e.id = :idEsp", Tag.class)
               .setParameter("idEsp", id)
               .getResultList();
    }
        
    
}

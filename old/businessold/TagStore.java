/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nostalciac.business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import nostalciac.entity.Tag;

/**
 *
 * @author tss
 */
@Stateless
public class TagStore {
    
    @PersistenceContext()
    EntityManager em;
    
    /**
     * 
     * @return 
     */
    public List<Tag> all() {
        return em.createQuery("select e From Tag e ORDER BY e.tag", Tag.class)
                .getResultList();
    }
    

    /**
     * Insert o update
     * @param tag
     * @return 
     */
    public Tag save (Tag tag) {
       //se esiste aggiorna altrimenti inserisce
        return em.merge(tag);
        
    }

    public Tag find(int id) {
        return em.find(Tag.class, id);
    }
    /**
     * rimuove da db il tag tramite id
     * prima lo cerca
     * @param id 
     */
    public void remove(int id) {
        Tag toremove = em.find(Tag.class, id);
        //sarebbe da controllare se toremove is null
        em.remove(toremove);
    }
    /**
     * restituisce i tag trovati in base alla ricerca
     * @param searchTag
     * @param searchTipo
     * @return 
     */
    public List<Tag> search(String searchTag, String searchTipo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        
        CriteriaQuery<Tag> query = cb.createQuery(Tag.class);
        
        Root<Tag> root = query.from(Tag.class);
        
        Predicate condition = cb.conjunction();
        
        if (searchTag != null && !searchTag.isEmpty()) {
            condition = cb.and(condition,cb.like(root.get("tag"), "%" + searchTag + "%"));
        }
        if (searchTipo != null && !searchTipo.isEmpty()) {
            condition = cb.and(condition,cb.like(root.get("tipo"), "%" + searchTipo + "%"));
        }
        
        query.select(root)
                .where(condition)
                .orderBy(cb.asc(root.get("tipo")));
        
        return em.createQuery(query)
                .getResultList();
                //cb.equal(root, root) query.where(prdcts)
    }
}

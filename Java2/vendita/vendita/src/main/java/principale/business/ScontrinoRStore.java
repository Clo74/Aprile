/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principale.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import principale.entity.ScontrinoR;

/**
 *
 * @author tss
 */
@Stateless
public class ScontrinoRStore {

    @PersistenceContext
    EntityManager em;

    public ScontrinoRStore() {

    }

    public List<ScontrinoR> findAll(Integer idTesta) {
        return em.createQuery("select r from ScontrinoR r where r.testa.id = :idTesta order by r.id", ScontrinoR.class)
                .setParameter("idTesta", idTesta)
                .getResultList();
    }

    public ScontrinoR find(int id) {
        return em.find(ScontrinoR.class, id);
    }

    public ScontrinoR update(ScontrinoR scontR) {
        return em.merge(scontR);
    }

    public void delete(int id) {
        em.remove(this.find(id));
    }

}

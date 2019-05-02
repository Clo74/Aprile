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
import principale.entity.ScontrinoT;

/**
 *
 * @author tss
 */
@Stateless
public class ScontrinoTStore {

    @PersistenceContext
    EntityManager em;

    public ScontrinoTStore() {
    }
    
    public List<ScontrinoT> findAll(){
        return em.createQuery("select s from ScontrinoT s order by s.data desc", ScontrinoT.class)
                .getResultList();
    }

    public ScontrinoT find(int id) {
        return em.find(ScontrinoT.class, id);
    }
    
    public ScontrinoT update(ScontrinoT scont) {
        return em.merge(scont);
    }
    
    public void delete(int id) {
        em.remove(this.find(id));
    }
    
    public List<ScontrinoT> findByNeg(Integer idNeg){
        return em.createQuery("select s from t_scontrini_testa s Where s.id_negozio = ':idNeg' ORDER by s.data_scontrino desc",ScontrinoT.class)
                .setParameter("idNeg", idNeg)
                .getResultList();
    }


}

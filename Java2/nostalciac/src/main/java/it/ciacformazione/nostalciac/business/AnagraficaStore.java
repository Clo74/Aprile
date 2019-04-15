/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.business;

import it.ciacformazione.nostalciac.entity.Anagrafica;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class AnagraficaStore {

    @PersistenceContext
    EntityManager em;
//quando ritorno un oggetto che potrebbe essere null posso usare optional
    public Optional<Anagrafica> login(String usr, String pwd) {

        try {
            Anagrafica p = em.createQuery("select e from Anagrafica e where e.usr= :usr and e.pwd= :pwd", Anagrafica.class)
                    .setParameter("usr", usr)
                    .setParameter("pwd", pwd)
                    .getSingleResult();
            return Optional.of(p);
                } catch (NoResultException | NonUniqueResultException ex) {
            return Optional.empty();
        }
    }

    public Anagrafica find(Integer id) {
        return em.find(Anagrafica.class, id);
    }

    public Anagrafica save(Anagrafica c) {
        return em.merge(c);
    }

    public void remove(Integer id) {
        em.remove(find(id));
    }

    public List<Anagrafica> findAll() {
        return em.createQuery("select a from Anagrafica a order by a.cognome, a.nome", Anagrafica.class)
                .getResultList();
    }
}

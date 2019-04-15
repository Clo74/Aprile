/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nostalciac.business;

import java.io.Console;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nostalciac.entity.Sede;

/**
 *
 * @author tss
 */
@Stateless
public class SedeStore {

    @PersistenceContext()
    EntityManager em;

    public List<Sede> all() {
        return em.createQuery("Select s from Sede s order by s.nome")
                .getResultList();
    }

    /**
     * inserisce o aggiorna in un unico
     *
     * @param sede
     * @return
     */
    public Sede save(Sede sede) {
        return em.merge(sede);
    }

    public Sede find(int id) {
        return em.find(Sede.class, id);
    }

    public void remove(int id) {
        Sede sede = em.find(Sede.class, id);
        if (sede != null) {
            em.remove(sede);
        }
    }

    public List<Sede> search(String nome, String citta) {
        String strSql = "";
//        if (nome != null || !nome.isEmpty()  || citta != null || !citta.isEmpty()) {
//            strSql = " WHERE ";

        if (nome != null && !nome.isEmpty()) {
            strSql = " s.nome like '%" + nome + "%'";
            if (citta != null && !citta.isEmpty()) {
                strSql += " and s.citta like '%" + citta + "%'";
            }

        } else {
            if (citta != null && !citta.isEmpty()) {
                strSql += " s.citta like '%" + citta + "%'";
            }
        }
        //("Select s from Sede s where " + strSql + " order by s.nome");
        return em.createQuery("Select s from Sede s where " + strSql + " order by s.nome")
                .getResultList();
    }
}

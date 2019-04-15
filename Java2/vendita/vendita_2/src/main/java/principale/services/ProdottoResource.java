/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principale.services;

import javax.inject.Inject;
import javax.ws.rs.GET;
import principale.business.ProdottoStore;
import principale.entity.Prodotto;

/**
 *
 * @author tss
 */

public class ProdottoResource {

//    ProdottoStore prodottoStore = new ProdottoStore();
    
    @Inject
    ProdottoStore store;
//    
    private int id;
    
    @GET
    public Prodotto findR() {
        return store.find(id);
    }
//    @GET
//    public String findR() {
//        return "CIAO";
//    }
    
    
    public void setId(int id) {
        this.id = id;
    }    

//    private ProdottoStore lookupProdottoStoreBean() {
//        try {
//            Context c = new InitialContext();
//            return (ProdottoStore) c.lookup("java:global/com.mycompany_vendita_2_war_1.0-SNAPSHOT/ProdottoStore!principale.business.ProdottoStore");
//        } catch (NamingException ne) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
//            throw new RuntimeException(ne);
//        }
//    }
}

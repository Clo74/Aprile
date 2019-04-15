/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noleggio.services;

import java.util.List;
import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import noleggio.business.BiciclettaStore;
import noleggio.entity.Bicicletta;

/**
 *
 * @author tss
 */
@Path("biciclette")
public class BiciclettaResources {
       
    //il controllo delle istanze è gestito da payara è essenziale avere il file beans.xml
    @Inject
    BiciclettaStore store;
    //posso tornare un json o una lista, sarà payara a convertirlo in json (non sempre funziona)
    @GET
    public List<Bicicletta> findAll() {
        return store.all();
    }

}

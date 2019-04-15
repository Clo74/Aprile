/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nostalciac.services;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import nostalciac.business.SedeStore;
import nostalciac.business.TagStore;
import nostalciac.entity.Sede;
import nostalciac.entity.Tag;

/**
 *
 * @author tss
 */
@Path("sedi")
public class SediResource {

    @Inject
    SedeStore store;

    @GET
    public List<Sede> findAll(){
        return store.all();
    }
    
    @GET
    @Path("{id}")
    public Sede find(@PathParam("id") int id) {
        return store.find(id);
    }    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Sede sede) {
        store.save(sede);
    }
    
    @GET
    @Path("search")
    public List<Sede> search(@QueryParam("nome") String nome,
            @QueryParam("citta") String citta) {
        return store.search(nome,citta);
    }
        
}

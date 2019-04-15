/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.AnagraficaStore;
import it.ciacformazione.nostalciac.business.EsperienzaStore;
import it.ciacformazione.nostalciac.entity.Anagrafica;
import it.ciacformazione.nostalciac.entity.Esperienza;
import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author tss
 */
@Path("esperienze")
public class EsperienzeResource {
    
    @Inject
    EsperienzaStore store;
    
    @Inject
    AnagraficaStore anagraficaStore;

    private Integer anagId;
    
    @Context
    ResourceContext rc;    
    
    @GET
    public List<Esperienza> findAll() {
        return store.findByAnag(anagId);
    }    
    
    @Path("{id}")
    public EsperienzaResource find(@PathParam("id") Integer id) {
        EsperienzaResource resource = rc.getResource(EsperienzaResource.class);
        resource.setId(id);
        resource.setAnagId(id);
        return resource;
        
    }    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Esperienza e, @Context UriInfo uriInfo) {
        Anagrafica anag = anagraficaStore.find(anagId);
        e.setAnagrafica(anag);
        Esperienza saved = store.save(e);
        URI uri = uriInfo.getAbsolutePathBuilder()
                .path("/" + saved.getId())
                .build();
        return Response.ok(uri).build();

    }
    

        
    public void setAnagId(Integer anagId) {
        this.anagId= anagId;
    }
}

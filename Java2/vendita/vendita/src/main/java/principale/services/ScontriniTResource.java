/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principale.services;

import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import principale.business.ScontrinoTStore;
import principale.entity.ScontrinoT;

/**
 *
 * @author tss
 */

@Path("/scontriniT")
public class ScontriniTResource {
 
    @Inject
    ScontrinoTStore store;
    
    @Context
    ResourceContext rc;
    
        
    @GET
    public List<ScontrinoT> findAll() {
        return store.findAll();
    }

    @GET
    @Path("{id}")
    public ScontrinoT find(@PathParam("id") Integer id) {
        return store.find(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(ScontrinoT s, @Context UriInfo uriInfo) {
        ScontrinoT saved = store.update(s);
        URI uri = uriInfo.getAbsolutePathBuilder()
                .path("/" + saved.getId())
                .build();
        return Response.ok(uri).build();
    }

    @PUT
    @Path("{id}")
    public void update(@PathParam("id") Integer id, ScontrinoT c) {
        c.setId(id);
        store.update(c);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
        store.delete(id);
    }    

}

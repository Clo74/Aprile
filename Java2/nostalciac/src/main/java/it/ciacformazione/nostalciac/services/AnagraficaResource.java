/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.AnagraficaStore;
import it.ciacformazione.nostalciac.business.EsperienzaStore;
import it.ciacformazione.nostalciac.business.TagStore;
import it.ciacformazione.nostalciac.entity.Anagrafica;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
public class AnagraficaResource {

    @Inject
    private EsperienzaStore esperStore;

    @Inject
    private TagStore tagStore;

    @Inject
    private AnagraficaStore store;

    private Integer id;

    @Context
    ResourceContext rc;

    @GET
    public Anagrafica find() {
        return store.find(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Anagrafica a) {
        a.setId(id);
        store.save(a);
    }

    @DELETE
    public void delete() {
        store.remove(id);
    }

    @Path("esperienze")
    public EsperienzeResource getEsperienze() {
        EsperienzeResource resource = rc.getResource(EsperienzeResource.class);
        resource.setAnagId(id);
        return resource;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

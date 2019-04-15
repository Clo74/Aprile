/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.AnagraficaStore;
import it.ciacformazione.nostalciac.business.EsperienzaStore;
import it.ciacformazione.nostalciac.business.TagStore;
import it.ciacformazione.nostalciac.entity.Esperienza;
import it.ciacformazione.nostalciac.entity.Tag;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
public class EsperienzaResource {

    @Inject
    EsperienzaStore store;

    @Inject
    AnagraficaStore anagraficaStore;

    @Inject
    TagStore tagStore;

    private Integer anagId;

    private Integer id;

    @Context
    ResourceContext rc;

    @GET
    public Esperienza find() {
        return store.find(id);
    }

    @PUT
    public void update(Esperienza e) {
        e.setAnagrafica(anagraficaStore.find(anagId));
        store.save(e);
    }

    @DELETE
    public void delete(@PathParam("id") Integer id) {
        store.remove(id);
    }

    @GET
    @Path("tags")
    public List<Tag> findTags() {
        return store.findTags(id);
    }

    @PUT
    @Path("tags")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTags(List<Integer> idTags) {
        Esperienza finded = store.find(id);
        Set<Tag> tosave = idTags.stream()
                .map(t -> tagStore.find(t))
                .collect(Collectors.toSet());
        finded.setTags(tosave);
        store.save(finded);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAnagId(Integer id) {
        this.anagId = id;
    }

}

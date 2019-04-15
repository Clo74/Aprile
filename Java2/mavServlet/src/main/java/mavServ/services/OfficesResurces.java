/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mavServ.services;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import mavServ.business.CustomerStore;
import mavServ.business.OfficesStore;
import mavServ.model.Offices;

/**
 *
 * @author tss
 */
@Path("/offices")
public class OfficesResurces {
    
    @Inject
    private OfficesStore manager;
    
    @GET
    public List<Offices> all(){
        return manager.findAll();
    }
    
    @GET
    @Path("/searchCity")
    public List<Offices> offByName(@QueryParam("city") String city) {
        return manager.findCity(city);
    }
}

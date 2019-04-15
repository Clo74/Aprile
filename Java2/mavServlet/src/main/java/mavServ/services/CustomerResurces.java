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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import mavServ.business.CustomerStore;
import mavServ.model.Customer;

/**
 *
 * @author tss
 */
@Path("/customers")
public class CustomerResurces {
    
    //mi viene fornito dal web server un oggetto dbmanager
    @Inject
    CustomerStore manager;
    
    @GET
    public List<Customer> all() {
        return manager.findAll();
    }
    
    //qui mappo il parametro passato con /parametro nell'url
    //api/customers/121
    @GET
    @Path("{id}")
    public Customer find(@PathParam("id") int id){
        return manager.find(id);
    }
    
    //qui mappo il parametro passato con api/customers/search?name=a
    @GET
    @Path("search")
    public List<Customer> searchByName(@QueryParam("name") String name){
        return manager.searchCustormer(name);
    }
}

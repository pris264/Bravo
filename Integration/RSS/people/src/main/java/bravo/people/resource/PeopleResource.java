/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.people.resource;

import javax.ws.rs.Path;
import bravo.people.ejb.*;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Dillon
 */
@Path("people")
public class PeopleResource {
    @EJB
    private PeopleBean peopleBean;
    
    @GET
    @Path("createPerson")
    public void createPerson() {
        peopleBean.createPerson("Dillon", "Heins", "14035538");
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("getFirstName")
    public String getFirstName() {
        return peopleBean.getFirstName();
    }
}

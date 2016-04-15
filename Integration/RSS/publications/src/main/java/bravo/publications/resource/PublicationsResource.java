/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.publications.resource;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import bravo.publications.ejb.*;

/**
 *
 * @author Dillon
 */

@Path("publications")
public class PublicationsResource {
    @EJB
    private PublicationsBean publicationsBean;
    
    @GET
    @Path("createPublication")
    public void createPublication() {
        publicationsBean.createPublication("Publications Title vol. 1", "14035538");
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("getTitle")
    public String getTitle() {
        String publications = "";
        
        for (int i = 0; i < publicationsBean.getTitle("14035538").size(); ++i) {
            publications += publicationsBean.getTitle("14035538").get(i) + "\n";
        }
        
        return publications;
    }
}

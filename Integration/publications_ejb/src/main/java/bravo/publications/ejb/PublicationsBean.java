package bravo.publications.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import bravo.publications.entity.*;
import java.util.List;

/**
 *
 * @author Dillon
 */
@Stateless
@LocalBean
public class PublicationsBean {
    public void createPublication(String title, String staffNumber) {
        PublicationEntity publication = new PublicationEntity(title, staffNumber);
        em.persist(publication);
    }
    
    public List<String> getTitle(String staffNumber) {
        List<String> title = (List<String>) em.createNamedQuery("getTitle").getResultList();
        return title;
    }
    
    @PersistenceContext
    private EntityManager em;
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.people.ejb;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import bravo.people.entity.*;

/**
 *
 * @author Dillon
 */
@Stateless
//@LocalBean
public class PeopleBean {
    public void createPerson(String firstName, String surname, String staffNumber) {
        PersonEntity person = new PersonEntity(firstName, surname, staffNumber);
        em.persist(person);
    }

    public String getFirstName() {
        String firstName = (String) em.createNamedQuery("getFirstName").getSingleResult();
        return firstName;
    }
    
    @PersistenceContext
    private EntityManager em;
}

/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package main.ejb;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import main.entity.Publication;

/**
 * DukesBirthdayBean is a stateless session bean that calculates the age
 * difference between a user and Duke, who was born on May 23, 1995.
 */
@Stateless
public class PublicationBean {

    private static final Logger logger
            = Logger.getLogger("main.ejb.PublicationBean");

    @PersistenceContext
    private EntityManager em;

    public void createPublication() {
        String title = "A Comprehensive Experiment on Jargon";
        String staffNumber = "14035538";
        Publication publication = new Publication(title, staffNumber);

        em.persist(publication);
    }
    
    public String getTitle() {
        String title = (String) em.createNamedQuery("getTitle").getSingleResult();
        return title;
    }
}

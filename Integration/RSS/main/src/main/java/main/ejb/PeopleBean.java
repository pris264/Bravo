/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package main.ejb;

import main.entity.Person;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
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
public class PeopleBean {

    private static final Logger logger
            = Logger.getLogger("main.ejb.PeopleBean");

    @PersistenceContext
    private EntityManager em;

    public Double getAverageAgeDifference() {
        Double avgAgeDiff = (Double) em.createNamedQuery("findAverageAgeDifferenceOfAllUsers")
                .getSingleResult();
        logger.log(Level.INFO, "Average age difference is: {0}", avgAgeDiff);
        return avgAgeDiff;
    }

    public int getAgeDifference(Date date) {
        int ageDifference;
        Calendar theirBirthday = new GregorianCalendar();
        Calendar dukesBirthday = new GregorianCalendar(1995, Calendar.MAY, 23);
        // Set the Calendar object to the passed-in Date
        theirBirthday.setTime(date);
        // Subtract the user's age from Duke's age
        ageDifference = dukesBirthday.get(Calendar.YEAR)
                - theirBirthday.get(Calendar.YEAR);
        logger.log(Level.INFO, "Raw ageDifference is: {0}", ageDifference);
        // Check to see if Duke's birthday occurs before the user's. If so,
        // subtract one from the age difference
        if (dukesBirthday.before(theirBirthday) && (ageDifference > 0)) {
            ageDifference--;
        }
        // Create and store the user's birthday in the database
        Person user = new Person(date, ageDifference);
        em.persist(user);
        logger.log(Level.INFO, "Final ageDifference is: {0}", ageDifference);
        return ageDifference;
    }
    
//    public void createPublication() {
//        String title = "A Comprehensive Experiment on Jargon";
//        String staffNumber = "14035538";
//        Publication publication = new Publication(title, staffNumber);
//        
//        em.persist(publication);
//    }
}

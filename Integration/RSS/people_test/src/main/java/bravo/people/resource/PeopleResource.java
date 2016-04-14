/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package bravo.people.resource;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 */
@Path("people")
public class PeopleResource {
    public class Duke {
        private int age;
        
        public Duke(int age) {
            this.age = age;
        }
    }
    
    /**
     * Creates a new instance of DukesAgeResource
     */
    public PeopleResource() {
    }

    /**
     * Retrieves representation of an instance of DukesAgeResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("getPerson")
    public JsonObject getText() {
        // Create a new Calendar for Duke's birthday
        Calendar dukesBirthday = new GregorianCalendar(1995, Calendar.MAY, 23);
        // Create a new Calendar for today
        Calendar now = GregorianCalendar.getInstance();
        // Subtract today's year from Duke's birth year, 1995
        int dukesAge = now.get(Calendar.YEAR) - dukesBirthday.get(Calendar.YEAR);
        dukesBirthday.add(Calendar.YEAR, dukesAge);
        // If today's date is before May 23, subtract a year from Duke's age
        if (now.before(dukesBirthday)) {
            dukesAge--;
        }
        // Return a String representation of Duke's age
        
        return Json.createObjectBuilder().add("age", String.valueOf(dukesAge)).add("surname", "bob").build();
//        return "" + dukesAge;
    }
}

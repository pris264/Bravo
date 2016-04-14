/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package main.web;

import main.ejb.PeopleBean;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.validation.constraints.NotNull;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import main.ejb.PublicationBean;

@Named
@SessionScoped
public class MainWeb implements Serializable {

    @EJB
    private PeopleBean peopleBean;
    @EJB
    private PublicationBean publicationBean;
    protected int age;
    protected String title;
    private String surname;
    @NotNull
    protected Date yourBD;
    protected int ageDiff;
    protected int absAgeDiff;
    protected Double averageAgeDifference;
    private static final Logger logger = Logger.getLogger("main.web.MainWeb");

    /**
     * Creates a new instance of DukesBDay
     */
    public MainWeb() {
    }

    public String processBirthday() {
        this.setAgeDiff(peopleBean.getAgeDifference(yourBD));
        logger.log(Level.INFO, "age diff from dukesbday {0}", ageDiff);
        this.setAbsAgeDiff(Math.abs(this.getAgeDiff()));
        logger.log(Level.INFO, "absAgeDiff {0}", absAgeDiff);
        this.setAverageAgeDifference(peopleBean.getAverageAgeDifference());
        logger.log(Level.INFO, "averageAgeDifference {0}", averageAgeDifference);
        
        publicationBean.createPublication();
        this.setTitle(publicationBean.getTitle());
        
        return "/response.xhtml";
    }
    
    /**
     * Get the value of age
     *
     * @return the value of age
     */
    public String getAge() {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target
                    = client.target("http://localhost:8080/webapi/people/getPerson");
//          String response = target.request().get(String.class);
            
            JsonObject response = target.request().get(JsonObject.class);

            age = Integer.parseInt(response.getString("age"));
            
            surname = response.getString("surname");
        } catch (IllegalArgumentException | NullPointerException |
                WebApplicationException ex) {
            logger.severe("processing of HTTP response failed");
        }
        return "" + age;
    }

    /**
     * Set the value of age
     *
     * @param age new value of age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    /**
     * Get the value of yourBD
     *
     * @return the value of yourBD
     */
    public Date getYourBD() {
        return yourBD;
    }

    /**
     * Set the value of yourBD
     *
     * @param yourBD new value of yourBD
     */
    public void setYourBD(Date yourBD) {
        this.yourBD = yourBD;
    }

    /**
     * Get the value of ageDiff
     *
     * @return the value of ageDiff
     */
    public int getAgeDiff() {
        return ageDiff;
    }

    /**
     * Set the value of ageDiff
     *
     * @param ageDiff new value of ageDiff
     */
    public void setAgeDiff(int ageDiff) {
        this.ageDiff = ageDiff;
    }

    /**
     * Get the value of absAgeDiff
     *
     * @return the value of absAgeDiff
     */
    public int getAbsAgeDiff() {
        return absAgeDiff;
    }

    /**
     * Set the value of absAgeDiff
     *
     * @param absAgeDiff new value of absAgeDiff
     */
    public void setAbsAgeDiff(int absAgeDiff) {
        this.absAgeDiff = absAgeDiff;
    }

    /**
     * Get the value of averageAgeDifference
     *
     * @return the value of averageAgeDifference
     */
    public Double getAverageAgeDifference() {
        return averageAgeDifference;
    }

    /**
     * Set the value of averageAgeDifference
     *
     * @param averageAgeDifference new value of averageAgeDifference
     */
    public void setAverageAgeDifference(Double averageAgeDifference) {
        this.averageAgeDifference = averageAgeDifference;
    }

}

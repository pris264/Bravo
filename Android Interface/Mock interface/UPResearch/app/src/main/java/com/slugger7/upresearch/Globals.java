package com.slugger7.upresearch;

import org.json.JSONObject;

/**
 * Created by Slugger7 on 4/14/2016.
 */
public class Globals {
    private static String Name = "";
    private static String Surname = "";
    private static String Cellphone = "";
    private static Boolean Notifications = true;
    private static String Email = "";
    private static String Username = "";
    private static String Staffnumber = "";

    public static String getName()
    {
        return Name;
    }

    public static String getSurname()
    {
        return Surname;
    }

    public static String getCellphone()
    {
        return Cellphone;
    }

    public static Boolean getNotifications()
    {
        return Notifications;
    }

    public static String getEmail()
    {
        return Email;
    }

    public static String getUsername()
    {
        return Username;
    }

    public static String getStaffnumber()
    {
        return Staffnumber;
    }

    public static void setName(String name)
    {
        Name = name;
    }

    public static void setSurname(String surname)
    {
        Surname = surname;
    }

    public static void setCellphone(String cellphone)
    {
        Cellphone = cellphone;
    }

    public static void setNotifications(Boolean notification)
    {
        Notifications = notification;
    }

    public static void setEmail(String email)
    {
        Email = email;
    }

    public static void setUsername(String username)
    {
        Username = username;
    }

    public static void setStaffnumber(String staffnumber)
    {
        Staffnumber = staffnumber;
    }

    public static Boolean validate()
    {
        if (getName().length() == 0)
            return false;
        if (getSurname().length() == 0)
            return false;
        if  (getCellphone().length() == 0)
            return false;
        if (getEmail().length() == 0)
            return false;
        if (getUsername().length() == 0)
            return false;
        if (getStaffnumber().length() == 0)
            return false;

        return true;
    }

    public static void updateData() {

        //TODO send data to server for update
    }

    public static String getJson()
    {
        return "{name : '" + getName() +
                "', surname : '" + getSurname() +
                "', email : '" + getEmail() +
                "', staffnumber : '" + getStaffnumber() +
                "', notifications : '" + getNotifications() +
                "', username : '" + getUsername() +
                "', cellphone : '" + getCellphone() + "'}";
    }
}

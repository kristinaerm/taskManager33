/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;

/**
 *
 * @author Кристина
 */
public class DataCheck {
    private SimpleDateFormat dateTimeFormatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm");
    public static boolean nameCheck(String name)
    {
        if(name.length()>15)
        {
            return false;
        }
        return true;
    }
    public static boolean descriptionCheck(String description)
    {
        if(description.length()>30)
        {
            return false;
        }
        return true;
    }
    public static boolean contactsCheck(String contacts)
    {
        if(contacts.length()>15)
        {
            return false;
        }
        return true;
    }
    
    public static boolean timeCheck(String time)
    {
//        if()
//        {
//            return false
//        }
        return true;
    }
}

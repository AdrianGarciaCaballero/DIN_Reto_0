/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ResourceBundle;

/**
 *
 * @author 2dam
 */
public class UserManagerFactory {
    
      private static String readFrom =  ResourceBundle.getBundle("config/config").getString("readFrom");

    public static DataAccessible getObjectType() {
        
        if (readFrom.equals("db")) {
            System.out.println("Hi from db");
            return new DBUserDataAccessor();
        } else if (readFrom.equals("file")) {
             System.out.println("Hi from file");

            return new FileUserDataAccessor();
        }
        return null;
    }
}

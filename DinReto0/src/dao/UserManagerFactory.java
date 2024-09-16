/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author 2dam
 */
public class UserManagerFactory {
    
      private static Boolean isDB = true;

    public static DataAccessible getUserInfo() {
        
        if (isDB) {
            isDB = false;
            return new DBUserDataAccessor();
        } else {
            isDB = true;
            return new FileUserDataAccessor();
        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessTier;

import Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Class responsible for accessing user data from a file using {@link ResourceBundle}.
 * Implements {@link DataAccessible} to provide a way to fetch user information stored in a properties file.
 * User data includes name, username, password, DNI, and balance.
 * 
 * @version 1.0
 * @author Adrian and Omar
 */
public class FileUserDataAccessor implements DataAccessible {

    /**
     * Retrieves user data from a properties file.
     * The data is fetched using {@link ResourceBundle}, which accesses user details stored in a file.
     * 
     * @return {@link User} object populated with the fetched data from the properties file
     */
    @Override
    public User getUserData() {
        // Fetch user data from the properties file using ResourceBundle
        String dni = ResourceBundle.getBundle("Database/userData").getString("dni");
        String name = ResourceBundle.getBundle("Database/userData").getString("name");
        String userName = ResourceBundle.getBundle("Database/userData").getString("userName");
        String password = ResourceBundle.getBundle("Database/userData").getString("password");
        double balance = Double.parseDouble(ResourceBundle.getBundle("Database/userData").getString("balance"));

        // Return a new User object with the retrieved data
        return new User(name, userName, password, dni, balance);
    }
}

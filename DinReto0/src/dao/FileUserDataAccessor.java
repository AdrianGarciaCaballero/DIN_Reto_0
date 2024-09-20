/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author 2dam
 */
public class FileUserDataAccessor implements DataAccessible {

    @Override
    public User getUserData() {

        User userData = null;

        // Accessing the properties
        String dni = ResourceBundle.getBundle("Database/userData").getString("dni");
        String name = ResourceBundle.getBundle("Database/userData").getString("name");
        String userName = ResourceBundle.getBundle("Database/userData").getString("userName");
        String password = ResourceBundle.getBundle("Database/userData").getString("password");
        double balance = Double.parseDouble(ResourceBundle.getBundle("Database/userData").getString("balance"));

        userData = new User(name, userName, password, dni, balance);

        System.out.println(userData.toString());

        return userData;
    }

}

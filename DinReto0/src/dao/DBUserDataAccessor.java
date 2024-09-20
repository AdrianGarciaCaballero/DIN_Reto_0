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

/**
 *
 * @author 2dam
 */
public class DBUserDataAccessor implements DataAccessible {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/userdb?serverTimezone=Europe/Madrid&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "abcd*1234";

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    final String getUserData = "SELECT * FROM User";

    @Override
    public User getUserData() {

        User userData = null;

        try {
            this.openConnection();

            statement = connection.prepareStatement(getUserData);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String dni = resultSet.getString("dni");
                String userName = resultSet.getString("username");
                String name = resultSet.getString("nombre");
                String  password = resultSet.getString("password");
                double balance = resultSet.getDouble("balance");

                userData = new User(name, userName, password, dni, balance);
                
                System.out.println(userData.toString());

            }
        } catch (SQLException e) {
            System.out.println("Error de SQL");
            e.printStackTrace();
        } finally {
            closeConnection();
            ;
        }
        return userData;
    }

    private void openConnection() {
        try {
            // String url =
            // "jdbc:mysql://localhost:3306/usuarios?serverTimezone=Europe/Madrid&useSSL=false";
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Open Connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            System.out.println("Close Connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

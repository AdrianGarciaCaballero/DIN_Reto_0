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
import java.util.logging.Logger;

/**
 * Class responsible for accessing user data from the database.
 * Implements {@link DataAccessible} interface to fetch user information from the database.
 * Manages database connections and query execution to retrieve user details such as name, username, password, DNI, and balance.
 * 
 * @version 1.0
 * @author Adrian & Omar
 */
public class DBUserDataAccessor implements DataAccessible {

    // Database URL, username, and password for MySQL connection
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/userdb?serverTimezone=Europe/Madrid&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "abcd*1234";

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    // SQL query to retrieve user data from the User table
    private final String GETUSERDATAQUERY = "SELECT * FROM User";

    /**
     * Retrieves user data from the database.
     * Executes an SQL query to fetch the user's name, username, password, DNI, and balance.
     * 
     * @return {@link User} object populated with the fetched data from the database
     * @throws SQLException if a database access error occurs
     */
    @Override
    public User getUserData() {

        User userData = null;

        try {
            this.openConnection();

            // Prepare and execute the SQL query to fetch user data
            statement = connection.prepareStatement(GETUSERDATAQUERY);
            resultSet = statement.executeQuery();

            // Process the result set and populate the User object
            while (resultSet.next()) {
                String dni = resultSet.getString("dni");
                String userName = resultSet.getString("username");
                String name = resultSet.getString("nombre");
                String password = resultSet.getString("password");
                double balance = resultSet.getDouble("balance");

                // Initialize the User object with fetched data
                userData = new User(name, userName, password, dni, balance);
            }

        } catch (SQLException e) {
            // Log any SQL exception that occurs
            Logger.getLogger(DBUserDataAccessor.class.getName()).severe(e.getLocalizedMessage());
        } finally {
            // Ensure the database connection is closed
            closeConnection();
        }

        return userData;
    }

    /**
     * Opens a connection to the database.
     * Establishes a connection using the specified database URL, username, and password.
     * 
     * @throws SQLException if a database access error occurs while connecting
     */
    private void openConnection() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            Logger.getLogger(DBUserDataAccessor.class.getName()).info("Connection opened");
        } catch (SQLException e) {
            Logger.getLogger(DBUserDataAccessor.class.getName()).severe(e.getLocalizedMessage());
        }
    }

    /**
     * Closes the database connection and other resources.
     * Ensures that the {@link PreparedStatement} and {@link Connection} objects are properly closed to prevent memory leaks.
     * 
     * @throws SQLException if a database access error occurs while closing the resources
     */
    private void closeConnection() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            Logger.getLogger(DBUserDataAccessor.class.getName()).info("Connection closed");
        } catch (SQLException e) {
            Logger.getLogger(DBUserDataAccessor.class.getName()).severe(e.getLocalizedMessage());
        }
    }
}

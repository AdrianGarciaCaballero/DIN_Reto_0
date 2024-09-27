/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessTier;

import java.util.ResourceBundle;

/**
 * Factory class responsible for creating an instance of {@link DataAccessible}.
 * Based on the configuration, it decides whether to fetch user data from a database or a file.
 * The configuration is read from a properties file using {@link ResourceBundle}.
 * 
 * @version 1.0
 * @author Adrian and Omar
 */
public class UserManagerFactory {

    // Configured source to read user data from, either "db" or "file"
    private static String readFrom = ResourceBundle.getBundle("config/config").getString("readFrom");

    /**
     * Returns an instance of {@link DataAccessible} based on the configuration.
     * If the configuration specifies "db", it returns a {@link DBUserDataAccessor} instance.
     * If it specifies "file", it returns a {@link FileUserDataAccessor} instance.
     * 
     * @return {@link DataAccessible} implementation based on the configured data source
     */
    public static DataAccessible getDataAccessible() {
        if (readFrom.equals("db")) {
            return new DBUserDataAccessor();
        } else if (readFrom.equals("file")) {
            return new FileUserDataAccessor();
        }
        return null;
    }
}

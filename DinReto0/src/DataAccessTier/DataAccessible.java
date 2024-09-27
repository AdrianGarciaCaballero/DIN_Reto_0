package DataAccessTier;

import Model.User;

/**
 * The {@code DataAccessible} interface provides a method to retrieve user data.
 * 
 * <p>It is expected that classes implementing this interface will provide the 
 * logic to access and return the {@code User} object.
 * 
 * @author Adrian and Omar
 * @version 1.0
 */
public interface DataAccessible {

    /**
     * Retrieves user data.
     * 
     * @return the {@link User} object containing the user's data.
     * @throws Exception if an error occurs during data retrieval.
     */
    public User getUserData() throws Exception;
}

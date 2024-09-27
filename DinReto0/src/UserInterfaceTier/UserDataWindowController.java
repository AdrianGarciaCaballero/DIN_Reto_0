/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceTier;

import Model.User;
import DataAccessTier.UserManagerFactory;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Controller class for the User Data Window.
 * This class manages the display of user information retrieved from the data access layer.
 * It initializes the view with the user's name, username, password, DNI, and balance.
 * In case of any errors, an alert message is displayed to the user.
 * 
 * Implements {@link Initializable} to handle JavaFX initialization lifecycle.
 * 
 * @author 2dam
 */
public class UserDataWindowController implements Initializable {

    // Labels to display user information in the UI
    @FXML
    Label name_txt, username_txt, pasword_txt, dni_txt, balance_txt;

    /**
     * Method called to initialize the controller after its root element has been completely processed.
     * Fetches and displays user data from the data access layer.
     * 
     * @param url The location used to resolve relative paths for the root object, or null if not available.
     * @param rb The resources used to localize the root object, or null if not available.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Additional initialization if necessary
        try {
            // Fetch user data
            User user = UserManagerFactory.getDataAccessible().getUserData();

            // Set label text with user details
            name_txt.setText(user.getName());
            username_txt.setText(user.getUserName());
            pasword_txt.setText(user.getPassword());
            dni_txt.setText(user.getDni());
            balance_txt.setText(user.getBalance().toString());

        } catch (Exception e) {
            // Log the exception and show an alert to the user
            Logger.getLogger(UserDataWindowController.class.getName()).severe(e.getLocalizedMessage());

            // Create and display an error alert with the exception message
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getLocalizedMessage(), ButtonType.OK);
            alert.showAndWait(); // Wait for user to close the alert before proceeding
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceTier;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The Application class extends the JavaFX Application and serves as the entry point for the GUI-based application.
 * It loads and displays the UserDataView.fxml file as the main user interface.
 * 
 * This class overrides the start method to set up the primary stage and scene for the application.
 * 
 * @author Adrian and Omar
 * @version 1.0
 */
public class Application extends javafx.application.Application {

    /**
     * The start method is the main entry point for all JavaFX applications.
     * It loads the UserDataView.fxml file to create the initial UI for the application
     * and sets the scene on the primary stage.
     * 
     * @param stage The primary stage for this application.
     * @throws Exception If there is an issue loading the FXML file.
     */
      @Override
    public void start(Stage stage) throws Exception {
        // Load the UI layout from the UserDataView.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("UserDataView.fxml"));
        
        // Create a new Scene object with the loaded root node
        Scene scene = new Scene(root);
        
        // Set the scene on the primary stage
        stage.setScene(scene);
        
        // Show the stage, making the application visible
        stage.show();
    }

    /**
     * The main method is the entry point for the Java application.
     * It calls the launch method to start the JavaFX application lifecycle.
     * 
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

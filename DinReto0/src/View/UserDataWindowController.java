/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import dao.DBUserDataAccessor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author 2dam
 */
public class UserDataWindowController implements Initializable {
    
    @FXML
    private Label label;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        DBUserDataAccessor jdjd = new DBUserDataAccessor();
        jdjd.getUserData();
        // TODO
    }    
    
}

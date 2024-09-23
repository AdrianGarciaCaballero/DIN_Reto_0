/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.User;
import dao.DataAccessible;
import dao.FileUserDataAccessor;
import dao.UserManagerFactory;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

/**
 *
 * @author 2dam
 */
public class UserDataWindowController implements Initializable {

    @FXML
    Label name_txt, username_txt, pasword_txt, dni_txt, balance_txt;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            User user = UserManagerFactory.getDataAccessible().getUserData();

            name_txt.setText(user.getName());
            username_txt.setText(user.getUserName());
            pasword_txt.setText(user.getPassword());
            dni_txt.setText(user.getDni());
            balance_txt.setText(user.getBalance().toString());

        } catch (Exception e) {
            Logger.getLogger("View").severe(e.getLocalizedMessage());
            new Alert(Alert.AlertType.ERROR,e.getLocalizedMessage(),ButtonType.OK);
        }
    }
}

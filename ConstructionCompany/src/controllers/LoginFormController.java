/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.UserDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author LJUBO
 */
public class LoginFormController implements Initializable {

    @FXML
    private Button loginButton;
    @FXML
    private PasswordField passwordText;
    @FXML
    private TextField usernameText;
    @FXML
    private Label warningLabel;
    @FXML
    private Label passwordLabel;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
      String username = usernameText.getText();
      String password = passwordText.getText();
      
      username = "admin"; //TODO Delete this for testing
      password = "admin";
      
      MainFormController.personalIdNumber = UserDAO.login(username, password);
      if(!MainFormController.personalIdNumber.equals(""))
      {
          UserDAO.saveLogin(MainFormController.personalIdNumber);
          showMainForm();
      }
      else
      {
          warningLabel.setText("Wrong username or password");
      }
    }
    
    private void showMainForm(){
        try {
            constructioncompany.ConstructionCompany.mainForm = new Stage();
            Pane myPane = (Pane)FXMLLoader.load(getClass().getResource("/forms/mainForm.fxml"));
            Scene myScene = new Scene(myPane);
            constructioncompany.ConstructionCompany.mainForm.setTitle("Construction Company");
            constructioncompany.ConstructionCompany.mainForm.setScene(myScene);
            constructioncompany.ConstructionCompany.mainForm.show();   
            closeLoginForm();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private void closeLoginForm(){
        constructioncompany.ConstructionCompany.loginScreen.close();
    }
    
}

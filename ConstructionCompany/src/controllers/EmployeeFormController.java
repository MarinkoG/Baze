/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LJUBO
 */
public class EmployeeFormController implements Initializable {

    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addEmployee(ActionEvent event) {
        try {
            constructioncompany.ConstructionCompany.addNewEmployeeForm = new Stage();
            Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("/forms/addNewEmployeeForm.fxml"));
            Scene myScene = new Scene(myPane);
            constructioncompany.ConstructionCompany.addNewEmployeeForm.setTitle("Add New Employee");
            constructioncompany.ConstructionCompany.addNewEmployeeForm.setScene(myScene);
            constructioncompany.ConstructionCompany.addNewEmployeeForm.show();
            //closeMainForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

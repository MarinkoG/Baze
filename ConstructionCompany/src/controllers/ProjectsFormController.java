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
public class ProjectsFormController implements Initializable {

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
    private void addNewProject(ActionEvent event) {
        try {
            constructioncompany.ConstructionCompany.addNewProjectForm = new Stage();
            Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("/forms/addNewProjectForm.fxml"));
            Scene myScene = new Scene(myPane);
            constructioncompany.ConstructionCompany.addNewProjectForm.setTitle("New Project");
            constructioncompany.ConstructionCompany.addNewProjectForm.setScene(myScene);
            constructioncompany.ConstructionCompany.addNewProjectForm.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

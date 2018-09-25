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
public class MainFormController implements Initializable {

    @FXML
    private Button employeesButton;
    @FXML
    private Button projectsButton;
    @FXML
    private Button usersButton;
    @FXML
    private Button stagesButton;
    @FXML
    private Button worktimeButton;
    public static String personalIdNumber = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void showEmployees(ActionEvent event) {
        try {
            constructioncompany.ConstructionCompany.employeeForm = new Stage();
            Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("/forms/employeeForm.fxml"));
            Scene myScene = new Scene(myPane);
            constructioncompany.ConstructionCompany.employeeForm.setTitle("Employees");
            constructioncompany.ConstructionCompany.employeeForm.setScene(myScene);
            constructioncompany.ConstructionCompany.employeeForm.show();
            //closeMainForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeMainForm() {
        constructioncompany.ConstructionCompany.mainForm.close();
    }

    @FXML
    private void showProjects(ActionEvent event) {
        try {
            constructioncompany.ConstructionCompany.projectsForm = new Stage();
            Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("/forms/projectsForm.fxml"));
            Scene myScene = new Scene(myPane);
            constructioncompany.ConstructionCompany.projectsForm.setTitle("Projects");
            constructioncompany.ConstructionCompany.projectsForm.setScene(myScene);
            constructioncompany.ConstructionCompany.projectsForm.show();
            //closeMainForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showUsers(ActionEvent event) {
        try {
            constructioncompany.ConstructionCompany.userForm = new Stage();
            Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("/forms/userForm.fxml"));
            Scene myScene = new Scene(myPane);
            constructioncompany.ConstructionCompany.userForm.setTitle("Users");
            constructioncompany.ConstructionCompany.userForm.setScene(myScene);
            constructioncompany.ConstructionCompany.userForm.show();
            //closeMainForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showStages(ActionEvent event) {
        try {
            constructioncompany.ConstructionCompany.stagesForm = new Stage();
            Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("/forms/stageForm.fxml"));
            Scene myScene = new Scene(myPane);
            constructioncompany.ConstructionCompany.stagesForm.setTitle("Project stages");
            constructioncompany.ConstructionCompany.stagesForm.setScene(myScene);
            constructioncompany.ConstructionCompany.stagesForm.show();
            //closeMainForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void enterWorktime(ActionEvent event) {
                try {
            constructioncompany.ConstructionCompany.worktimeForm = new Stage();
            Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("/forms/worktimeForm.fxml"));
            Scene myScene = new Scene(myPane);
            constructioncompany.ConstructionCompany.worktimeForm.setTitle("Worktime");
            constructioncompany.ConstructionCompany.worktimeForm.setScene(myScene);
            constructioncompany.ConstructionCompany.worktimeForm.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

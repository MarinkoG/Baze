/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.EmployeeDAO;
import dao.ProjectDAO;
import dto.EmployeeDTO;
import dto.ProjectDTO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML
    private TableView<ProjectDTO> projectTable;
    @FXML
    private TableColumn<ProjectDTO, Integer> idColumn;
    @FXML
    private TableColumn<ProjectDTO, String> nameColumn;
    @FXML
    private TableColumn<ProjectDTO, String> managerColumn;
    @FXML
    private TableColumn<ProjectDTO, String> clientColumn;
    @FXML
    private TableColumn<ProjectDTO, String> startDateColumn;
    @FXML
    private TableColumn<ProjectDTO, String> completionDateColumn;
    @FXML
    private TableColumn<ProjectDTO, Float> priceColumn;
    @FXML
    private Button showStagesButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillTable();
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

    @FXML
    private void editProject(ActionEvent event) {
    }

    @FXML
    private void deleteProject(ActionEvent event) {
    }

    @FXML
    private void showStages(ActionEvent event) {
    }

    private void fillTable() {
        projectTable.getItems().clear();
        ArrayList<ProjectDTO> projects = ProjectDAO.getProjects();
        idColumn.setCellValueFactory(new PropertyValueFactory<ProjectDTO, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<ProjectDTO, String>("name"));
        managerColumn.setCellValueFactory(new PropertyValueFactory<ProjectDTO, String>("manager"));
        clientColumn.setCellValueFactory(new PropertyValueFactory<ProjectDTO, String>("client"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<ProjectDTO, String>("startDate"));
        completionDateColumn.setCellValueFactory(new PropertyValueFactory<ProjectDTO, String>("completionDate"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<ProjectDTO, Float>("price"));
        for (int i = 0; i < projects.size(); i++) {
            projectTable.getItems().add(projects.get(i));
        }
        projectTable.getSelectionModel().select(0);
    }

}

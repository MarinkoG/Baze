/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.WorktimeDAO;
import dto.WorktimeDTO;
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
public class WorktimeFormController implements Initializable {

    @FXML
    private TableColumn<WorktimeDTO, String> dateColumn;
    @FXML
    private TableColumn<WorktimeDTO, Float> worktimeColumn;
    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TableView<WorktimeDTO> workTimeTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillTable();
    }

    @FXML
    private void addWorktime(ActionEvent event) {
        try {
            constructioncompany.ConstructionCompany.addWorktimeForm = new Stage();
            Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("/forms/addWorktimeForm.fxml"));
            Scene myScene = new Scene(myPane);
            constructioncompany.ConstructionCompany.addWorktimeForm.setTitle("Enter your worktime");
            constructioncompany.ConstructionCompany.addWorktimeForm.setScene(myScene);
            constructioncompany.ConstructionCompany.addWorktimeForm.showAndWait();
            fillTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void editWorktime(ActionEvent event) {
        WorktimeDTO worktime = workTimeTable.getSelectionModel().getSelectedItem();
        try {
            Stage editWorktimeForm = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane myPane = fxmlLoader.load(getClass().getResource("/forms/addWorktimeForm.fxml").openStream());
            AddWorktimeFormController editController = (AddWorktimeFormController) fxmlLoader.getController();
            editController.setEdit(worktime);
            Scene myScene = new Scene(myPane);
            editWorktimeForm.setTitle("Edit ");
            editWorktimeForm.setScene(myScene);
            editWorktimeForm.showAndWait();
            fillTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteWorktime(ActionEvent event) {
        WorktimeDTO worktime = workTimeTable.getSelectionModel().getSelectedItem();
        try {
            WorktimeDAO.deleteWorktime(worktime);
        } catch (Exception e) {
        }

        fillTable();
    }

    private void fillTable() {
        workTimeTable.getItems().clear();
        ArrayList<WorktimeDTO> workTime = WorktimeDAO.getWorktime();
        dateColumn.setCellValueFactory(new PropertyValueFactory<WorktimeDTO, String>("date"));
        worktimeColumn.setCellValueFactory(new PropertyValueFactory<WorktimeDTO, Float>("workHours"));
        for (int i = 0; i < workTime.size(); i++) {
            workTimeTable.getItems().add(workTime.get(i));
        }
        workTimeTable.getSelectionModel().select(0);
    }
}

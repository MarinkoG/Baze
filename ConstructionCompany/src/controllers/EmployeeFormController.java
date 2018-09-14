/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.EmployeeDAO;
import dao.UserDAO;
import dto.EmployeeDTO;
import dto.UserDTO;
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
public class EmployeeFormController implements Initializable {

    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TableColumn<EmployeeDTO, String> firstNameColumn;
    @FXML
    private TableColumn<EmployeeDTO, String> lastNameColumn;
    @FXML
    private TableColumn<EmployeeDTO, String> personalIdColumn;
    @FXML
    private TableColumn<EmployeeDTO, String> dateOfBirthColumn;
    @FXML
    private TableColumn<EmployeeDTO, String> phoneNumberColumn;
    @FXML
    private TableColumn<EmployeeDTO, String> emailColumn;
    @FXML
    private TableColumn<EmployeeDTO, String> professionColumn;
    @FXML
    private TableColumn<EmployeeDTO, String> hourlyRateColumn;
    @FXML
    private TableColumn<EmployeeDTO, String> salaryColumn;
    @FXML
    private TableColumn<EmployeeDTO, String> bankAccountColumn;
    @FXML
    private TableColumn<EmployeeDTO, String> usernameColumn;
    @FXML
    private TableView<EmployeeDTO> employeesTable;
    @FXML
    private TableColumn<EmployeeDTO, String> addressColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillTable();
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
    
    private void fillTable() {
        employeesTable.getItems().clear();
        ArrayList<EmployeeDTO> employees = EmployeeDAO.getAllEmployees();
        personalIdColumn.setCellValueFactory(new PropertyValueFactory<EmployeeDTO, String>("personalIdNumber"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<EmployeeDTO, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<EmployeeDTO, String>("lastName"));
        dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<EmployeeDTO, String>("dateOfBirth"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<EmployeeDTO, String>("address"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<EmployeeDTO, String>("phoneNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<EmployeeDTO, String>("email"));
        professionColumn.setCellValueFactory(new PropertyValueFactory<EmployeeDTO, String>("profession"));
        hourlyRateColumn.setCellValueFactory(new PropertyValueFactory<EmployeeDTO, String>("hourlyRate"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<EmployeeDTO, String>("salary"));
        bankAccountColumn.setCellValueFactory(new PropertyValueFactory<EmployeeDTO, String>("bankAccount"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<EmployeeDTO, String>("username"));
        for (int i = 0; i < employees.size(); i++) {
            employeesTable.getItems().add(employees.get(i));
        }
        employeesTable.getSelectionModel().select(0);
    }

    @FXML
    private void editEmployee(ActionEvent event) {
        EmployeeDTO selectedEmployee = employeesTable.getSelectionModel().getSelectedItem();
        try {
            Stage editEmployeeForm = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane myPane = fxmlLoader.load(getClass().getResource("/forms/addNewEmployeeForm.fxml").openStream());
            AddNewEmployeeController editController = (AddNewEmployeeController) fxmlLoader.getController();
            editController.setEdit(selectedEmployee);
            Scene myScene = new Scene(myPane);
            editEmployeeForm.setTitle("Edit " + selectedEmployee.getFirstName() + " " + selectedEmployee.getLastName());
            editEmployeeForm.setScene(myScene);
            editEmployeeForm.showAndWait();
            fillTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteEmployee(ActionEvent event) {
        EmployeeDTO selectedEmployee = employeesTable.getSelectionModel().getSelectedItem();
        System.out.println("BRISI ---"+selectedEmployee.getPersonalIdNumber());
        EmployeeDAO.deleteEmployee(selectedEmployee);
        fillTable();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dto.EmployeeDTO;
import dto.UserDTO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LJUBO
 */
public class AddNewEmployeeController implements Initializable {

    @FXML
    private TextField firstNameText;
    @FXML
    private TextField lastNameText;
    @FXML
    private TextField jmbgText;
    @FXML
    private TextField professionText;
    @FXML
    private TextField phoneNumberText;
    @FXML
    private DatePicker dateOfBirthPicker;
    @FXML
    private Button saveButton;
    @FXML
    private TextField streetText;
    @FXML
    private TextField emailText;
    @FXML
    private ChoiceBox<?> projectChoiceBox;
    @FXML
    private TextField numberText;
    @FXML
    private TextField zipCodeText;
    @FXML
    private TextField cityText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addNewEmployee(ActionEvent event) {
        System.out.println("Mare addNewEmployee()");
    }

    public void setEdit(EmployeeDTO employee) {
     /*   employeeBox.getItems().clear();
        employeeBox.getItems().add(user.getPersonalIdNumber() + ", " + user.getFirstName() + ", " + user.getLastName());
        employeeBox.setValue(employeeBox.getItems().get(0));
        employeeBox.setDisable(true);
        usernameText.setText(user.getUsername());
        privilegeBox.setValue(user.getPrivilege());*/
    }

}

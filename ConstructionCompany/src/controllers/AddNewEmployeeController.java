/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.EmployeeDAO;
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
import javafx.scene.control.Label;
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
    private TextField numberText;
    @FXML
    private TextField zipCodeText;
    @FXML
    private TextField cityText;
    @FXML
    private TextField hourlyRateText;
    @FXML
    private TextField salaryText;
    @FXML
    private TextField personalIdText;
    @FXML
    private Label warningLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addNewEmployee(ActionEvent event) {
        String address = cityText.getText() + ", " + streetText.getText() + ", " + zipCodeText.getText() + ", " + numberText.getText();
        EmployeeDTO employee = new EmployeeDTO(hourlyRateText.getText(), salaryText.getText(), "", firstNameText.getText(), lastNameText.getText(), personalIdText.getText(), dateOfBirthPicker.getAccessibleText(), phoneNumberText.getText(), emailText.getText(), address);

        if (EmployeeDAO.saveEmployee(employee)) {
            warningLabel.setText("Succesufully saved user");
        } else {
            warningLabel.setText("Error while saving user");
        }
        /*if (employeeBox.isDisable()) {
            if (UserDAO.updateUser(user)) {
                warningLabel.setText("Succesufully updated user");
            } else {
                warningLabel.setText("Error while updating user");
            }
        } else {
            if (UserDAO.saveUser(user)) {
            warningLabel.setText("Succesufully saved user");
            } else {
                warningLabel.setText("Error while saving user");
            }
        }*/
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

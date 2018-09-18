/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.EmployeeDAO;
import dto.Address;
import dto.EmployeeDTO;
import dto.UserDTO;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;

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

    EmployeeDTO employee;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addNewEmployee(ActionEvent event) {
        Address address = null;

        if (!(cityText.getText().equals("") && streetText.getText().equals("") && numberText.getText().equals("") && zipCodeText.getText().equals(""))) {
            address = new Address(cityText.getText(), streetText.getText(), numberText.getText(), zipCodeText.getText());
        }

        EmployeeDTO employee = new EmployeeDTO(hourlyRateText.getText(), salaryText.getText(), "", firstNameText.getText(), lastNameText.getText(), personalIdText.getText(), dateOfBirthPicker.getValue().toString(), phoneNumberText.getText(), emailText.getText(), address);
        if (EmployeeDAO.saveEmployee(employee)) {
            warningLabel.setText("Succesufully saved employee");
        } else {
            warningLabel.setText("Error while saving employee");
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

    public void setEdit(EmployeeDTO selectedEmployee) {
        employee = selectedEmployee;
        personalIdText.setText(employee.getPersonalIdNumber());
        firstNameText.setText(employee.getFirstName());
        lastNameText.setText(employee.getLastName());
        dateOfBirthPicker.setValue(LocalDate.parse(employee.getDateOfBirth()));
        if (employee.getAddress() != null) {
            cityText.setText(employee.getAddress().getCity());
            streetText.setText(employee.getAddress().getStreet());
            zipCodeText.setText(employee.getAddress().getZipCode());
            numberText.setText(employee.getAddress().getHouseNumber());
        }
        phoneNumberText.setText(employee.getPhoneNumber());
        emailText.setText(employee.getEmail());
        hourlyRateText.setText(employee.getHourlyRate());
        salaryText.setText(employee.getSalary());
    }
}

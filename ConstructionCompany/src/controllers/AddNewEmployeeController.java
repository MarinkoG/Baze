/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AddressDAO;
import dao.EmployeeDAO;
import dto.AddressDTO;
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
    private Label warningLabel;

    EmployeeDTO selectedEmployee;

    @FXML
    private TextField personalIdText;

    public boolean edit = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
/*
    private void addNewEmployee(ActionEvent event) {
        AddressDTO address = null;

        if (!(cityText.getText().equals("") && streetText.getText().equals("") && numberText.getText().equals("") && zipCodeText.getText().equals(""))) {
            address = new AddressDTO(cityText.getText(), streetText.getText(), numberText.getText(), zipCodeText.getText());
        }

        EmployeeDTO employee = new EmployeeDTO(hourlyRateText.getText(), salaryText.getText(), "", firstNameText.getText(), lastNameText.getText(), personalIdText.getText(), dateOfBirthPicker.getValue().toString(), phoneNumberText.getText(), emailText.getText(), address);
        if (EmployeeDAO.saveEmployee(employee)) {
            warningLabel.setText("Succesufully saved employee");
        } else {
            warningLabel.setText("Error while saving employee");
        }
    }
*/
    public void setEdit(EmployeeDTO employee) {
        edit = true;
        selectedEmployee = employee;
        System.out.println(personalIdText);
        personalIdText.setText(selectedEmployee.getPersonalIdNumber());
        personalIdText.setDisable(true);
        firstNameText.setText(selectedEmployee.getFirstName());
        lastNameText.setText(selectedEmployee.getLastName());
        dateOfBirthPicker.setValue(LocalDate.parse(selectedEmployee.getDateOfBirth()));
        if (employee.getAddress() != null) {
            cityText.setText(selectedEmployee.getAddress().getCity());
            streetText.setText(selectedEmployee.getAddress().getStreet());
            zipCodeText.setText(selectedEmployee.getAddress().getZipCode());
            numberText.setText(selectedEmployee.getAddress().getHouseNumber());
        }
        phoneNumberText.setText(employee.getPhoneNumber());
        emailText.setText(employee.getEmail());
        hourlyRateText.setText(employee.getHourlyRate());
        salaryText.setText(employee.getSalary());
    }

    @FXML
    private void saveEmployee(ActionEvent event) {
        AddressDTO address = new AddressDTO(cityText.getText(), streetText.getText(), zipCodeText.getText(), numberText.getText());
        EmployeeDTO employee = new EmployeeDTO(hourlyRateText.getText(), salaryText.getText(), "", firstNameText.getText(), lastNameText.getText(), personalIdText.getText(), dateOfBirthPicker.getValue().toString(), phoneNumberText.getText(), emailText.getText(), address);
        if (edit) {
            employee.getAddress().setId(selectedEmployee.getAddress().getId());
            int option = -1;
            if (!employee.getAddress().equals(selectedEmployee.getAddress())) {
                option = 1;
                if (!employee.getAddress().getCity().equals("")) {
                    option = 2;
                } else {
                    option = 0;
                }
            }
            
            if (selectedEmployee.equals(employee)) {
                warningLabel.setText("No changes entered");
            } else if (EmployeeDAO.updateEmployee(employee, option)) {
                warningLabel.setText("Succesufully updated employee");
            } else {
                warningLabel.setText("Error while updating employee");
            }
            
        } else if (EmployeeDAO.saveEmployee(employee)) {
            warningLabel.setText("Succesufully saved employee");
        } else {
            warningLabel.setText("Error while saving employee");
        }
    }
}

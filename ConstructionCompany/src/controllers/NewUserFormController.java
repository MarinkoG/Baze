/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.UserDAO;
import dto.UserDTO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LJUBO
 */
public class NewUserFormController implements Initializable {

    @FXML
    private TextField usernameText;
    @FXML
    private TextField passwordText;
    @FXML
    private Button saveButton;
    @FXML
    public ChoiceBox<String> employeeBox;
    @FXML
    private ChoiceBox<String> privilegeBox;
    @FXML
    private Label warningLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillEmployee();
        fillPrivilege();
    }

    public void fillEmployee() {
        ArrayList<String> emloyeesWithoutAccount = UserDAO.getEmployeeWithoutAccount();
        employeeBox.getItems().addAll(emloyeesWithoutAccount);
        if (employeeBox.getItems().size() > 0) {
            employeeBox.setValue(employeeBox.getItems().get(0));
        }
    }

    public void fillPrivilege() {
        ArrayList<String> privileges = UserDAO.getPrivileges();

        privilegeBox.getItems().addAll(privileges);
        if (privilegeBox.getItems().size() > 0) {
            privilegeBox.setValue(privilegeBox.getItems().get(0));
        }
    }

    public void setEdit(UserDTO user) {
        employeeBox.getItems().clear();
        employeeBox.getItems().add(user.getPersonalIdNumber() + ", " + user.getFirstName() + ", " + user.getLastName());
        employeeBox.setValue(employeeBox.getItems().get(0));
        employeeBox.setDisable(true);
        usernameText.setText(user.getUsername());
        privilegeBox.setValue(user.getPrivilege());
    }

    @FXML
    private void saveUser(ActionEvent event) {
        UserDTO user = new UserDTO(employeeBox.getValue().split(", ")[0], employeeBox.getValue().split(", ")[1], employeeBox.getValue().split(", ")[2], usernameText.getText(), passwordText.getText(), privilegeBox.getValue());
        if (employeeBox.isDisable()) {
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
        }
    }
}

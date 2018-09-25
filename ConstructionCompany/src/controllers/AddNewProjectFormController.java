/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.EmployeeDAO;
import dao.PersonDAO;
import dao.ProjectDAO;
import dao.UserDAO;
import dto.ProjectDTO;
import dto.UserDTO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LJUBO
 */
public class AddNewProjectFormController implements Initializable {

    @FXML
    private Button saveButton;
    @FXML
    private TextField nameText;
    @FXML
    private ChoiceBox<String> clientChoiceBox;
    @FXML
    private ChoiceBox<String> menagerChoiceBox;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker completionDatePicker;
    @FXML
    private TextField priceText;
    @FXML
    private Label warningLabel;
    public boolean edit = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillMenager();
        fillClients();
    }    

    @FXML
    private void saveProject(ActionEvent event) {
         // new UserDTO(employeeBox.getValue().split(", ")[0], employeeBox.getValue().split(", ")[1], employeeBox.getValue().split(", ")[2], usernameText.getText(), passwordText.getText(), privilegeBox.getValue());
        
       ProjectDTO project = new ProjectDTO(nameText.getText(), menagerChoiceBox.getValue(), clientChoiceBox.getValue(), startDatePicker.getValue().toString(), completionDatePicker.getValue().toString(), new Float(priceText.getText()));
               
            if (edit) {
           /* if (UserDAO.updateUser(user)) {
                warningLabel.setText("Succesufully updated user");
            } else {
                warningLabel.setText("Error while updating user");
            }*/
        } else {
            if (ProjectDAO.saveProject(project)) {
            warningLabel.setText("Succesufully saved user");
            } else {
                warningLabel.setText("Error while saving user");
            }
        }
    }
    
        public void fillMenager() {
        ArrayList<String> emloyees = EmployeeDAO.getEmployeesForMenager();
        menagerChoiceBox.getItems().addAll(emloyees);
        if (menagerChoiceBox.getItems().size() > 0) {
            menagerChoiceBox.setValue(menagerChoiceBox.getItems().get(0));
        }
    }

    public void fillClients() {
        ArrayList<String> clients = PersonDAO.getClients();

        clientChoiceBox.getItems().addAll(clients);
        if (clientChoiceBox.getItems().size() > 0) {
            clientChoiceBox.setValue(clientChoiceBox.getItems().get(0));
        }
    }
}

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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
    private ChoiceBox<?> clientChoiceBox;
    @FXML
    private ChoiceBox<?> menagerChoiceBox;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker completionDatePicker;
    @FXML
    private TextField priceText;
    @FXML
    private TextField cityText;
    @FXML
    private TextField zipCodeText;
    @FXML
    private TextField numberText;
    @FXML
    private TextField streetText;
    @FXML
    private TextArea descriptionText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveProject(ActionEvent event) {
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.EmployeeDAO;
import dao.WorktimeDAO;
import dto.EmployeeDTO;
import dto.WorktimeDTO;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LJUBO
 */
public class AddWorktimeFormController implements Initializable {

    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField workHoursText;
    @FXML
    private Button saveButton;

    private boolean  edit = false;
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
    private void saveWorktime(ActionEvent event) {
        WorktimeDTO worktime = new WorktimeDTO(new Float(workHoursText.getText()), MainFormController.personalIdNumber, datePicker.getValue().toString());
        if (edit) {
            
            if (WorktimeDAO.updateWorktime(worktime)) {
                warningLabel.setText("Succesufully updated worktime");
            } else {
                warningLabel.setText("Error while updating worktime");
            }
            
        } else if (WorktimeDAO.saveWorktime(worktime)) {
            warningLabel.setText("Succesufully saved worktime");
        } else {
            warningLabel.setText("Error while saving worktime, That date is already entered");
        }
    }

    void setEdit(WorktimeDTO worktime) {
        edit = true;
        datePicker.setValue(LocalDate.parse(worktime.getDate()));
        datePicker.setDisable(true);
        workHoursText.setText(worktime.getWorkHours().toString());
    }
    
}

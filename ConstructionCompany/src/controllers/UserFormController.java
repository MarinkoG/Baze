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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LJUBO
 */
public class UserFormController implements Initializable {
    
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button editButton;
    @FXML
    private TableColumn<UserDTO, String> personalIdColumn;
    @FXML
    private TableColumn<UserDTO, String> firstNameColumn;
    @FXML
    private TableColumn<UserDTO, String> lastNameColumn;
    @FXML
    private TableColumn<UserDTO, String> usernameColumn;
    @FXML
    private TableColumn<UserDTO, String> privilegeColumn;
    @FXML
    private TableView<UserDTO> usersTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillTable();
    }
    
    @FXML
    private void addNewUser(ActionEvent event) {
        try {
            constructioncompany.ConstructionCompany.addNewUserForm = new Stage();
            Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("/forms/newUserForm.fxml"));
            Scene myScene = new Scene(myPane);
            constructioncompany.ConstructionCompany.addNewUserForm.setTitle("New User");
            constructioncompany.ConstructionCompany.addNewUserForm.setScene(myScene);
            constructioncompany.ConstructionCompany.addNewUserForm.showAndWait();
            fillTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void fillTable() {
        usersTable.getItems().clear();
        ArrayList<UserDTO> users = UserDAO.getAllUsers();
        personalIdColumn.setCellValueFactory(new PropertyValueFactory<UserDTO, String>("personalIdNumber"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<UserDTO, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<UserDTO, String>("lastName"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<UserDTO, String>("username"));
        privilegeColumn.setCellValueFactory(new PropertyValueFactory<UserDTO, String>("privilege"));
        for (int i = 0; i < users.size(); i++) {
            usersTable.getItems().add(users.get(i));
        }
        usersTable.getSelectionModel().select(0);
    }
    
    @FXML
    private void editUser(ActionEvent event) {
        UserDTO selectedUser = usersTable.getSelectionModel().getSelectedItem();
        try {
            Stage editUserForm = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane myPane = fxmlLoader.load(getClass().getResource("/forms/newUserForm.fxml").openStream());
            NewUserFormController editController = (NewUserFormController) fxmlLoader.getController();
            editController.setEdit(selectedUser);
            Scene myScene = new Scene(myPane);
            editUserForm.setTitle("Edit " + selectedUser.getFirstName() + " " + selectedUser.getLastName());
            editUserForm.setScene(myScene);
            editUserForm.showAndWait();
            fillTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void deleteUser(ActionEvent event) {
        UserDTO selectedUser = usersTable.getSelectionModel().getSelectedItem();
        UserDAO.deleteUser(selectedUser);
        fillTable();
    }
    
    @FXML
    private void refreshScreen(MouseEvent event) {
        fillTable();
    }
}

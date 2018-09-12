/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructioncompany;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author LJUBO
 */
public class ConstructionCompany extends Application {
    
    public static Stage loginScreen;
    public static Stage mainForm;
    public static Stage employeeForm;
    public static Stage addNewEmployeeForm;
    public static String username = "";
    public static String password = "";
    public static Stage projectsForm;
    public static Stage addNewProjectForm;
    public static Stage userForm;
    public static Stage addNewUserForm;
    public static Stage stagesForm;
    public static boolean editUser = false;
    
    @Override
    public void start(Stage primaryStage) {
        showloginForm();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void showloginForm() {
        try {
            loginScreen = new Stage();
            Pane myPane = (Pane)FXMLLoader.load(getClass().getResource("/forms/loginForm.fxml"));
            Scene myScene = new Scene(myPane);
            loginScreen.setTitle("Gradevinska Firma");
            loginScreen.setScene(myScene);
            loginScreen.show();   
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}

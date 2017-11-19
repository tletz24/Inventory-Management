package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller {

    public Button logInSubmit;
    public Button logInQuit;
    public Label newLabel;

    public TextField userName = new TextField();
    public PasswordField password = new PasswordField();

    public void handleLogInAttempt() {
        System.out.println("User attempting to login...");
        String tempUserName = userName.getText();
        String tempPassword = password.getText();
        if(tempUserName.toLowerCase().equals("admin")) {
            if(tempPassword.equals("password123")) {
                //TODO grant access to the user
                System.out.println("The user has successfully logged in");
                System.out.println("Username: " + tempUserName);
                System.out.println("Password: " + tempPassword);
            } else {
                //TODO let the user know that the password is incorrect
                System.out.println("Log in failed due to password");
            }
        } else {
            //TODO let the user know that the user name was incorrect
            System.out.println("Log in failed due to user name");
        }
    }

    public void handleLogInQuit() {
        System.out.println("Exiting the program");
        Stage stage = (Stage) logInQuit.getScene().getWindow();
        stage.close();
    }

}

package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginWindowController {

    public Button logInSubmit;
    public Button logInQuit;
    public Label errorLine;

    public TextField userName;

    public PasswordField password;

    public Scene secondScene;

    public void handleLogInAttempt(ActionEvent event) {
        System.out.println("User attempting to login...");
        String tempUserName = userName.getText();
        String tempPassword = password.getText();
        if (tempUserName.toLowerCase().equals("admin")) {
            if (tempPassword.equals("password123")) {
                //TODO grant access to the user
                System.out.println("The user has successfully logged in");
                System.out.println("Username: " + tempUserName);
                System.out.println("Password: " + tempPassword);
                errorLine.setText("");
                Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                primaryStage.setScene(secondScene);
            } else {
                //TODO let the user know that the password is incorrect
                System.out.println("Log in failed due to password");
                errorLine.setText("Error: the password you have entered is incorrect");
            }
        }  else {
            //TODO let the user know that the user name was incorrect
            System.out.println("Log in failed due to user name");
            errorLine.setText("Error: the username you have entered is incorrect");

        }
    }



    //Here we handle when the uer selects the QUIT button.
    public void handleLogInQuit() {
        System.out.println("Exiting the program");
        Stage stage = (Stage) logInQuit.getScene().getWindow();
        stage.close();
    }

    //Here we handle the event of someone pressing the enter key
    //while in the password field.
    public void onEnter(ActionEvent event) {
        handleLogInAttempt(event);
    }

    public void setSecondScene(Scene scene) {
        secondScene = scene;
    }

    public void openSecondScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(secondScene);
    }

}

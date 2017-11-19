package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Scene mainLoginScene;

    @Override
    public void start(Stage loginWindow) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        loginWindow.setTitle("Inventory System 1.0");
        loginWindow.setScene(new Scene(root, 400, 251));
        loginWindow.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}

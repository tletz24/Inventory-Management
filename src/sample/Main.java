package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader firstPaneLoader = new FXMLLoader(getClass().getResource("LoginWindow.fxml"));
        Parent firstPane = firstPaneLoader.load();
        Scene firstScene = new Scene(firstPane, 400, 251);

        FXMLLoader secondPageLoader = new FXMLLoader(getClass().getResource("FileSelectorWindow.fxml"));
        Parent secondPane = secondPageLoader.load();
        Scene secondScene = new Scene(secondPane, 300, 275);

        FileSelectorWindowController secondPaneController = (FileSelectorWindowController) secondPageLoader.getController();
        secondPaneController.setFirstScene(firstScene);

        LoginWindowController firstPaneController = (LoginWindowController) firstPaneLoader.getController();
        firstPaneController.setSecondScene(secondScene);

        primaryStage.setTitle("Switching scenes");
        primaryStage.setScene(firstScene);
        primaryStage.show();
    }






}

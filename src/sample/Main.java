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

        // getting loader and a pane for the first scene.
        // loader will then give a possibility to get related controller
        FXMLLoader firstPaneLoader = new FXMLLoader(getClass().getResource("LoginWindow.fxml"));
        Parent firstPane = firstPaneLoader.load();
        Scene firstScene = new Scene(firstPane, 400, 251);

        // getting loader and a pane for the second scene
        FXMLLoader secondPageLoader = new FXMLLoader(getClass().getResource("FileSelectorWindow.fxml"));
        Parent secondPane = secondPageLoader.load();
        Scene secondScene = new Scene(secondPane, 300, 275);

        // injecting second scene into the controller of the first scene
        LoginWindowController firstPaneController = (LoginWindowController) firstPaneLoader.getController();
        firstPaneController.setSecondScene(secondScene);

        // injecting first scene into the controller of the second scene
        FileSelectorWindowController secondPaneController = (FileSelectorWindowController) secondPageLoader.getController();
        secondPaneController.setFirstScene(firstScene);

        primaryStage.setTitle("Switching scenes");
        primaryStage.setScene(firstScene);
        primaryStage.show();
    }






}

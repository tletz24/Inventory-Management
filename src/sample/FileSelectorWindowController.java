package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.File;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class FileSelectorWindowController implements Initializable {

    public Scene firstScene;
    public TextField fileTextField;

    public ListView<String> fileViewFXML = new ListView<String>();

    public void selectFile(ActionEvent event) {
        String fileName = fileViewFXML.getSelectionModel().getSelectedItem();
        System.out.println(fileName + " was selected");
    }

    public void createFile(ActionEvent event) {
        String newFile = fileTextField.getText();
        fileViewFXML.getItems().addAll(newFile);
        fileTextField.setText("");
    }

    public void setFirstScene(Scene scene) {
        firstScene = scene;
    }

    public void openFirstScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(firstScene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            System.out.println("Retrieving Files...");
            File directory = new File("inventoryFiles");
            File[] fList = directory.listFiles();
            System.out.println("Files Retrieved:");
            for (File file : fList){
                System.out.println("\t" + file.getName());
                fileViewFXML.getItems().addAll(file.getName());
            }
        }catch(Exception e) {
            System.out.println("Could not find the files saved");
        }
    }
}

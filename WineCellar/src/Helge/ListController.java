package Helge;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ListController {
    public void addWine(ActionEvent actionEvent) throws IOException {
        System.out.println("Klickade Add");

        WineBase workwine = White.exampleWhite();
        Entry entry = new Entry(workwine);
        // makeEntryForm();
        //EntryController entryController = new EntryController(workwine);
    }

    private void makeEntryForm() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mockups/WineEntryForm.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Regigera nytt vin");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void editWine(ActionEvent actionEvent) {
        System.out.println("Klickade Redigera");
    }

    public void removeWine(ActionEvent actionEvent) {
        System.out.println("Klickade Ta bort");
    }
}

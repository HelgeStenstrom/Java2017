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
        EntryController entryController = new EntryController(workwine);
    }

    public void editWine(ActionEvent actionEvent) {
        System.out.println("Klickade Redigera");
    }

    public void removeWine(ActionEvent actionEvent) {
        System.out.println("Klickade Ta bort");
    }
}

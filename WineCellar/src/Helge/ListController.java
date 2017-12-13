package Helge;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ListController {

    public Button btnAddWine;
    public Button btnEdit;
    public Button btnRemove;
    private CellarManager cellarManager = new CellarManager();

    public void addWine(ActionEvent actionEvent) throws IOException {
        System.out.println("Klickade Add");

        WineBase workwine = White.exampleWhite();
        EntryController entryController = new EntryController(workwine);
        entryController.showStage(); // TODO: använd funktion som stannar kvar i entryController tills man aktivt lämnar den.
        Wine returned = entryController.getWine();

        System.out.printf("Name: '%s'\n", returned.getName());

        cellarManager.add(returned);

        updateListView();
    }

    private void updateListView() {
        
        for(Wine wine : cellarManager.getWines() ) {
            
        }
    }

    public void editWine(ActionEvent actionEvent) {
        System.out.println("Klickade Redigera");
    }

    public void removeWine(ActionEvent actionEvent) {
        System.out.println("Klickade Ta bort");
    }
}

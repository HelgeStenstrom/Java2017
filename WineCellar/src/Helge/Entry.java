package Helge;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Entry {
    private Wine wine;
    private Stage stage;

    Entry(WineBase wine) throws IOException {
        this.wine = new WineBase(wine);

        Parent root;
        Object o = getClass();
        // TODO: hur ska jag göra klassen tillsubklass av något som har getResource?
        // TODO: Förstå varför getResource misslyckas
        root = FXMLLoader.load(getClass().getResource("mockups/WineEntryForm.fxml"));

        stage = new Stage();
        stage.setTitle("Regigera nytt vin");
        stage.setScene(new Scene(root));
        stage.show();

        initGui();
    }

    private void initGui() {

    }
}

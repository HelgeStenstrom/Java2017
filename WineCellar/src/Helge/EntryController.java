package Helge;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EntryController {
    public TextField txtName;
    public TextField txtVintage;
    public ChoiceBox cbxType;
    public TextArea txtNotes;
    public ChoiceBox cbxCharacter;
    public Button btnOk;
    public Button btnCancel;
    private Wine wine;
   private Stage stage;

    EntryController(WineBase wine) throws IOException {
        this.wine = new WineBase(wine);

        initializeComponent();
    }

    private void initializeComponent() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mockups/WineEntryForm.fxml"));

        stage = new Stage();
        stage.setTitle("Regigera nytt vin");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void okAction(ActionEvent actionEvent) {
        System.out.println("Klickade OK");
    }

    public void cancelAction(ActionEvent actionEvent) {
        System.out.println("Klickade Avbryt");
    }
}

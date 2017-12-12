package Helge;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        initializeGui();
    }

    private void initializeComponent() throws IOException {

        // https://stackoverflow.com/questions/23132302/invocationtargetexception-when-running-a-javafx-program
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mockups/WineEntryForm.fxml"));
        loader.setController(this);
        Parent root = loader.load();

        stage = new Stage();
        stage.setTitle("Regigera nytt vin");
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void initializeGui() {
        cbxType.setItems(FXCollections.observableArrayList( WineType.values()));
        cbxType.setValue(WineType.Red);

        cbxCharacter.setItems(FXCollections.observableArrayList( CharacterType.values()));
        cbxCharacter.setValue(CharacterType.Friskt_och_fruktigt);
    }

    public void okAction(ActionEvent actionEvent) {
        System.out.println("Klickade OK");
        setWineFromGui();

    }

    public void cancelAction(ActionEvent actionEvent) {
        System.out.println("Klickade Avbryt");
    }


    public void setWineFromGui() {
        wine.setName(txtName.getText());
        wine.setVintage(Integer.parseInt(txtVintage.getText()));
        wine.setCharacterType((CharacterType) cbxCharacter.getValue());
        wine.setWineType((WineType) cbxType.getValue());
    }

}



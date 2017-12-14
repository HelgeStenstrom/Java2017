/*
 * Copyright (c) 2017. Helge Stenström
 */

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
    public Button btnCancel;
    public Button btnOk;
    public ChoiceBox cbxCharacter;
    public ChoiceBox cbxType;
    private Stage stage;
    public TextField txtName;
    public TextArea txtNotes;
    public TextField txtVintage;
    private Wine wine;


    /**
     * Constructor for the GUI controller used to make a make or change a wine object.
     * @param wine
     * @throws IOException
     */
    EntryController(WineBase wine) throws IOException {
        this.wine = new WineBase(wine);

        initializeComponent();
        initializeGui();
        updateGui();
    }

    /**
     * @return the wine that is represented by the form contents
     */
    public Wine getWine() {
        setWineFromGui();
        return wine;
    }

    /**
     * Set up the stage for the wine entry form
     * @throws IOException
     */
    private void initializeComponent() throws IOException {

        // https://stackoverflow.com/questions/23132302/invocationtargetexception-when-running-a-javafx-program
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mockups/WineEntryForm.fxml"));
        loader.setController(this);
        Parent root = loader.load();

        stage = new Stage();
        stage.setTitle("Regigera nytt vin");
        stage.setScene(new Scene(root));
    }

    /**
     * Show the wine entry form.
     */
    public void showStage() {
        // TODO: skriv funktion som stannar i EntryController tills man aktivt lämnar den med stage.close()
        stage.showAndWait();
        setWineFromGui();
    }

    /**
     * Fill some GUI component with default values
     */
    private void initializeGui() {
        cbxType.setItems(FXCollections.observableArrayList( WineType.values()));
        cbxType.setValue(WineType.Red);

        cbxCharacter.setItems(FXCollections.observableArrayList( CharacterType.values()));
        cbxCharacter.setValue(CharacterType.Friskt_och_fruktigt);
    }

    /**
     * Called when OK is clicked in the wine entry form
     * @param actionEvent
     */
    public void okAction(ActionEvent actionEvent) {
        System.out.println("Klickade OK");
        setWineFromGui();
        stage.close();
    }

    /**
     * Called when Cancel is clicked in the wine entry form
     * @param actionEvent
     */
    public void cancelAction(ActionEvent actionEvent) {
        System.out.println("Klickade Avbryt");
    }


    /**
     * The wine object (field) is updated with imformation from the GUI components.
     */
    public void setWineFromGui() {
        wine.setName(txtName.getText());
        wine.setVintage(Integer.parseInt(txtVintage.getText()));
        wine.setCharacterType((CharacterType) cbxCharacter.getValue());
        wine.setWineType((WineType) cbxType.getValue());
    }

    /**
     * Update the GUI components with information from the wine object (field)
     */
    public void updateGui() {
        txtName.setText(wine.getName());
        txtVintage.setText(Integer.toString(wine.getVintage()));
        cbxCharacter.setValue(wine.getCharacterType());
        cbxType.setValue(wine.getWineType());
    }
}

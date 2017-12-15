/*
 * Copyright (c) 2017. Helge Stenström
 */

package Helge;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;



public class ListController {

    // Fields

    public Button btnAddWine;
    public Button btnEdit;
    public Button btnRemove;
    public ListView lvWines; // Ditlagd av IntelliJ när fxml-filen hade denna klass som Controller.
    private CellarManager cellarManager = new CellarManager();
    public TableColumn colCharacter;
    public TableColumn colName;
    public TableColumn colType;
    public TableColumn colVintage;
    public MenuBar mbAppMenu;
    private Stage primaryStage;
    public TableView tvWines;
    // public ListView lvWines; // Ditlagd manuellt; de övriga har IntelliJ skapat.


    /**
     * The MVC(?) controller for the wine list form. It gets the primaryStage from the application starter.
     * @param primaryStage
     * @throws Exception
     */
    public ListController(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        setupStage();
        initTableView();
        initListView();
    }

    /**
     * @return the tableview for wines.
     */
    public TableView getTvWines() {
        return tvWines;
    }

    public void setTvWines(TableView tvWines) {
        this.tvWines = tvWines;
    }

    public TableColumn getColType() {
        return colType;
    }

    public void setColType(TableColumn colType) {
        this.colType = colType;
    }

    public TableColumn getColVintage() {
        return colVintage;
    }

    public void setColVintage(TableColumn colVintage) {
        this.colVintage = colVintage;
    }

    public TableColumn getColCharacter() {
        return colCharacter;
    }

    public void setColCharacter(TableColumn colCharacter) {
        this.colCharacter = colCharacter;
    }



    public TableColumn getColName() {
        return colName;
    }

    public void setColName(TableColumn colName) {
        this.colName = colName;
    }



    public void setupStage() throws Exception{
        // https://stackoverflow.com/questions/23132302/invocationtargetexception-when-running-a-javafx-program
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mockups/WineListForm.fxml"));
        loader.setController(this);
        Parent root = loader.load();

        primaryStage.setTitle("Vinkällaren");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        final String os = System.getProperty ("os.name");
        if (os != null && os.startsWith ("Mac"))
            mbAppMenu.useSystemMenuBarProperty().set(true);
    }


    public void addWine(ActionEvent actionEvent) throws IOException {
        // TODO: Förstå varför IntelliJ inte tycker att metoden används.
        System.out.println("Klickade Add");

        WineBase workwine = White.exampleWhite();
        EntryController entryController = new EntryController(workwine);
        entryController.showStage(); // TODO: använd funktion som stannar kvar i entryController tills man aktivt lämnar den.
        Wine returned = entryController.getWine();

        System.out.printf("Name: '%s'\n", returned.getName());

        cellarManager.add(returned);

        updateTableView();
        updateListView();
    }

    private void initMenu() {
        // TODO: Lägg till undermenyer.
    }

    private void initListView() {

    }

    private void initTableView() {
        ObservableList winesColumns = tvWines.getColumns();
        winesColumns.clear();

        TableColumn<Wine, String> nameCol = new TableColumn<>("Namn");
        nameCol.setCellValueFactory(celldata -> new ReadOnlyStringWrapper(celldata.getValue().getName()));
        nameCol.setSortable(false);

        TableColumn<Wine, Integer> vintageCol = new TableColumn<>("# Årgång");
        vintageCol.setCellValueFactory(celldata -> new SimpleIntegerProperty( celldata.getValue().getVintage()).asObject());
        vintageCol.setSortable(false);

        TableColumn<Wine, String> typeCol = new TableColumn<>("Typ");
        typeCol.setCellValueFactory(celldata -> new ReadOnlyStringWrapper(celldata.getValue().getWineType().toString()));
        typeCol.setSortable(false);

        TableColumn<Wine, String> charCol = new TableColumn<>("Karaktär");
        charCol.setCellValueFactory(celldata -> new ReadOnlyStringWrapper(celldata.getValue().getCharacterType().toString()));
        charCol.setSortable(false);

        TableColumn<Wine, String> noteCol = new TableColumn<>("Notering");
        noteCol.setCellValueFactory(celldata -> new ReadOnlyStringWrapper(celldata.getValue().getNotes()));
        noteCol.setSortable(false);




        winesColumns.addAll(nameCol, vintageCol, typeCol, charCol, noteCol);

        Wine white =  White.exampleWhite();
        tvWines.getItems().add(White.exampleWhite());
    }

    private void updateListView() {
        lvWines.getItems().clear();
        for(Wine wine : cellarManager.getWines()) {
            lvWines.getItems().add(wine.getName());
        }
    }

    private void updateTableView() {

        tvWines.getItems().clear();
        for(Wine wine : cellarManager.getWines() ) {
            System.out.printf("Vin från cellarManager: %s\n", wine.getName());
            tvWines.getItems().add(wine);
        }
    }

    public void editWine(ActionEvent actionEvent) {
        System.out.println("Klickade Redigera");
        //tvWines.getItems().
    }

    public void removeWine(ActionEvent actionEvent) {
        System.out.println("Klickade Ta bort");
        System.out.println(tvWines.selectionModelProperty().toString());
        System.out.printf("Vald rad: %d. \n", tvWines.getSelectionModel().getFocusedIndex());
    }
}

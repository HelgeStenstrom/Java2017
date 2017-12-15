/*
 * Copyright (c) 2017. Helge Stenström
 */

package Helge;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;



public class ListController {

    // Fields

    public Button btnAddWine;
    public Button btnEdit;
    public Button btnRemove;
    private CellarManager cellarManager = new CellarManager();
    public TableColumn colCharacter;
    public TableColumn colName;
    public TableColumn colType;
    public TableColumn colVintage;
    public MenuBar mbAppMenu;
    private Stage primaryStage;
    public TableView tvWines;


    /**
     * The MVC(?) controller for the wine list form. It gets the primaryStage from the application starter.
     * @param primaryStage
     * @throws Exception
     */
    public ListController(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        setupStage();
        initTableView();
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
        primaryStage.setScene(new Scene(root)); //, 300, 275));
        primaryStage.show();
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
    }

    private void initTableView() {

        TableColumn<Wine, String> nameCol = new TableColumn<>("Namn");
        nameCol.setCellValueFactory(celldata -> new ReadOnlyStringWrapper(celldata.getValue().getName()));

        ObservableList winesColumns = tvWines.getColumns();
        winesColumns.clear();
        winesColumns.addAll(nameCol);

        Wine white =  White.exampleWhite();
        tvWines.getItems().add(White.exampleWhite());
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
    }

    public void removeWine(ActionEvent actionEvent) {
        System.out.println("Klickade Ta bort");
    }
}

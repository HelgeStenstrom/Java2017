/*
 * Copyright (c) 2017. Helge Stenström
 */

package Helge;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.swing.event.TableModelListener;
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
        // Parent root = FXMLLoader.load(getClass().getResource("mockups/WineListForm.fxml"));
        // TODO: Förstå varför jag får InvocationTargetException
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mockups/WineListForm.fxml"));
        loader.setController(this);
        Parent root = loader.load();  // TODO: förstå InvocationTargetException

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
        TableColumn newName = new TableColumn("Namn(ny)");
        TableColumn newCharacter = new TableColumn("Karaktär(ny)");
        TableColumn<Wine, String> charCol = new TableColumn<>("Karaktär");

        TableColumn<Wine, String> nameCol = new TableColumn<>("Namn 3");
        nameCol.setCellValueFactory(celldata -> new ReadOnlyStringWrapper(celldata.getValue().getName()));

        // charCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getEthic().getStyle()));
        // charCol.setCellValueFactory(o -> o.getValue().toString());
        // charCol.setCellValueFactory(o -> o.getValue().getCharacterType().toString());

        //newName.setCellValueFactory(o -> new ReadOnlyStringWrapper(o.getValue()));
        //ObservableList<Wine> wines = new O

        ObservableList x = tvWines.getColumns();
        x.clear();
        tvWines.getColumns().addAll(nameCol);
        //tvWines.getItems().add(new String[] {"test of adding a row"});
        Wine white =  White.exampleWhite();
        tvWines.getItems().add(White.exampleWhite());
    }

    private void updateTableView() {

        tvWines.getItems().clear();
        for(Wine wine : cellarManager.getWines() ) {
            System.out.printf("Vin från cellarManager: %s\n", wine.getName());
            // TODO: lägg till vin i listan
            // tvWines.getItems().add(new String[] {"hej", "hopp", "tre", "fyra"});
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

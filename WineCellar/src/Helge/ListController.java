package Helge;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class ListController {
    public ListController() {
        // initTableView();
    }

    public ListController(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        setupStage();
        initTableView();
    }

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


    private Stage primaryStage;
    public Button btnAddWine;
    public Button btnEdit;
    public Button btnRemove;
    public TableView tvWines;

    public TableColumn getColName() {
        return colName;
    }

    public void setColName(TableColumn colName) {
        this.colName = colName;
    }

    public TableColumn colName;
    public TableColumn colType;
    public TableColumn colVintage;
    public TableColumn colCharacter;
    private CellarManager cellarManager = new CellarManager();

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
        TableColumn tc1 = new TableColumn("Ett");
        TableColumn tc2 = new TableColumn("Två");
        ObservableList x = tvWines.getColumns();
        tvWines.getColumns().addAll(tc1, tc2);
    }

    private void updateTableView() {
        
        for(Wine wine : cellarManager.getWines() ) {
            System.out.println(wine.getName());
            
        }
    }

    public void editWine(ActionEvent actionEvent) {
        System.out.println("Klickade Redigera");
    }

    public void removeWine(ActionEvent actionEvent) {
        System.out.println("Klickade Ta bort");
    }
}

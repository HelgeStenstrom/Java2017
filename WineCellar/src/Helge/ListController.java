/*
 * Copyright (c) 2017. Helge Stenström
 */

package Helge;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        initMenu();
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


    private void initMenu() {

        // mbAppMenu är redan skapad via fxml-filen. Tyvärr ser inte IntelliJ vad den har för innehåll
        // så jag skapar innehållet här.

        Menu menuFile = new Menu("Fil");
        MenuItem itemQuit = new MenuItem("Avsluta");
        itemQuit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });

        menuFile.getItems().addAll(itemQuit);

        Menu menuHelp = new Menu("Hjälp");
        MenuItem itemAbout = new MenuItem("Om");
        menuHelp.getItems().addAll(itemAbout);

        itemAbout.setOnAction(this::showAboutBox);

        mbAppMenu.getMenus().clear();
        mbAppMenu.getMenus().addAll(menuFile, menuHelp);


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
            // System.out.printf("Vin från cellarManager: %s\n", wine.getName());
            tvWines.getItems().add(wine);
        }
    }

    private void enterWine(WineBase workwine) throws IOException {
        EntryController entryController = new EntryController(workwine);
        entryController.showStage(); // TODO: använd funktion som stannar kvar i entryController tills man aktivt lämnar den.
        Wine returned = entryController.getWine();

        // System.out.printf("Name: '%s'\n", returned.getName());

        if (entryController.isKeepWine())
            cellarManager.add(returned);

        updateTableView();
        updateListView();
    }

    public void addWine(ActionEvent actionEvent) throws IOException {
        // TODO: Förstå varför IntelliJ inte tycker att metoden används.

        WineBase workwine = White.exampleWhite();
        enterWine(workwine);
    }

    /**
     * Edit the selected wine. The Entry form is brought up with the selected wine pre-filled.
     * @param actionEvent
     */
    public void editWine(ActionEvent actionEvent) {
        System.out.println("Klickade Redigera");
        //tvWines.getItems().
        // TODO: implementera editWine
        // TODO: Se till att Cancel fungerar i EntryForm

        int selected = tvWines.getSelectionModel().getSelectedIndex();
        if (selected >= 0) {
            Wine workwine = cellarManager.get(selected);
            //enterWine(workwine);
            // TODO: Utred var jag ska använda Wine respektve WineBase.

        }

    }

    /**
     * Remove the selected wine from the wine manager.
     * @param actionEvent
     */
    public void removeWine(ActionEvent actionEvent) {
        int selected = tvWines.getSelectionModel().getSelectedIndex();
        if (selected >= 0)
            cellarManager.remove(selected);

        updateTableView();
        updateListView();
    }


    /**
     * Callback used to show an About box. Used when the Hjälp button is clicked,
     * or when Om is selected from the HJälp menu.
     * @param actionEvent
     */
    public void showAboutBox(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Om det här programmet...");
        alert.setHeaderText("Projektuppgift i Java, HKR 2017");

        String txt = "";
        txt += "Programmet hanterar en lista över viner. Vinerna har namn, årgång, type (rött eller vitt), ";
        txt += "smakkaraktär och eventuellt anteckningar om vinet.";
        txt += "\n";
        txt += "Klicka 'Lägg till vin', så öppmas ett formulär för att lägga till viner.";
        txt += "";
        txt += "";
        txt += "";

        txt += "\n";
        txt += "(c) 2017 Helge Stenström \n";

        alert.setContentText(txt);
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }
}

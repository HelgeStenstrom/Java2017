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


/**
 * The ListController handles events from GUI objects of the main window, the wine list form.
 */
public class ListController {

    // Fields

    private Button btnAddWine;
    private Button btnEdit;
    private Button btnRemove;
    private CellarManager cellarManager = new CellarManager();
    private TableColumn colCharacter;
    private TableColumn colName;
    private TableColumn colType;
    private TableColumn colVintage;
    public MenuBar mbAppMenu;   // TODO: förstå varför mbAppMenu måste vara public
    private Stage primaryStage;
    public TableView tvWines;   // TODO: förstå varför tvWines måste vara public


    /**
     * The MVC(?) controller for the wine list form. It gets the primaryStage from the application starter.
     * @param primaryStage
     * @throws Exception
     */
    public ListController(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        setupStage();
        initTableView();
        initMenu();
    }

    /**
     * Initialize the graphical components of the Wine list GUI
     * @throws Exception
     */
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


    /**
     * Initialize the application menu.
     */
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

    /**
     * Initialize the table view used for wines, by defining columns for it.
     */
    private void initTableView() {
        ObservableList winesColumns = tvWines.getColumns();
        winesColumns.clear();

        TableColumn<WineBase, String> nameCol = new TableColumn<>("Namn");
        nameCol.setCellValueFactory(celldata -> new ReadOnlyStringWrapper(celldata.getValue().getName()));
        nameCol.setSortable(false);

        TableColumn<WineBase, Integer> vintageCol = new TableColumn<>("# Årgång");
        vintageCol.setCellValueFactory(celldata -> new SimpleIntegerProperty( celldata.getValue().getVintage()).asObject());
        vintageCol.setSortable(false);

        TableColumn<WineBase, String> typeCol = new TableColumn<>("Typ");
        typeCol.setCellValueFactory(celldata -> new ReadOnlyStringWrapper(celldata.getValue().getWineType().toString()));
        typeCol.setSortable(false);

        TableColumn<WineBase, String> charCol = new TableColumn<>("Karaktär");
        charCol.setCellValueFactory(celldata -> new ReadOnlyStringWrapper(celldata.getValue().getCharacterType().toString()));
        charCol.setSortable(false);

        TableColumn<WineBase, String> noteCol = new TableColumn<>("Notering");
        noteCol.setCellValueFactory(celldata -> new ReadOnlyStringWrapper(celldata.getValue().getNotes()));
        noteCol.setSortable(false);

        winesColumns.addAll(nameCol, vintageCol, typeCol, charCol, noteCol);

        WineBase white =  White.exampleWhite();
        tvWines.getItems().add(White.exampleWhite());
    }

    /**
     * Update the table view for wines with data from the cellar manager.
     */
    private void updateTableView() {

        tvWines.getItems().clear();
        for(WineBase wine : cellarManager.getWines() ) {
            // System.out.printf("Vin från cellarManager: %s\n", wine.getName());
            tvWines.getItems().add(wine);
        }
    }

    /**
     * Add a wine to the cellar manager, by calling the wine entry form.
     * Triggered by clicking "Lägg till vin" button
     * @param actionEvent
     * @throws IOException
     */
    public void addWine(ActionEvent actionEvent) throws IOException {
        // TODO: Förstå varför IntelliJ inte tycker att metoden används.

        WineBase workwine = White.exampleWhite();
        EntryController entryController = new EntryController(workwine);
        entryController.showStage();
        WineBase returned = entryController.getWine();

        if (entryController.isKeepWine())
            cellarManager.add(returned);

        updateTableView();
    }

    /**
     * Edit the selected wine. The Entry form is brought up with the selected wine pre-filled.
     * @param actionEvent
     */
    public void editWine(ActionEvent actionEvent) throws IOException {
        int selected = tvWines.getSelectionModel().getSelectedIndex();
        if (selected >= 0) {
            WineBase workwine = cellarManager.get(selected);
            EntryController entryController = new EntryController(workwine);
            entryController.showStage(); // TODO: använd funktion som stannar kvar i entryController tills man aktivt lämnar den.
            WineBase returned = entryController.getWine();

            if (entryController.isKeepWine()) {
                cellarManager.replace(selected, returned);
            }

            updateTableView();
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

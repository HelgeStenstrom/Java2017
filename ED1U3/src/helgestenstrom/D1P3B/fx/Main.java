package helgestenstrom.D1P3B.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("issueTracker.fxml"));
        primaryStage.setTitle("Issue Tracker");
        primaryStage.setScene(new Scene(root)); // Man kan ange width och height, men då får man problem med att de måsta vara lagom.
                                                // Det görs i Scene(root, 600, 275)
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

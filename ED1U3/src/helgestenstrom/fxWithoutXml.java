/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

import com.sun.javafx.font.freetype.HBGlyphLayout;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Scanner;

public class fxWithoutXml extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // TODO: Läs http://www.java2s.com/Tutorials/Java/JavaFX/0020__JavaFX_HelloWorld.htm

        Button btn = new Button("Say Hello");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hej världen");
            }
        });

        Pane root = new StackPane();
        HBox hBox = new HBox();
        root.getChildren().add(hBox);
        hBox.getChildren().add(btn);
        hBox.getChildren().add(new Button("K2"));

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Min Fx utan xml");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

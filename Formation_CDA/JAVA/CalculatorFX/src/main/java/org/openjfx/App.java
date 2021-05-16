package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/openjfx/gui/calculator.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Calculatrice");
        primaryStage.setMaxHeight(415);
        primaryStage.setMaxWidth(265);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

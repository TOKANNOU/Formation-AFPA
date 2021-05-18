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
        Parent root = FXMLLoader.load(getClass().getResource("gui/register.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Liste des clients");
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(1000);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

package io.github.tryexceptelse.jdex.fe;/**
 * Application Window
 */

import javafx.application.Application;
import javafx.collections.FXCollections;  // observable list
import javafx.fxml.FXMLLoader; // to load the fxml file for scene
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * startup method run when window is launched
     * @param primaryStage: Staging for window
     */
    @Override
    public void start(Stage primaryStage) {} // skeleton
}

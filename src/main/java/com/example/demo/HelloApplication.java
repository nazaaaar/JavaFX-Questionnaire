package com.example.demo;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    static public Stage getStage() {
        return stage;
    }

    static public void setStage(Stage stage) {
        HelloApplication.stage = stage;
    }

    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        Data.CreateTables();

        HelloApplication.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Starting the questionnaire");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
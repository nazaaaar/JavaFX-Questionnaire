package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SimpleController {

    protected void GoTo(String name, String title) throws IOException {
        Stage stage = HelloApplication.getStage();

        Parent root = FXMLLoader.load(getClass().getResource(name));
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.show();
    }
    public void MyAnswers() throws IOException {
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MyAnswers.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MyAnswers");
        stage.setScene(scene);
        stage.show();
        HelloApplication.getStage().hide();
    }
    public void Exit(){
        HelloApplication.getStage().close();
    }
}

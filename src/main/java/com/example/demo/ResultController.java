package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class ResultController extends SimpleController{

    //@FXML
    //private AnchorPane resultWindow;

    private static ResultController resultController;
    @FXML
    private Label ans1, ans2, ans3;

    public void initialize(){
      //  resultController=this;

        Data.AddAnswerRecord();

        ans1.setText(Data.getAnswer1());
        ans2.setText(Data.getAnswer2());
        ans3.setText(Data.getAnswer3());
    }

    public void About() throws IOException {
        //GoTo("about.fxml", "Інформація про розробника програми");

        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("about.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Інформація про розробника програми");
        stage.setScene(scene);
        stage.show();

        //resultWindow.setDisable(true);
        HelloApplication.getStage().hide();
    }

    public void PersonalCabinet() throws IOException {
        GoTo("PersonalCabinet.fxml","Personal cabinet");
    }



   /* private void _Unlock(){
        HelloApplication.getStage().show();

        //resultWindow.setDisable(false);
    }

    public static void Unlock(){
        resultController._Unlock();
    }*/
}

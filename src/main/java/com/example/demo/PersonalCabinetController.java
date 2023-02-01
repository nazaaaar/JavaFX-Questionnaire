package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonalCabinetController extends SimpleController {
    public void Start() throws IOException {
        Data.ClearAnswers();
        GoTo("task2.fxml", "Question 1 of 3");
    }

    public void LogOut() throws IOException{
        GoTo("Login.fxml", "Login");
    }

}

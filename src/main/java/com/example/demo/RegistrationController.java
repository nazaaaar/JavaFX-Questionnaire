package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegistrationController extends SimpleController {
    @FXML
    private TextField name;
    @FXML
    private PasswordField password;
    @FXML
    private Label info, usernameCheck;


    public void Back() throws IOException {
        GoTo("Login.fxml","Login");
    }

    public void CheckUsername(){
        usernameCheck.setText("...");
        if (Data.ValidateUsername(name.getText())) usernameCheck.setText("Username is correct");
        else usernameCheck.setText("Invalid or taken username");
    }

    public void Register(){
        if (Data.AddLoginRecord(name.getText(),password.getText())) info.setText("Success");
        else info.setText("Failure\nPassword should have at least 8 characters \nUsername should have less than 17 characters \nUsername could not contain spaces");
    }

}

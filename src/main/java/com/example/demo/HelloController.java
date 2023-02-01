package com.example.demo;

import java.io.IOException;

public class HelloController extends  SimpleController{
    public void switchToTask1() throws IOException {
        GoTo("Login.fxml","Програма анкетування");
    }
}
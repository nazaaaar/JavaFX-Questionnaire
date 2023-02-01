package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;

import java.io.IOException;

public class Task2Controller extends SimpleController{

    @FXML
    private SplitMenuButton splitMenuButton;
    @FXML
    private MenuItem m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11;

    private MenuItem[] menuItems;

    @FXML
    public void initialize(){
        menuItems = new MenuItem[]{m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11};

        for (MenuItem item:
             menuItems) {
            item.setOnAction(e -> splitMenuButton.setText(item.getText()));
        }

        if (Data.getAnswer1() != null) splitMenuButton.setText(Data.getAnswer1());
    }
    public void SwitchToTask3() throws IOException {
        String ans1 = splitMenuButton.getText();
        Data.setAnswer1(ans1);

        GoTo("task3.fxml","Запитання 2 з 3");
    }

}

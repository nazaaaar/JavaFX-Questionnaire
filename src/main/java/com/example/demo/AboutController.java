package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AboutController {

    @FXML
    SplitMenuButton splitMenuButton;
    @FXML
    MenuItem m1,m2;
    @FXML
    private Label date;
    public void initialize(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        date.setText(dtf.format(now));

        m1.setOnAction(e -> splitMenuButton.setText(m1.getText()));
        m2.setOnAction(e -> splitMenuButton.setText(m2.getText()));
    }
    public void Close(ActionEvent event) throws IOException {
        //ResultController.Unlock();
        HelloApplication.getStage().show();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}

package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.Math.ceil;

public class MyAnswersController {
    @FXML
    private Label id1,ans1_1,ans2_1,ans3_1,ans1_2,id2,ans2_2,ans3_2, PageLabel;
    @FXML
    private Button PrevButton, NextButton;

    final int attributesCount = 4;
    private List<Label[]> records = new LinkedList<>();

    public void initialize(){
        records.add(new Label[] {id1,ans1_1,ans2_1,ans3_1});
        records.add(new Label[] {id2,ans1_2,ans2_2,ans3_2});

        LoadPage(currentPage);

        if (ansCount==0) NextButton.setDisable(true);
    }

    private final int ansCount = Data.GetAnswersCount(Data.getName());

    private final int recordForPageCount = 2;
    private int currentPage = 1;
    private final int pageCount = (int) ceil((float) ansCount/recordForPageCount);

    public void NextPage(){
        LoadPage(++currentPage);
    }

    public void PrevPage(){
        LoadPage(--currentPage);
    }
    private void LoadPage(int pageIndex){
        Queue<Answer> a = Data.GetAnswerRecords(Data.getName(), (pageIndex-1)*recordForPageCount,recordForPageCount);
        int i;
        for (i = 0;!a.isEmpty();i++) {
            records.get(i)[0].setText(a.peek().ID);
            records.get(i)[1].setText(a.peek().ans1);
            records.get(i)[2].setText(a.peek().ans2);
            records.get(i)[3].setText(a.remove().ans3);
        }
        for (;i<recordForPageCount;i++){
            for (Label record: records.get(i)) {
                record.setText("");
            }
        }
        UpdateWindow();
    }

    private void UpdateWindow(){
        PageLabel.setText("Page " +currentPage+ " of " + pageCount);

        PrevButton.setDisable(currentPage == 1);
        NextButton.setDisable(currentPage == pageCount);
    }

    public void Result(ActionEvent event){
        HelloApplication.getStage().show();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}


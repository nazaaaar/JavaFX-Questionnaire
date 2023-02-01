package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

import java.io.IOException;

public class Task4Controller extends SimpleController{
    private static int r = 0;

    public static void ClearSaves(){r=0;}
    private final int N = 5;
    @FXML
    RadioButton rdb1, rdb2, rdb3;

    RadioButton[] rdb;
    public void initialize(){

        rdb = new RadioButton[]{rdb1,rdb2,rdb3};

        rdb[r].setSelected(true);
    }

    public  void Save(){
        String ans = "";
        for (int i = 0; i < N; i ++){
            if (rdb[i].isSelected()){
                ans = rdb[i].getText();
                r = i;
                break;
            }
        }
        Data.setAnswer3(ans);
    }
    public void SwitchToResults() throws IOException {
        Save();
        GoTo("Result.fxml","Результати анкетування "+ Data.getName());
    }

    public void SwitchToTask2() throws IOException {
        Save();
        GoTo("Task3.fxml","Запитання 2 з 3");
    }



}

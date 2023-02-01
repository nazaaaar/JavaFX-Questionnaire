package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Task3Controller extends SimpleController {


    private static String nameSave;
    private final int N = 5;
    private boolean[] butons = new boolean[N];
    @FXML
    CheckBox ch1 ,ch2, ch3, ch4, ch5;
    @FXML
    TextField sviyVar;

    private CheckBox[] ch;
    public void initialize(){

        ch = new CheckBox[]{ch1,ch2,ch3,ch4,ch5};
        for (int i = 0; i < N; i++){
            int finalI = i;
            ch[i].setOnAction(e -> ClickButton(finalI));
        }

        if (Data.getSaveTask2() != null )butons = Data.getSaveTask2();
        for (int i = 0; i < N; i++){
            ch[i].setSelected(butons[i]);
        }
        if (Task3Controller.nameSave != null) sviyVar.setText(Task3Controller.nameSave);

    }

    public void ClickButton(int i){
        butons[i] = !butons[i];
    }


    private void Save(){
        String ans = "";
        for (int i = 0; i < N-1; i++){
            if (butons[i]){
                ans += ch[i].getText() + "\n";
            }
        }
        if (butons[N-1]){
            ans += sviyVar.getText() + "\n";
        }
        if (ans != "") Data.setAnswer2(ans);
        else Data.setAnswer2("Не вибрано");

        Data.setSaveTask2(butons);
        Task3Controller.nameSave = sviyVar.getText();
    };


    public void SwitchToTask3() throws IOException  {
        Save();
        GoTo("task4.fxml", "Запитання 3 з 3");
    }

    public void SwitchToTask1() throws IOException  {
        Save();
        GoTo("task2.fxml", "Запитання 1 з 3");
    }
}

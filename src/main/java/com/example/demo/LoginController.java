package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginController extends SimpleController {
    @FXML
    private TextField name;
    @FXML
    private TextField password;

    private boolean ValidateLogin(String username, String password){
        String sql =  "SELECT username, password FROM Login WHERE username = ? AND password = ?;";
        try (Connection conn = Data.connect(); PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setString(1,username);
            stmt.setString(2,password);

            return stmt.executeQuery().next();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void Continue() throws IOException {

        if (ValidateLogin(name.getText(),password.getText())){

        Data.setName(name.getText());
        GoTo("PersonalCabinet.fxml","Personal cabinet");}
    }

    public void switchToRegistration() throws IOException{
        GoTo("Registration.fxml","Registration");
    }


}

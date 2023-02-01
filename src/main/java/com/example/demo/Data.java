package com.example.demo;

import java.sql.*;
import java.util.*;

public class Data {

    public static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void CreateTables(){

        // SQL statement for creating a new table
        String Login = "CREATE TABLE IF NOT EXISTS Login (\n"
                + "	username text NOT NULL PRIMARY KEY CHECK (length(username) <= 16),\n"
                + "	password text NOT NULL CHECK (length(password) >= 8)\n"
                + ");";

        String Answers = "CREATE TABLE IF NOT EXISTS Answers (\n"
                + "	ID INTEGER NOT NULL PRIMARY KEY,\n"
                + "	ans1 text NOT NULL,\n"
                + "	ans2 text NOT NULL,\n"
                + "	ans3 text NOT NULL,\n"
                + " username text NOT NULL,\n"
                + "FOREIGN KEY (username)\n" +
                "       REFERENCES Login (username)"
                + ");";
        try (Connection conn = connect();Statement stmt = conn.createStatement();){
             stmt.execute(Login);
             stmt.execute(Answers);
        }
        catch (SQLException e) {
                System.out.println(e.getMessage());
        }
    }
    public static void AddAnswerRecord(){
        String sql = "INSERT INTO Answers (ans1, ans2, ans3, username) " +
                "VALUES (?, ?, ?, ?);";
        try (Connection conn = connect();PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setString(1,answer1);
            stmt.setString(2,answer2);
            stmt.setString(3,answer3);
            stmt.setString(4,name);
            stmt.execute();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Queue<Answer> GetAnswerRecords(String username, int start, int rowCount){
        String sql ="SELECT ID, ans1, ans2, ans3 FROM Answers WHERE username = ? LIMIT ?, ?;";

        ResultSet resultSet;
        Queue<Answer> res = new LinkedList<>();
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setString(1,username);
            stmt.setInt(2, start);
            stmt.setInt(3,rowCount);
            resultSet = stmt.executeQuery();
            while (resultSet.next()){
                res.add(new Answer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    };
    public static boolean AddLoginRecord(String username, String password){
        String sql = "INSERT INTO Login (username, password) " +
                "VALUES (?, ?);";

        if (!ValidateUsername(username) || !ValidatePassword(password)) return false;
        try (Connection conn = connect();PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setString(1,username);
            stmt.setString(2,password);
            stmt.execute();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    public static boolean ValidateUsername(String username){
        String sql =  "SELECT username FROM Login WHERE username = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setString(1,username);
            if (stmt.executeQuery().next()) return false;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return (!username.contains(" ") && username.length() <= 16 && username.length()!=0);
    }
    public static boolean ValidatePassword(String password){
        return password.length()>=8;
    }
    public static void GetLoginRecords(){
        String sql = "SELECT * FROM Login";
        ResultSet resultSet;

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.execute();
            resultSet = stmt.getResultSet();
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static int GetAnswersCount(String username){
        String sql = "SELECT COUNT(*) FROM Answers WHERE username = ?";
        ResultSet resultSet;

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setString(1,username);
            stmt.execute();
            resultSet = stmt.getResultSet();
            if (resultSet.next()) return resultSet.getInt(1);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    };
    public static void main(String[] args) {
        CreateTables();
        //AddLoginRecord("nazar_566q","12345678");
        //AddAnswerRecord();
        System.out.println(GetAnswersCount("nazar_k"));
        GetLoginRecords();
    }
    private static String name;
    private static String answer1;
    private static String answer2;
    private static String answer3;
    public static String getName() {
        return name;
    }
    public static void setName(String name) {
        Data.name = name;
    }
    public static String getAnswer1() {
        return answer1;
    }
    public static void setAnswer1(String answer1) {

        if (answer1 != null) Data.answer1 = answer1;
        else Data.answer1 = "Не вибрано";
    }
    public static String getAnswer2() {
        return answer2;
    }
    public static void setAnswer2(String answer2) {
        if (!answer2.equals("(вибір)")) Data.answer2 = answer2;
        else Data.answer2 = "Не вибрано";
    }
    public static String getAnswer3() {
        return answer3;
    }
    public static void setAnswer3(String answer3) {
        Data.answer3 = answer3;
    }
    private static boolean[] saveTask2;
    public static boolean[] getSaveTask2() {
        return saveTask2;
    }
    public static void setSaveTask2(boolean[] saveTask2) {
        Data.saveTask2 = saveTask2;
    }
    public static void ClearAnswers(){
        answer1 = null;
        answer2 = null;
        answer3 = null;
        saveTask2=null;
        Task4Controller.ClearSaves();
    }
}

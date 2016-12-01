package com.github.wiktorl4z;

import com.github.wiktorl4z.models.UserDataBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {
    private static Connection conn;
    public static Stage stage;

    public static UserDataBase userDataBase;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
        primaryStage.setTitle("Login From SQLite Database ");
        primaryStage.setScene(new Scene(root, 255, 200));
        primaryStage.show();

    }

    public static void CheckConnection() {
        DbConnector();
        if (conn == null) {
            System.out.println("Connection Not Successful");
            System.exit(1);
        } else {
            System.out.println("Connection Successful");
            userDataBase = new UserDataBase();
        }
    }

    public static Connection DbConnector() {
        if (conn == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:UserData.sqlite");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }
        }
        return conn;
    }

    public static void main(String[] args) {
        CheckConnection();
        launch(args);

    }
}

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.sqlite.SQLiteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main extends Application {
    Connection conn;


    @Override
    public void start(Stage primaryStage) throws Exception {

        PreparedStatement pst = null;

        Parent root = FXMLLoader.load(getClass().getResource("login1.fxml"));
        primaryStage.setTitle("Login From SQLite Database ");
        primaryStage.setScene(new Scene(root, 255, 200));
        primaryStage.show();
        CheckConnection();

    }


    public void CheckConnection() {
        conn = Controller.DbConnector();
        if (conn == null) {
            System.out.println("Connection Not Successful");
            System.exit(1);
        } else {
            System.out.println("Connection Successful");
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.sqlite.SQLiteConnection;

import java.sql.Connection;

public class Main extends Application {
    Connection conn;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("JavaFX & SQLite Database Connection");
        CheckConnection();
        
        
        primaryStage.show();
    }

    public void CheckConnection() {
     conn = Controller.DbConnector();
         if ( conn == null) {
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

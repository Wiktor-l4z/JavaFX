package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Controller {

    public static Connection DbConnector() {
        try {
            Connection conn = null;

            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:UserDatabase.sqlite");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}

package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;


import java.io.IOException;
import java.sql.*;




public class Controller {


    @FXML
    private Label lblMessage;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtUsername;

    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection conn = DbConnector();

    @FXML
    private void btnLoginAction() throws IOException {

        try {
            String query = "select * from UserDatabase where Username=? AND Password=?";

            pst = conn.prepareStatement(query);
            pst.setString(1, txtUsername.getText());
            pst.setString(2, txtPassword.getText());
            rs = pst.executeQuery();

            System.out.println(rs);
            if (rs.next()) {
                lblMessage.setText("Login Successful");
            } else {
                lblMessage.setText("Username or Password invalid!");
            }
            pst.close();
            rs.close();
        } catch (Exception e1) {
            lblMessage.setText("SQL Error");
            System.err.println(e1);
        }
    }
    public static Connection DbConnector() {
        try {
            Connection conn = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:UserData.sqlite");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}

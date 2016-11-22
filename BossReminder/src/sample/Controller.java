package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.*;


public class Controller {


    @FXML
    private Label lblMessage, LabeText;
    @FXML
    private PasswordField txtPassword, PasswordText;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField firstName, LoginText, lastName, EmailText, ID;

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
                //   ((Node)(lol.getSource())).getScene().getWindow().hide();
                Parent parent = FXMLLoader.load(getClass().getResource("mojaApka.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.setTitle("Create New Account");
                stage.show();
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

    @FXML
    private void CreateAccountAction() throws IOException {
        try {
            //  ((Node)(event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("CreateNewUser.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Create New Account");
            stage.show();
            System.out.printf("Gratuluje!");
        } catch (Exception e) {
            System.out.printf("NIE DZIALA");
        }
    }

    @FXML
    private void CreateAccAction() throws IOException {
        try {
            String query = "INSERT INTO UserDatabase (ID, FirstName, LastName, " +
                    "Email, Username, Password ) VALUES (?,?,?,?,?,?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, ID.getText());
            pst.setString(2, firstName.getText());
            pst.setString(3, lastName.getText());
            pst.setString(4, EmailText.getText());
            pst.setString(5, LoginText.getText());
            pst.setString(6, PasswordText.getText());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setContentText("User has been created");
            alert.showAndWait();

            pst.execute();
            pst.close();

        } catch (Exception e) {
            LabeText.setText("Error");
        }
    }

    @FXML
    private void LoginPanelAction() {
        try {
            //  ((Node)(event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("login1.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Create New Account");
            stage.show();

        } catch (Exception e) {
            System.out.printf("NIE DZIALA");
        }
    }

}

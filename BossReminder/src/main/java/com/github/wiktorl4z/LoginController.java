package com.github.wiktorl4z;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class LoginController {

    @FXML
    private Label lblMessage;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtUsername;

    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection conn = Main.DbConnector();

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
                Parent parent = FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
                Scene scene = new Scene(parent);
                Main.stage.setScene(scene);
                Main.stage.setTitle("Create New Account");
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


    @FXML
    private void RegisterAccountAction() throws IOException {
        try {

            Parent parent = FXMLLoader.load(getClass().getResource("/views/Register.fxml"));
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
}


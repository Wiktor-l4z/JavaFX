package com.github.wiktorl4z;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class RegisterController {

    @FXML
    private Label LabelText;
    @FXML
    private PasswordField PasswordText;
    @FXML
    private TextField firstName, LoginText, lastName, EmailText, ID;


    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection conn = Main.DbConnector();

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
            alert.setHeaderText(null);
            alert.showAndWait();

            pst.execute();
            pst.close();
            Clearfields();

        } catch (Exception e) {
            LabelText.setText("Error");
        }
    }

    public void Clearfields() {
        ID.clear();
        firstName.clear();
        lastName.clear();
        EmailText.clear();
        LoginText.clear();
        PasswordText.clear();
    }

    @FXML
    private void LoginPanelAction() {
        try {

            Parent parent = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
            Scene scene = new Scene(parent);
            Main.stage.setScene(scene);
            Main.stage.setTitle("Create New Account");

        } catch (Exception e) {
            System.out.printf("NIE DZIALA");
        }
    }

    @FXML
    private void initialize() {
    }
}



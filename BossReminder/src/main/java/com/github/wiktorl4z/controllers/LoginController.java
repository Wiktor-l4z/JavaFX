package com.github.wiktorl4z.controllers;

import com.github.wiktorl4z.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.*;


public class LoginController {

    @FXML
    private Label lblMessage;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfUsername;


    @FXML
    private void btnLoginAction() throws IOException {
        String u = tfUsername.getText().trim();
        String p = tfPassword.getText();

        if (u == null || p == null || u.length() == 0 || p.trim().length() == 0) {
            lblMessage.setText("Username or Password empty!");
            return;
        }
        if (Main.userDataBase.isCorrectLogin(u, p)) {   // wysylamy parametry
            lblMessage.setText("Login Successful");
            Parent parent = FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
            Scene scene = new Scene(parent);
            Main.stage.setScene(scene);
            Main.stage.setTitle("Menu");
        } else {
            lblMessage.setText("Username or Password invalid!");
        }
    }


    @FXML
    private void RegisterAccountAction() throws IOException {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/views/Register.fxml"));
            Scene scene = new Scene(parent);
            Main.stage.setScene(scene);
            Main.stage.setTitle("Create New Account");
            Main.stage.show();
            System.out.printf("Gratuluje!");
        } catch (Exception e) {
            System.out.printf("NIE DZIALA");
        }
    }
}


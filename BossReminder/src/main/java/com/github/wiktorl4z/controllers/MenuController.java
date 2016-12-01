package com.github.wiktorl4z.controllers;

import com.github.wiktorl4z.*;
import com.github.wiktorl4z.models.User;
import com.github.wiktorl4z.models.mappers.UserMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;


public class MenuController {

    @FXML
    private Label labelText;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfUsername, tfLastName, tfEmail, tfFirstName;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<UserMapper, String>
            idColumn, lastNameColumn, emailColumn, userNameColumn, passwordColumn, firstNameColumn;
    @FXML
    private ComboBox ComboBoxFirstName;

    public void clearFields() {
        tfFirstName.clear();
        tfLastName.clear();
        tfEmail.clear();
        tfUsername.clear();
        tfPassword.clear();
    }

    private boolean validateFields() {
        if (tfFirstName.getText().isEmpty() || tfLastName.getText().isEmpty() || tfEmail.getText().isEmpty() ||
                tfUsername.getText().isEmpty() || tfPassword.getText().isEmpty()) {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Validate Fields");
            alert1.setContentText("Please Enter Into The Fields");
            alert1.setHeaderText(null);
            alert1.showAndWait();
            return false;
        }
        return true;
    }

    @FXML
    private void CreateButtonAction() throws IOException {
        if (validateFields()) {
            try {
                String fn = tfFirstName.getText();
                String ln = tfLastName.getText();
                String em = tfEmail.getText();
                String un = tfUsername.getText();
                String ps = tfPassword.getText();

                if (Main.userDataBase.createUser(fn, ln, em, un, ps)) {
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Information Dialog");
                    alert1.setContentText("User has been created");
                    alert1.setHeaderText(null);
                    alert1.showAndWait();
                }
                clearFields();
            } catch (Exception e) {
                labelText.setText("Not Working@!");
            }
        }
    }

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<UserMapper, String>("ID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<UserMapper, String>("tfFirstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<UserMapper, String>("tfLastName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<UserMapper, String>("email"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<UserMapper, String>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<UserMapper, String>("password"));
        fillComboBox();
    }

    @FXML
    private ObservableList<String> firstNamesList;

    @FXML
    private void fillComboBox() {
        firstNamesList = FXCollections.observableArrayList();
        List<String> names = Main.userDataBase.getFirstNames();
        for (String name : names) {
            firstNamesList.add(name);
        }
        ComboBoxFirstName.setItems(firstNamesList);
    }

    @FXML
    ObservableList<UserMapper> data = FXCollections.observableArrayList();

    @FXML
    private void loadButtonAction() {
        data.clear();
        List<User> users = Main.userDataBase.getUsers();
        for (User user : users
                ) {
            data.add(new UserMapper(user));
        }
        tableView.setItems(data);
    }
}




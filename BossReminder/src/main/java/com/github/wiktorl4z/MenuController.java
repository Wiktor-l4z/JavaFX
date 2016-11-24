package com.github.wiktorl4z;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class MenuController {

    @FXML
    private Label labelText1;
    @FXML
    private PasswordField Password1;
    @FXML
    private TextField firstName, LoginText, lastName, Username1, LastName1, Email1,
            firstName1;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn <UserMapper,String> FirstName2;
    @FXML
    private TableColumn <UserMapper,String>
    ID2, LastName2,Email2,Username2, Password2;

    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection conn = Main.DbConnector();

    public void Clearfields() {

        firstName1.clear();
        LastName1.clear();
        Email1.clear();
        Username1.clear();
        Password1.clear();
    }

    @FXML
    private void CreateButtonAction() throws IOException {
        try {
            String query = "INSERT INTO UserDatabase (FirstName, LastName, " +
                    "Email, Username, Password ) VALUES (?,?,?,?,?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, firstName1.getText());
            pst.setString(2, LastName1.getText());
            pst.setString(3, Email1.getText());
            pst.setString(4, Username1.getText());
            pst.setString(5, Password1.getText());

            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Information Dialog");
            alert1.setContentText("User has been created");
            alert1.setHeaderText(null);
            alert1.showAndWait();

            pst.execute();
            pst.close();
            Clearfields();

        } catch (Exception e) {
            labelText1.setText("Not Working@!");
        }
    }

    @FXML
    private void initialize(){
        ID2.setCellValueFactory(new PropertyValueFactory<UserMapper,String>("ID"));
        FirstName2.setCellValueFactory(new PropertyValueFactory<UserMapper,String>("firstName"));
        LastName2.setCellValueFactory(new PropertyValueFactory<UserMapper,String>("lastName"));
        Email2.setCellValueFactory(new PropertyValueFactory<UserMapper,String>("email"));
        Username2.setCellValueFactory(new PropertyValueFactory<UserMapper,String>("username"));
        Password2.setCellValueFactory(new PropertyValueFactory<UserMapper,String>("password"));
    }


    @FXML
    private ObservableList<UserMapper> data = FXCollections.observableArrayList();

    @FXML
    private void loadButtonAction() {
        try {
            String query = "SELECT * FROM UserDatabase";
            pst = conn.prepareStatement(query);
            rs=pst.executeQuery();

            ArrayList <User> users = new ArrayList<>();
            while (rs.next()){
                users.add(new User(
                        rs.getString("ID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Email"),
                        rs.getString("Username"),
                        rs.getString("Password")
                ));
            }
            for (User user:users
                 ) { data.add(new UserMapper(user));

            }
            tableView.setItems(data);
            pst.close();
            rs.close();
        } catch (Exception e) {
            System.out.printf("NIE DZIALA!");
        }
    }
    }




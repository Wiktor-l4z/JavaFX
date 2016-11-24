package main.java;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getID() {
        return ID;
    }

    public User(String ID, String firstName, String lastName, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.ID = ID;
    }
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String ID;

}




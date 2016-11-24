package com.github.wiktorl4z;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserMapper {

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getID() {
        return ID.get();
    }

    public SimpleStringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public UserMapper(User user) {
        this.lastName = new SimpleStringProperty(user.getLastName());
        this.firstName = new SimpleStringProperty(user.getFirstName());
        this.email = new SimpleStringProperty(user.getEmail());
        this.username = new SimpleStringProperty(user.getUsername());
        this.ID = new SimpleStringProperty(user.getID());
        this.password = new SimpleStringProperty(user.getPassword());
    }

    private final SimpleStringProperty lastName;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty email;
    private final SimpleStringProperty username;
    private final SimpleStringProperty ID;
    private final SimpleStringProperty password;

}

package com.github.wiktorl4z;


import javafx.beans.property.SimpleStringProperty;

public class FirstNameMapper {
    private final SimpleStringProperty firstName;

    public FirstNameMapper(FirstName firstName) {
        this.firstName = new SimpleStringProperty(firstName.getFirstName());
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
}


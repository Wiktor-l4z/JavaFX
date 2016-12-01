package com.github.wiktorl4z.models;


import com.github.wiktorl4z.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDataBase {
    private Connection conn = Main.DbConnector();

    public boolean createUser(String firstName, String lastName, String email, String userName, String password) {
        PreparedStatement pst;
        try {
            String query = "INSERT INTO UserDatabase (FirstName, LastName, " +
                    "Email, Username, Password ) VALUES (?,?,?,?,?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, email);
            pst.setString(4, userName);
            pst.setString(5, password);
            boolean r = pst.execute();
            pst.close();
            return r;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getFirstNames() {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String query = "SELECT FirstName FROM UserDatabase";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            ArrayList<String> firstNames = new ArrayList<>();
            while (rs.next()) {
                firstNames.add(rs.getString("FirstName"));
            }
            pst.close();
            rs.close();
            return firstNames;
        } catch (Exception e) {
            System.out.printf("NIE DZIALA!");
            return null;
        }
    }

    public List<User> getUsers() {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String query = "SELECT * FROM UserDatabase";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            ArrayList<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(new User(
                        rs.getString("ID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Email"),
                        rs.getString("Username"),
                        rs.getString("Password")));
            }
            pst.close();
            rs.close();
            return users;
        } catch (Exception e) {
            System.out.printf("NIE DZIALA!");
            return null;
        }
    }
    public boolean isCorrectLogin(String u, String p) {
        PreparedStatement pst;
        ResultSet rs;
        try {
            String query = "select * from UserDatabase where Username=? AND Password=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, u);
            pst.setString(2, p);
            rs = pst.executeQuery();
            boolean result = false;
            if (rs.next()) {
                result = true;
            }
            pst.close();
            rs.close();
            return result;
        } catch (Exception e1) {
            System.err.println(e1);
            return false;
        }
    }
}



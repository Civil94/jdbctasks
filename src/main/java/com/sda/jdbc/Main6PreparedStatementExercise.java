package com.sda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.sda.jdbc.Configuration.*;

public class Main6PreparedStatementExercise {
    public static void main(String[] args) throws SQLException {

        List<String> names = List.of("Jan","Ala","Mikołaj","Kasia");
        List<String> passwords = List.of("password1","password2","password3","password4");

        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (username, password) values (?,?)");
        for(int i = 0; i < names.size();i++) {
            preparedStatement.setString(1, names.get(i));
            preparedStatement.setString(2, passwords.get(i));
            preparedStatement.executeUpdate();
        }
        preparedStatement.close();
        connection.close();


    }
}

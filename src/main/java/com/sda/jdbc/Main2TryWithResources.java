package com.sda.jdbc;

import java.sql.*;

import static com.sda.jdbc.Configuration.*;


public class Main2TryWithResources {
    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM animal");
        ) {
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);

                System.out.printf("Id: %s, Name: %s, Age: %s\n", id, name, age);
            }
        } catch (SQLException e) {
            System.out.println("Coś poszło nie tak:" + e.getMessage());
        }
    }
}

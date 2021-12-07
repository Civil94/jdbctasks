package com.sda.jdbc;

import java.sql.*;

public class Main1Preparation {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_schema", "root", "Mateusz6");
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM animal");

        while(resultSet.next()) {
            long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt("age");

            System.out.printf("Id: %s, Name: %s, Age: %s\n", id, name, age);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

}

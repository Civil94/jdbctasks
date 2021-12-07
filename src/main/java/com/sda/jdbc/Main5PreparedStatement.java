package com.sda.jdbc;

import java.sql.*;

import static com.sda.jdbc.Configuration.*;

public class Main5PreparedStatement {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT age FROM animal WHERE name =?");
        preparedStatement.setString(1,"Benio");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            int age = resultSet.getInt("age");
            System.out.println("Age: " + age);
        }
        resultSet.close();
        preparedStatement.close();

        connection.close();
    }
}

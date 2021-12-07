package com.sda.jdbc.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.sda.jdbc.Configuration.*;

public class Main9UserList {
    public static void main(String[] args) throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
        while(resultSet.next()){
            long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            String password = resultSet.getString(3);
            User user = new User(id,name,password);
            users.add(user);
        }
        users.forEach(System.out::println);

    }
}

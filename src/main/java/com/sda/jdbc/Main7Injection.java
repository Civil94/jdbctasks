package com.sda.jdbc;

import java.sql.*;

import static com.sda.jdbc.Configuration.*;

public class Main7Injection {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        boolean isLogged = login("username", "password", connection);

        System.out.println(login("Ala", "password2", connection));    //true
        System.out.println(login("Ala", "wrongpassword", connection)); //false
        System.out.println(login("Ala", "' OR '1' = '1", connection)); //false

        System.out.println(unsecuredLogin("Ala", "password2", connection));    //true
        System.out.println(unsecuredLogin("Ala", "wrongpassword", connection)); //false
        System.out.println(unsecuredLogin("Ala", "' OR '1' = '1", connection)); //false

        connection.close();
    }

    private static boolean unsecuredLogin(String username, String password, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM user WHERE username='" + username + "' AND password='" + password + "'"
        );
        boolean isLogged = resultSet.next();
        resultSet.close();
        statement.close();
        return isLogged;
    }

    private static boolean login(String username, String password, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username =? AND password =?");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean isLogged = resultSet.next();
        resultSet.close();
        preparedStatement.close();
        return isLogged;
    }
}

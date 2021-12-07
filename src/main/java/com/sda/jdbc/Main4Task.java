package com.sda.jdbc;

import java.sql.*;

import static com.sda.jdbc.Configuration.*;

public class Main4Task {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS user (id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50) UNIQUE, password VARCHAR(50))");
        statement.close();

        Statement insertStatement = connection.createStatement();
        insertStatement.executeUpdate("INSERT INTO user (username, password) values ('user1','admin123'),('user2','domek'),('user3','romek'),('user4','atomek')," +
                "('user5','adamek'),('user6','franek')");
        insertStatement.close();

        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery("SELECT username FROM user");
        while (resultSet.next()) {
            System.out.println("Username: " + resultSet.getString("username"));
        }
        resultSet.close();
        selectStatement.close();

        Statement deleteStatement = connection.createStatement();
        deleteStatement.executeUpdate("DELETE FROM user");
        deleteStatement.close();

        connection.close();
    }
}

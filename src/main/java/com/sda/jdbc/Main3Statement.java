package com.sda.jdbc;

import java.sql.*;

import static com.sda.jdbc.Configuration.*;

public class Main3Statement {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        Statement updateStatement = connection.createStatement();
        int amount = updateStatement.executeUpdate("UPDATE animal SET name = 'Jasio' WHERE id=2"); // UPDATE, DELETE, INSERT
        System.out.println("Ilość dotkniętych krotek: " + amount);
        updateStatement.close();

        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery("SELECT * FROM animal"); // SELECT
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            System.out.println("Imię: " + name);
        }
        resultSet.close();
        selectStatement.close();

        Statement truncateStatement = connection.createStatement();
        boolean hasResult = truncateStatement.execute("TRUNCATE TABLE animal"); // CREATE TABLE, TRUNCATE, DROP TABLE, ALTER TABLE
        System.out.println("Wynik metody execute jest: " + hasResult);
        truncateStatement.close();

        connection.close();
    }
}

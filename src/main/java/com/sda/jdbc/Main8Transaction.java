package com.sda.jdbc;

import java.sql.*;

import static com.sda.jdbc.Configuration.*;

public class Main8Transaction {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE user SET username = 'Ambroży' WHERE id = 37");
        Savepoint savepoint = connection.setSavepoint();
        try {
            statement.executeUpdate("UPDATE user SET username ='Eustachy' WHERE id = 38");
            statement.executeUpdate("UPDATE user SET wrongColumnName = 'Alina' WHERE id = 9");
        } catch (SQLException e) {
            connection.rollback();
        }

        statement.executeUpdate("UPDATE user SET username = 'Bożydar' WHERE id = 39");

        connection.commit();

        connection.close();
    }
}

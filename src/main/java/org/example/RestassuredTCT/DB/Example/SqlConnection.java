package org.example.RestassuredTCT.DB.Example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {

    public static void main(String[] args) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String jdbcUrl = System.getProperty("dragon.sandbox.jdbcUrl");
        String username = System.getProperty("dragon.sandbox.username");
        String password = System.getProperty("dragon.sandbox.password");

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            if (!connection.isClosed()) {
                System.out.println("We are connected!");
            }
        } catch (SQLException e) {
            System.out.println("there is no connection... Exception!");
        }
    }
}
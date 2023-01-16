package org.example.RestassuredTCT.DB.Example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {

    public Connection getConnection() throws SQLException, IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String jdbcUrl = System.getProperty("dragon.sandbox.jdbcUrl");
        String username = System.getProperty("dragon.sandbox.username");
        String password = System.getProperty("dragon.sandbox.password");

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
        return DriverManager.getConnection(jdbcUrl, username, password);
    }
}


//
//    public void doinsert() throws SQLException{
//        try(Connection connection = getConnection()){
//
//
//        }
    }
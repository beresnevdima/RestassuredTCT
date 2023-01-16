package org.example.RestassuredTCT.DB.Example;

import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.*;

public class SqlConnection {

    private final String jdbcUrl;
    private final String username;
    private final String password;

    public SqlConnection() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));

        this.jdbcUrl = System.getProperty("dragon.sandbox.jdbcUrl");
        this.username = System.getProperty("dragon.sandbox.username");
        this.password = System.getProperty("dragon.sandbox.password");
    }

    public Connection getConnection() throws SQLException {
        Connection connection;
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            if (!connection.isClosed()) {
                System.out.println("We are connected!");
            }
        } catch (SQLException e) {
            System.out.println("there is no connection... Exception!");
        }
        return DriverManager.getConnection(jdbcUrl, username, password);
    }
@Test
    public void doUpdate (String sqlSet){
        try (Connection connect = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = connect.createStatement()){
            stmt.executeUpdate(sqlSet);
        }
        catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }

}

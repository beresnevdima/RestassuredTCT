package org.example.RestassuredTCT.DB.Example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnection {

    private String sqlSet;
    private String sqlGet;

    public SqlConnection(String sqlSet) {
        this.sqlSet = sqlSet;

    }



    public Connection getConnection() throws SQLException, IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String jdbcUrl = System.getProperty("dragon.sandbox.jdbcUrl");
        String username = System.getProperty("dragon.sandbox.username");
        String password = System.getProperty("dragon.sandbox.password");

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = connection.createStatement()) {

        } catch (SQLException e ) {
            throw new Error("Problem", e);
        }

        return DriverManager.getConnection(jdbcUrl, username, password);


    }
//
//    public void doinsert() throws SQLException{
//        try(Connection connection = getConnection()){
//
//
//        }
    }
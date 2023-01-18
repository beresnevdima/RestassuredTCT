package org.example.RestassuredTCT.DB;

import java.io.IOException;
import java.sql.*;

public class DBConnection {

    private final String JDBC_URL;
    private final String USERNAME;
    private final String PASSWORD;

    public DBConnection() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));

        this.JDBC_URL = System.getProperty("dragon.sandbox.jdbcUrl");
        this.USERNAME = System.getProperty("dragon.sandbox.username");
        this.PASSWORD = System.getProperty("dragon.sandbox.password");
    }

//    public Connection getConnection() throws SQLException {
//        Connection connection;
//        try {
//            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
//            if (!connection.isClosed()) {
//                System.out.println("We are connected!");
//            }
//        } catch (SQLException e) {
//            System.out.println("there is no connection... Exception!");
//        }
//        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
//    }

    public void doUpdate(String sqlSet) {
        try (Connection connect = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = connect.createStatement()) {
            stmt.executeUpdate(sqlSet);
        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }

    public void doSelect(String sqlSelect, String columnLabel) throws SQLException {
        ResultSet res = null;

        try (Connection connect = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = connect.createStatement()) {
            res = stmt.executeQuery(sqlSelect);

            while (res.next()) {
                String name = res.getString(columnLabel);
                System.out.println(name);
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        } finally {
            if (res != null) {
                res.close();
            }
        }
    }
}
package org.example.RestassuredTCT.DB;

import java.io.IOException;
import java.sql.*;


public class DragonDBConnection {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String jdbcUrl = System.getProperty("dragon.sandbox.jdbcUrl");
        String username = System.getProperty("dragon.sandbox.username");
        String password = System.getProperty("dragon.sandbox.password");

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement()) {

            try {
                ResultSet rs = stmt.executeQuery("select name from un62.process_state");
                while (rs.next()) {
                    String name = rs.getString("name");
                    System.out.println(name);
                }
            } catch (SQLException e ) {
                throw new Error("Problem", e);
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }
}
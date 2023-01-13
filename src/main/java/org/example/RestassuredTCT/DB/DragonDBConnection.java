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
        ResultSet rs =null;
            try {

                int i = stmt.executeUpdate("UPDATE un62.interest_charges_v2 SET interest=0.01, accum=0.11, state='G', amount=100.00, debit=0.00, credit=0.00, is_double=NULL, is_end_of_grace=NULL, rate=37.50, client_id=500981 WHERE acc='21100200025461' AND date_calc='2022-09-01'");
                System.out.println(i);

                rs = stmt.executeQuery("SELECT state FROM un62.interest_charges_v2 WHERE acc='21100200025461' AND date_calc='2022-09-01'");
                while (rs.next()) {
                    String name = rs.getString("state");
                    System.out.println(name);

                    if ("G".equals(name)) {
                        System.out.println("Есть совпадение");
                    }
                        else {
                        System.out.println("Ошибка");
                    }
                }

            } catch (SQLException e ) {
                throw new Error("Problem", e);
            }
            finally {
                if (rs != null){
                    rs.close();
                }
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }
}
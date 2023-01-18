package org.example.RestassuredTCT.CreditDetails.Script1;

/// Отримання та перевірка "script": "1"
/// Трата, відкриття пільгового періоду

import io.restassured.response.Response;
import org.example.RestassuredTCT.SidTCT;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.sql.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Case1 {

    public Case1() throws IOException {}

    public static void main(String[] args) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String jdbcUrl = System.getProperty("dragon.sandbox.jdbcUrl");
        String username = System.getProperty("dragon.sandbox.username");
        String password = System.getProperty("dragon.sandbox.password");

        long acc = 21100200006917L;

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement()) {
            try {

                int delete = stmt.executeUpdate(
                        "delete FROM un62.debt_operation WHERE acc= '21100200006917';\n" +
                            "delete FROM un62.grace_period WHERE acc= '21100200006917';\n" +
                            "delete  FROM un62.min_bill  WHERE acc= '21100200006917';\n" +
                            "delete  FROM un62.interest_charges_V2  WHERE acc= '21100200006917';");
                System.out.println(delete);

                int update = stmt.executeUpdate(
                            "INSERT INTO un62.debt_operation\n" +
                             "(date_calc, tran_id, tran_id_repayment, acc, tran_date_time, debt_date_time, amt_debt, interest_rate, interest, count_day, amt_repayment, tlm, tran_tlm)\n" +
                             "VALUES('2023-01-02', '8769630', '*', '21100200006917', '2023-01-02 05:45:27.000', '2023-01-02 05:45:27.000', 45.00, 0.00, 0.00, NULL, NULL, '2023-01-02 12:50:35.029', '2023-01-02 12:50:35.029');\n" +

                                "INSERT INTO un62.grace_period\n" +
                            "(tran_id, acc, grace_start, grace_end, tran_id_repaid, grace_repaid, tlm)\n" +
                            "VALUES('8769630', '21100200006917', '2023-01-02', '2023-02-28', NULL, NULL, '2023-01-02 05:45:27.000');");
                System.out.println(update);

            } catch (SQLException e ) {
                throw new Error("Problem", e);
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }

    SidTCT sidTCT = new SidTCT();
    String sid = sidTCT.getSid();
    long uid = 2020005024L;
    int ClientId = 500341;

    @Test
    public void CreditDetails() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String baseUrl = System.getProperty("dragon-api.url");
        Response response = given()
                .when()
                .header("Content-Type", "application/json")
                .header("sid", sid)
                .header("Client-Id", ClientId)
                .get(baseUrl + "/api/v1/info/thing/details/"+uid)
                .then().log().all()
                .statusCode(200)
                .body("result.script", equalTo("1"))
                .body("result.totalSum", equalTo(45.00F))
                .body("result.paymentDue", equalTo("2023-02-28"))
                .body("result.fullRepay", equalTo(45.00F))
                .body("result.paymentState", equalTo("noMinPaym"))
                .body("result.contractState", equalTo("ACTIVE"))
                .body("result.graceStart", equalTo("2023-01-02T00:00:00.000Z"))
                .body("result.graceEnd", equalTo("2023-02-28T00:00:00.000Z"))
                .extract().response();






//        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
//        String baseUrl = System.getProperty("dragon-api.url");
//        ResponseCreditDetails responseCreditDetails = given()
//                .when()
//                .header("Content-Type", "application/json")
//                .header("sid", sid)
//                .header("Client-Id", ClientId)
//                .get(baseUrl + "/api/v1/info/thing/details/"+uid)
//                .then().log().all()
//                .statusCode(200)
//                .body("result.script", equalTo("1"))
//                .body("result.totalSum", equalTo(45.00F))
//                .body("result.paymentDue", equalTo("2023-02-28"))
//                .body("result.fullRepay", equalTo(45.00F))
//                .body("result.paymentState", equalTo("noMinPaym"))
//                .body("result.contractState", equalTo("ACTIVE"))
//                .body("result.graceStart", equalTo("2023-01-02T00:00:00.000Z"))
//                .body("result.graceEnd", equalTo("2023-02-28T00:00:00.000Z"))
//                .extract().as(ResponseCreditDetails.class);
    }
}
package org.example.RestassuredTCT.CreditDetails.Script1;

/// Отримання та перевірка "script": "1"
/// - Трата, відкриття пільгового періоду
/// - Поповнення на сумму меньшу, ніж трата

import org.example.RestassuredTCT.CreditDetails.CreditDetailsTemplate;
import org.example.RestassuredTCT.DB.DBConnection;
import org.example.RestassuredTCT.DTO.Response.ResponseCreditDetails;
import org.junit.Test;
import java.io.IOException;
import java.sql.SQLException;
import static org.hamcrest.Matchers.equalTo;

public class Case2 {

    String sqlSet = "delete FROM un62.debt_operation WHERE acc= '21100200006917';";
    String sqlSelect = "SELECT state FROM un62.interest_charges_v2 WHERE acc='21100200025461' AND date_calc='2022-09-01'";
    String columnLabel = "state";

//    String columnLabel = "acc";
    Long value = 21100200025461L;

    long uid = 2020005024L;
    int clientId = 500341;

    DBConnection sqlConnection = new DBConnection();
    CreditDetailsTemplate creditDetailsTemplate = new CreditDetailsTemplate();

    public Case2() throws IOException {}
    @Test
    public void Case2test () throws IOException, SQLException {
        sqlConnection.getConnection();
//        sqlConnection.doUpdate(sqlSet);
        sqlConnection.doSelect(sqlSelect, columnLabel);
        creditDetailsTemplate.CreditDetails(clientId, uid)
                .statusCode(200)
                .body("result.script", equalTo("1"))
                .body("result.totalSum", equalTo(45.00F))
                .body("result.paymentDue", equalTo("2023-02-28"))
                .body("result.fullRepay", equalTo(45.00F))
                .body("result.paymentState", equalTo("noMinPaym"))
                .body("result.contractState", equalTo("ACTIVE"))
                .body("result.graceStart", equalTo("2023-01-02T00:00:00.000Z"))
                .body("result.graceEnd", equalTo("2023-02-28T00:00:00.000Z"))
                .extract().as(ResponseCreditDetails.class);
    }
}
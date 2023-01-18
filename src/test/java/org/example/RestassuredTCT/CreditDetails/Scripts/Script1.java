package org.example.RestassuredTCT.CreditDetails.Scripts;

import org.example.RestassuredTCT.CreditDetails.CreditDetailsTemplate;
import org.example.RestassuredTCT.DB.DBConnection;
import org.example.RestassuredTCT.DTO.Response.ResponseCreditDetails1_3;
import org.junit.Test;

import java.io.IOException;

public class Script1 {
    Long value = 21100200006917L;
    String DeleteAllValuesFromTheTables =
                    "delete FROM un62.buckets_calc_transaction_cache WHERE acc = '"+value+"';\n" +
                    "delete FROM un62.debt_operation WHERE acc = '"+value+"';\n" +
                    "delete FROM un62.fee_operations WHERE acc = '"+value+"';\n" +
                    "delete FROM un62.buckets_calc_transaction_cache WHERE acc = '"+value+"';\n" +
                    "delete FROM un62.debt_operation WHERE acc = '"+value+"';\n" +
                    "delete FROM un62.fee_operations WHERE acc = '"+value+"';\n" +
                    "delete FROM un62.buckets_calc_transaction_cache WHERE acc = '"+value+"';\n" +
                    "delete FROM un62.debt_operation WHERE acc = '"+value+"';\n" +
                    "delete FROM un62.fee_operations WHERE acc = '"+value+"';";

    String SetValuesForTestCase1_1 =
            "INSERT INTO un62.debt_operation\n" +
            "(date_calc, tran_id, tran_id_repayment, acc, tran_date_time, debt_date_time, amt_debt, interest_rate, interest, count_day, amt_repayment, tlm, tran_tlm)\n" +
            "VALUES('2023-01-02', '8769630', '*', '21100200006917', '2023-01-02 05:45:27.000', '2023-01-02 05:45:27.000', 45.00, 0.00, 0.00, NULL, NULL, '2023-01-02 12:50:35.029', '2023-01-02 12:50:35.029');\n";

            DBConnection sqlConnection = new DBConnection();
    CreditDetailsTemplate creditDetailsTemplate = new CreditDetailsTemplate();

    public Script1() throws IOException {}
   @Test
    public void TestCase1 (int clientId, long uid) throws IOException {

        sqlConnection.doUpdate(DeleteAllValuesFromTheTables);
        sqlConnection.doUpdate(SetValuesForTestCase1_1);
        creditDetailsTemplate.CreditDetails(clientId, uid)
                .statusCode(200)
                .extract().as(ResponseCreditDetails1_3.class);

    }
}
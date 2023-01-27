package org.example.RestassuredTCT.CreditDetails.Scripts;

import org.example.RestassuredTCT.CreditDetails.CreditDetailsTemplate;
import org.example.RestassuredTCT.CreditDetails.Preconditions.PreconditionsFoScripts;
import org.example.RestassuredTCT.DTO.Response.ResponseCreditDetails1_3;
import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;

public class Script3 {

    CreditDetailsTemplate creditDetailsTemplate;
    PreconditionsFoScripts preconditionsFoScripts;
    public Script3 (CreditDetailsTemplate creditDetailsTemplate) throws IOException {
        this.creditDetailsTemplate = creditDetailsTemplate;
        this.preconditionsFoScripts = new PreconditionsFoScripts();
    }

    //   Повне погашення поточного min_bill
    public void testCase1 (int clientId, long uid) throws IOException {
        preconditionsFoScripts.deleteAllValuesFromTheTables();   // Видалення всіх записів з таблиць по рахунку
        preconditionsFoScripts.preconditionsFoScript3_1();       // Додавання тестових данних до БД
        creditDetailsTemplate.creditDetails(clientId, uid)       // Порівняння очікуваного результату з фактичним
                .statusCode(200)
                .body("result.script", equalTo("3"))
                .body("result.graceSum", equalTo(40.00F))
                .body("result.minPaySum", equalTo(0.00F))
                .body("result.minBillSum", equalTo(0.00F))
                .body("result.lateFeeSum", equalTo(0))
                .body("result.interestOnDebt", equalTo(3))
                .body("result.interestRate", equalTo(25.90F))
                .body("result.interestCharge", equalTo(0))
                .body("result.expiredSum", equalTo(0))
                .body("result.totalSum", equalTo(40.00F))
                .body("result.graceEnd", equalTo("2023-01-31T00:00:00.000Z"))
                .body("result.graceStart", equalTo("2022-12-01T00:00:00.000Z"))
                .body("result.penaltySum", equalTo(0))
                .body("result.fullRepay", equalTo(40.00F))
                .body("result.interestGrace", equalTo(5.16F))
                .body("result.paymentState", equalTo("paymMade"))
                .body("result.cashFee", equalTo(0))
                .body("result.transferFee", equalTo(0))
                .body("result.contractState", equalTo("ACTIVE"))
                .body("result.expiredFixSum", equalTo(0))
                .body("result.expiredTotalSum", equalTo(0))
                .body("result.otherFees", equalTo(0))
                .extract().as(ResponseCreditDetails1_3.class);
    }
}
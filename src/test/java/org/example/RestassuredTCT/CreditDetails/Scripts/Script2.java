package org.example.RestassuredTCT.CreditDetails.Scripts;

import org.example.RestassuredTCT.CreditDetails.CreditDetailsTemplate;
import org.example.RestassuredTCT.CreditDetails.Preconditions.PreconditionsFoScripts;
import org.example.RestassuredTCT.DTO.Response.ResponseCreditDetails1_3;
import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;

public class Script2 {

    CreditDetailsTemplate creditDetailsTemplate;
    PreconditionsFoScripts preconditionsFoScripts;
    public Script2 (CreditDetailsTemplate creditDetailsTemplate) throws IOException {
        this.creditDetailsTemplate = creditDetailsTemplate;
        this.preconditionsFoScripts = new PreconditionsFoScripts();
    }

    public void TestCase1 (int clientId, long uid) throws IOException {
        preconditionsFoScripts.DeleteAllValuesFromTheTables();   // Видалення всіх записів з таблиць по рахунку
        preconditionsFoScripts.PreconditionsFoScript2_1();       // Додавання тестових данних до БД
        creditDetailsTemplate.CreditDetails(clientId, uid)       // Порівняння очікуваного результату з фактичним
                .statusCode(200)
                .body("result.script", equalTo("2"))
                .body("result.graceSum", equalTo(50.00F))
                .body("result.minPaySum", equalTo(10.00F))
                .body("result.minBillSum", equalTo(10.00F))
                .body("result.lateFeeSum", equalTo(0))
                .body("result.interestOnDebt", equalTo(3))
                .body("result.interestRate", equalTo(25.90F))
                .body("result.interestCharge", equalTo(0))
                .body("result.expiredSum", equalTo(0))
                .body("result.totalSum", equalTo(50.00F))
                .body("result.graceEnd", equalTo("2023-01-31T00:00:00.000Z"))
                .body("result.graceStart", equalTo("2022-12-01T00:00:00.000Z"))
                .body("result.penaltySum", equalTo(0))
                .body("result.fullRepay", equalTo(50.00F))
                .body("result.interestGrace", equalTo(5.16F))
                .body("result.paymentState", equalTo("minTopup"))
                .body("result.cashFee", equalTo(0))
                .body("result.transferFee", equalTo(0))
                .body("result.contractState", equalTo("ACTIVE"))
                .body("result.expiredFixSum", equalTo(0))
                .body("result.expiredTotalSum", equalTo(0))
                .body("result.otherFees", equalTo(0))
                .extract().as(ResponseCreditDetails1_3.class);
    }


    // часткове погашення
    public void TestCase2 (int clientId, long uid) throws IOException {
        preconditionsFoScripts.DeleteAllValuesFromTheTables();   // Видалення всіх записів з таблиць по рахунку
        preconditionsFoScripts.PreconditionsFoScript2_2();       // Додавання тестових данних до БД
        creditDetailsTemplate.CreditDetails(clientId, uid)       // Порівняння очікуваного результату з фактичним
                .statusCode(200)
                .body("result.script", equalTo("2"))
                .body("result.graceSum", equalTo(43.00F))
                .body("result.minPaySum", equalTo(3.00F))
                .body("result.minBillSum", equalTo(3.00F))
                .body("result.lateFeeSum", equalTo(0))
                .body("result.interestOnDebt", equalTo(3))
                .body("result.interestRate", equalTo(25.90F))
                .body("result.interestCharge", equalTo(0))
                .body("result.expiredSum", equalTo(0))
                .body("result.totalSum", equalTo(43.00F))
                .body("result.graceEnd", equalTo("2023-01-31T00:00:00.000Z"))
                .body("result.graceStart", equalTo("2022-12-01T00:00:00.000Z"))
                .body("result.penaltySum", equalTo(0))
                .body("result.fullRepay", equalTo(43.00F))
                .body("result.interestGrace", equalTo(5.16F))
                .body("result.paymentState", equalTo("minTopup"))
                .body("result.cashFee", equalTo(0))
                .body("result.transferFee", equalTo(0))
                .body("result.contractState", equalTo("ACTIVE"))
                .body("result.expiredFixSum", equalTo(0))
                .body("result.expiredTotalSum", equalTo(0))
                .body("result.otherFees", equalTo(0))
                .extract().as(ResponseCreditDetails1_3.class);
    }

}

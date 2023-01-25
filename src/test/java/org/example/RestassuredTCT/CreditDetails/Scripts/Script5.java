package org.example.RestassuredTCT.CreditDetails.Scripts;

import org.example.RestassuredTCT.CreditDetails.CreditDetailsTemplate;
import org.example.RestassuredTCT.CreditDetails.Preconditions.PreconditionsFoScripts;
import org.example.RestassuredTCT.DTO.Response.ResponseCreditDetails1_3;
import org.example.RestassuredTCT.DTO.Response.ResponseCreditDetails5_8;
import org.springframework.cache.support.NullValue;

import java.io.IOException;

import static org.hamcrest.Matchers.*;

public class Script5 {

    CreditDetailsTemplate creditDetailsTemplate;
    PreconditionsFoScripts preconditionsFoScripts;
    public Script5(CreditDetailsTemplate creditDetailsTemplate) throws IOException {
        this.creditDetailsTemplate = creditDetailsTemplate;
        this.preconditionsFoScripts = new PreconditionsFoScripts();
    }

    //   Повне погашення поточного min_bill
    public void TestCase1 (int clientId, long uid) throws IOException {
        preconditionsFoScripts.DeleteAllValuesFromTheTables();   // Видалення всіх записів з таблиць по рахунку
        preconditionsFoScripts.PreconditionsFoScript5_1();       // Додавання тестових данних до БД
        creditDetailsTemplate.CreditDetails(clientId, uid)       // Порівняння очікуваного результату з фактичним
                .statusCode(200)
                .body("result.script", equalTo("5"))
                .body("result.graceSum", equalTo(0.00F))
                .body("result.minPaySum", equalTo(12.00F))
                .body("result.minBillSum", equalTo(12.00F))
                .body("result.lateFeeSum", equalTo(0))
                .body("result.interestOnDebt", equalTo(3))
                .body("result.interestRate", equalTo(25.90F))
                .body("result.interestCharge", equalTo(0.04F))
                .body("result.expiredSum", equalTo(10.00F))
                .body("result.totalSum", equalTo(50.00F))
                .body("result.graceEnd", nullValue())
                .body("result.graceStart", nullValue())
                .body("result.expiredBillsDetail.sum", hasItem(10.00F))
                .body("result.expiredBillsDetail.minBillSum", hasItem(10.00F))
                .body("result.expiredBillsDetail.lateFeeSum", hasItem(0))
                .body("result.penaltySum", equalTo(0))
                .body("result.fullRepay", equalTo(50.04F))
                .body("result.interestGrace", equalTo(0))
                .body("result.paymentState", equalTo("latePaym"))
                .body("result.cashFee", equalTo(0))
                .body("result.transferFee", equalTo(0))
                .body("result.contractState", equalTo("ACTIVE"))
                .body("result.expiredFixSum", equalTo(0))
                .body("result.expiredTotalSum", equalTo(10.00F))
                .body("result.otherFees", equalTo(0))
                .extract().as(ResponseCreditDetails5_8.class);
    }
}
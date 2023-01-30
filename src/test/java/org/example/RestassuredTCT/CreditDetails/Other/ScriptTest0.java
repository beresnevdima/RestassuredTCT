package org.example.RestassuredTCT.CreditDetails.Other;

import org.example.RestassuredTCT.CreditDetails.CreditDetailsTemplate;
import org.example.RestassuredTCT.CreditDetails.Preconditions.PreconditionsFoScripts;
import org.example.RestassuredTCT.DTO.Response.ResponseCreditDetails1_3;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;

public class ScriptTest0 {
    PreconditionsFoScripts preconditionsFoScript  = new PreconditionsFoScripts();
    CreditDetailsTemplateSingleton creditDetailsTemplateSingleton = new CreditDetailsTemplateSingleton();

    public ScriptTest0() throws IOException {
    }

    //
//     public ScriptTest0(CreditDetailsTemplateSingleton creditDetailsTemplateSingleton) throws IOException {
//         this.creditDetailsTemplateSingleton = creditDetailsTemplateSingleton;
//         this.preconditionsFoScript = new PreconditionsFoScripts();
//     }
@Test
//  Клієнт не використовує кредитний ліміт
    public void testCase1 (int clientId, long uid) throws IOException {
        preconditionsFoScript.deleteAllValuesFromTheTables();  // Видалення всіх записів з таблиць по рахунку
        creditDetailsTemplateSingleton.creditDetails(clientId,uid)     // Порівняння очікуваного результату з фактичним
                .statusCode(200)
                .body("result.script", equalTo("0"))
                .body("result.graceSum", equalTo(0))
                .body("result.minPaySum", equalTo(0))
                .body("result.minBillSum", equalTo(0))
                .body("result.lateFeeSum", equalTo(0))
                .body("result.interestOnDebt", equalTo(3))
                .body("result.interestRate", equalTo(25.90F))
                .body("result.interestCharge", equalTo(0))
                .body("result.expiredSum", equalTo(0))
                .body("result.totalSum", equalTo(0))
                .body("result.penaltySum", equalTo(0))
                .body("result.fullRepay", equalTo(0))
                .body("result.interestGrace", equalTo(0))
                .body("result.paymentState", equalTo("nothingToShow"))
                .body("result.cashFee", equalTo(0))
                .body("result.transferFee", equalTo(0))
                .body("result.contractState", equalTo("ACTIVE"))
                .body("result.expiredFixSum", equalTo(0))
                .body("result.expiredTotalSum", equalTo(0))
                .body("result.otherFees", equalTo(0))
                .extract().as(ResponseCreditDetails1_3.class);
    }
}
package org.example.RestassuredTCT.CreditDetails.Scripts;

import org.example.RestassuredTCT.CreditDetails.Preconditions.CreditDetailsTemplate;
import org.example.RestassuredTCT.CreditDetails.Preconditions.PreconditionsFoScripts;
import org.example.RestassuredTCT.DTO.Response.ResponseCreditDetails1_3;
import java.io.IOException;
import static org.hamcrest.Matchers.*;

public class Script0 {
    PreconditionsFoScripts preconditionsFoScripts = new PreconditionsFoScripts();
    CreditDetailsTemplate creditDetailsTemplate = new CreditDetailsTemplate();
    public Script0() throws IOException {}

    //  Клієнт не використовує кредитний ліміт
    public void testCase1 (int clientId, long uid) throws IOException {
        preconditionsFoScripts.deleteAllValuesFromTheTables();  // Видалення всіх записів з таблиць по рахунку
        creditDetailsTemplate.creditDetails(clientId, uid)     // Порівняння очікуваного результату з фактичним
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
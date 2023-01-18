package org.example.RestassuredTCT.CreditDetails.Scripts;

import org.example.RestassuredTCT.CreditDetails.CreditDetailsTemplate;
import org.example.RestassuredTCT.CreditDetails.Preconditions.PreconditionsFoScript0;
import org.example.RestassuredTCT.DTO.Response.ResponseCreditDetails1_3;
import java.io.IOException;
import static org.hamcrest.Matchers.*;

public class Script0 {
    PreconditionsFoScript0 preconditionsFoScript0 = new PreconditionsFoScript0();
    CreditDetailsTemplate creditDetailsTemplate = new CreditDetailsTemplate();
    public Script0() throws IOException {}
    public void TestCase1 (int clientId, long uid) throws IOException {
        preconditionsFoScript0.PreconditionsFoTestCase1();
        creditDetailsTemplate.CreditDetails(clientId, uid)
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
                .body("result.graceEnd", nullValue())
                .body("result.graceStart", nullValue())
                .body("result.expiredBillsDetail", nullValue())
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
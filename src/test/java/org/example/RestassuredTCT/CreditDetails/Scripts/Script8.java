package org.example.RestassuredTCT.CreditDetails.Scripts;

import org.example.RestassuredTCT.CreditDetails.CreditDetailsTemplate;
import org.example.RestassuredTCT.CreditDetails.Preconditions.PreconditionsFoScripts;
import org.example.RestassuredTCT.DTO.Response.ResponseCreditDetails5_8;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

public class Script8 {

    CreditDetailsTemplate creditDetailsTemplate;
    PreconditionsFoScripts preconditionsFoScripts;
    public Script8(CreditDetailsTemplate creditDetailsTemplate) throws IOException {
        this.creditDetailsTemplate = creditDetailsTemplate;
        this.preconditionsFoScripts = new PreconditionsFoScripts();
    }

    //   Є чотири просрочених min_bill (клієнт поза пільгового періоду)
    public void TestCase1 (int clientId, long uid) throws IOException {
        preconditionsFoScripts.DeleteAllValuesFromTheTables();   // Видалення всіх записів з таблиць по рахунку
        preconditionsFoScripts.PreconditionsFoScript8_1();       // Додавання тестових данних до БД
        creditDetailsTemplate.CreditDetails(clientId, uid)       // Порівняння очікуваного результату з фактичним
                .statusCode(200)
                .body("result.script", equalTo("8"))
                .body("result.graceSum", equalTo(0.00F))
                .body("result.minPaySum", equalTo(15.00F))
                .body("result.minBillSum", equalTo(15.00F))
                .body("result.lateFeeSum", equalTo(0))
                .body("result.interestOnDebt", equalTo(3))
                .body("result.interestRate", equalTo(25.90F))
                .body("result.interestCharge", equalTo(0.04F))
                .body("result.expiredSum", equalTo(47.00F))
                .body("result.totalSum", equalTo(50.00F))
                .body("result.graceEnd", nullValue())
                .body("result.graceStart", nullValue())
//                .body("result.expiredBillsDetail.sum[0]", hasItem(10.00F))
//                .body("result.expiredBillsDetail.sum[1]", hasItem(12.00F))
//                .body("result.expiredBillsDetail.minBillSum", hasItem(10.00F))
//                .body("result.expiredBillsDetail.lateFeeSum", hasItem(0))
                .body("result.penaltySum", equalTo(0))
                .body("result.fullRepay", equalTo(50.04F))
                .body("result.interestGrace", equalTo(0))
                .body("result.paymentState", equalTo("latePaym"))
                .body("result.cashFee", equalTo(0))
                .body("result.transferFee", equalTo(0))
                .body("result.contractState", equalTo("ACTIVE"))
                .body("result.expiredFixSum", equalTo(0))
                .body("result.expiredTotalSum", equalTo(47.00F))
                .body("result.otherFees", equalTo(0))
                .extract().as(ResponseCreditDetails5_8.class);
    }

    //   Є чотири просрочених min_bill. Один з яких частково погашений (клієнт поза пільгового періоду)
    public void TestCase2 (int clientId, long uid) throws IOException {
        preconditionsFoScripts.DeleteAllValuesFromTheTables();   // Видалення всіх записів з таблиць по рахунку
        preconditionsFoScripts.PreconditionsFoScript8_2();       // Додавання тестових данних до БД
        creditDetailsTemplate.CreditDetails(clientId, uid)       // Порівняння очікуваного результату з фактичним
                .statusCode(200)
                .body("result.script", equalTo("8"))
                .body("result.graceSum", equalTo(0.00F))
                .body("result.minPaySum", equalTo(15.00F))
                .body("result.minBillSum", equalTo(15.00F))
                .body("result.lateFeeSum", equalTo(0))
                .body("result.interestOnDebt", equalTo(3))
                .body("result.interestRate", equalTo(25.90F))
                .body("result.interestCharge", equalTo(0.04F))
                .body("result.expiredSum", equalTo(40.00F))
                .body("result.totalSum", equalTo(43.00F))
                .body("result.graceEnd", nullValue())
                .body("result.graceStart", nullValue())
//                .body("result.expiredBillsDetail.sum", hasItem(3.00F))
//                .body("result.expiredBillsDetail.minBillSum", hasItem(3.00F))
//                .body("result.expiredBillsDetail.lateFeeSum", hasItem(0))
                .body("result.penaltySum", equalTo(0))
                .body("result.fullRepay", equalTo(43.04F))
                .body("result.interestGrace", equalTo(0))
                .body("result.paymentState", equalTo("latePaym"))
                .body("result.cashFee", equalTo(0))
                .body("result.transferFee", equalTo(0))
                .body("result.contractState", equalTo("ACTIVE"))
                .body("result.expiredFixSum", equalTo(0))
                .body("result.expiredTotalSum", equalTo(40.00F))
                .body("result.otherFees", equalTo(0))
                .extract().as(ResponseCreditDetails5_8.class);
    }
}
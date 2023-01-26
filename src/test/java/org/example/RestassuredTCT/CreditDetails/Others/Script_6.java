package org.example.RestassuredTCT.CreditDetails.Others;

import org.example.RestassuredTCT.CreditDetails.CreditDetailsTemplate;
import org.example.RestassuredTCT.CreditDetails.Preconditions.PreconditionsFoScripts;
import org.example.RestassuredTCT.DTO.Response.ResponseCreditDetails5_8;
import org.example.RestassuredTCT.SidTCT;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

import static org.hamcrest.Matchers.*;

public class Script_6 {

    CreditDetailsTemplate_1 creditDetailsTemplate_1;
    PreconditionsFoScripts preconditionsFoScripts;
    public Script_6(CreditDetailsTemplate creditDetailsTemplate) throws IOException {
        this.creditDetailsTemplate_1 = new CreditDetailsTemplate_1(new SidTCT());
        this.preconditionsFoScripts = new PreconditionsFoScripts();
    }

    //   Є два просрочених min_bill (клієнт поза пільгового періоду)
    public void TestCase1 (int clientId, long uid) throws IOException {
        preconditionsFoScripts.DeleteAllValuesFromTheTables();   // Видалення всіх записів з таблиць по рахунку
        preconditionsFoScripts.PreconditionsFoScript6_1();       // Додавання тестових данних до БД
        creditDetailsTemplate_1.CreditDetails(clientId, uid)       // Порівняння очікуваного результату з фактичним
                .statusCode(200)
                .body("result.script", equalTo("6"))
                .body("result.graceSum", equalTo(0.00F))
                .body("result.expiredBillsDetail[0].sum", equalTo(10.00F))
                .body("result.expiredBillsDetail[1].sum", equalTo(12.00F))
//                .body("result.expiredBillsDetail.sum[1]", hasItem(12.00F))
//                .body("result.expiredBillsDetail.minBillSum", hasItem(10.00F))
//                .body("result.expiredBillsDetail.lateFeeSum", hasItem(0))

                .extract().as(ResponseCreditDetails5_8.class);
    }

    //   Є два просрочених min_bill. Один з яких частково погашений (клієнт поза пільгового періоду)
    public void TestCase2 (int clientId, long uid) throws IOException {
        preconditionsFoScripts.DeleteAllValuesFromTheTables();   // Видалення всіх записів з таблиць по рахунку
        preconditionsFoScripts.PreconditionsFoScript6_2();       // Додавання тестових данних до БД
        creditDetailsTemplate_1.CreditDetails(clientId, uid)       // Порівняння очікуваного результату з фактичним
                .statusCode(200)
                .body("result.script", equalTo("6"))
                .body("result.graceSum", equalTo(0.00F))
                .body("result.minPaySum", equalTo(15.00F))
                .body("result.minBillSum", equalTo(15.00F))
                .body("result.lateFeeSum", equalTo(0))
                .body("result.interestOnDebt", equalTo(3))
                .body("result.interestRate", equalTo(25.90F))
                .body("result.interestCharge", equalTo(0.04F))
                .body("result.expiredSum", equalTo(15.00F))
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
                .body("result.expiredTotalSum", equalTo(15.00F))
                .body("result.otherFees", equalTo(0))
                .extract().as(ResponseCreditDetails5_8.class);
    }
}
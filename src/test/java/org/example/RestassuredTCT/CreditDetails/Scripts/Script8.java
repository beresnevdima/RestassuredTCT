package org.example.RestassuredTCT.CreditDetails.Scripts;

import org.example.RestassuredTCT.CreditDetails.CreditDetailsTemplate;
import org.example.RestassuredTCT.CreditDetails.Preconditions.PreconditionsFoScripts;
import org.example.RestassuredTCT.DTO.Response.ResponseCreditDetails5_8;
import java.io.IOException;
import static org.hamcrest.Matchers.*;

public class Script8 {
    PreconditionsFoScripts preconditionsFoScripts = new PreconditionsFoScripts();
    CreditDetailsTemplate creditDetailsTemplate = new CreditDetailsTemplate();

    public Script8() throws IOException {}

    //   Є чотири просрочених min_bill (клієнт поза пільгового періоду)
    public void testCase1 (int clientId, long uid) throws IOException {
        preconditionsFoScripts.deleteAllValuesFromTheTables();   // Видалення всіх записів з таблиць по рахунку
        preconditionsFoScripts.preconditionsFoScript8_1();       // Додавання тестових данних до БД
        creditDetailsTemplate.creditDetails(clientId, uid)       // Порівняння очікуваного результату з фактичним
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
                .body("result.expiredBillsDetail[0].sum", equalTo(10.00F))
                .body("result.expiredBillsDetail[0].minBillSum", equalTo(10.00F))
                .body("result.expiredBillsDetail[0].lateFeeSum", equalTo(0))
                .body("result.expiredBillsDetail[1].sum", equalTo(11.00F))
                .body("result.expiredBillsDetail[1].minBillSum", equalTo(11.00F))
                .body("result.expiredBillsDetail[1].lateFeeSum", equalTo(0))
                .body("result.expiredBillsDetail[2].sum", equalTo(12.00F))
                .body("result.expiredBillsDetail[2].minBillSum", equalTo(12.00F))
                .body("result.expiredBillsDetail[2].lateFeeSum", equalTo(0))
                .body("result.expiredBillsDetail[3].sum", equalTo(14.00F))
                .body("result.expiredBillsDetail[3].minBillSum", equalTo(14.00F))
                .body("result.expiredBillsDetail[3].lateFeeSum", equalTo(0))
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
    public void testCase2 (int clientId, long uid) throws IOException {
        preconditionsFoScripts.deleteAllValuesFromTheTables();   // Видалення всіх записів з таблиць по рахунку
        preconditionsFoScripts.preconditionsFoScript8_2();       // Додавання тестових данних до БД
        creditDetailsTemplate.creditDetails(clientId, uid)       // Порівняння очікуваного результату з фактичним
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
                .body("result.expiredBillsDetail[0].sum", equalTo(3.00F))
                .body("result.expiredBillsDetail[0].minBillSum", equalTo(3.00F))
                .body("result.expiredBillsDetail[0].lateFeeSum", equalTo(0))
                .body("result.expiredBillsDetail[1].sum", equalTo(11.00F))
                .body("result.expiredBillsDetail[1].minBillSum", equalTo(11.00F))
                .body("result.expiredBillsDetail[1].lateFeeSum", equalTo(0))
                .body("result.expiredBillsDetail[2].sum", equalTo(12.00F))
                .body("result.expiredBillsDetail[2].minBillSum", equalTo(12.00F))
                .body("result.expiredBillsDetail[2].lateFeeSum", equalTo(0))
                .body("result.expiredBillsDetail[3].sum", equalTo(14.00F))
                .body("result.expiredBillsDetail[3].minBillSum", equalTo(14.00F))
                .body("result.expiredBillsDetail[3].lateFeeSum", equalTo(0))
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
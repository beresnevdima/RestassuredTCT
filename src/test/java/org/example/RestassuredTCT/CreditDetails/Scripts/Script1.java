package org.example.RestassuredTCT.CreditDetails.Scripts;

import org.example.RestassuredTCT.CreditDetails.CreditDetailsTemplate;
import org.example.RestassuredTCT.CreditDetails.Preconditions.PreconditionsFoScripts;
import org.example.RestassuredTCT.DTO.Response.ResponseCreditDetails1_3;
import java.io.IOException;
import static org.hamcrest.Matchers.*;

public class Script1 {
    CreditDetailsTemplate creditDetailsTemplate = new CreditDetailsTemplate();
    PreconditionsFoScripts preconditionsFoScripts = new PreconditionsFoScripts();
    public Script1() throws IOException {}

    // Клієнт зробив одну трату в рахунок кредитних коштів,
    // та знаходиться у 1му місяці пільгового періоду
    public void TestCase1 (int clientId, long uid) throws IOException {
        preconditionsFoScripts.DeleteAllValuesFromTheTables();   // Видалення всіх записів з таблиць по рахунку
        preconditionsFoScripts.PreconditionsFoScript1_1();       // Додавання тестових данних до БД
        creditDetailsTemplate.CreditDetails(clientId, uid)       // Порівняння очікуваного результату з фактичним
                .statusCode(200)
                .body("result.script", equalTo("1"))
                .body("result.graceSum", equalTo(0))
                .body("result.minPaySum", equalTo(0))
                .body("result.minBillSum", equalTo(0))
                .body("result.lateFeeSum", equalTo(0))
                .body("result.interestOnDebt", equalTo(3))
                .body("result.interestRate", equalTo(25.90F))
                .body("result.interestCharge", equalTo(0))
                .body("result.expiredSum", equalTo(0))
                .body("result.totalSum", equalTo(50.00F))
                .body("result.graceEnd", equalTo("2023-02-28T00:00:00.000Z"))
                .body("result.graceStart", equalTo("2023-01-01T00:00:00.000Z"))
                .body("result.penaltySum", equalTo(0))
                .body("result.fullRepay", equalTo(50.00F))
                .body("result.interestGrace", equalTo(0))
                .body("result.paymentState", equalTo("noMinPaym"))
                .body("result.cashFee", equalTo(1.00F))
                .body("result.transferFee", equalTo(0))
                .body("result.contractState", equalTo("ACTIVE"))
                .body("result.expiredFixSum", equalTo(0))
                .body("result.expiredTotalSum", equalTo(0))
                .body("result.otherFees", equalTo(0))
                .extract().as(ResponseCreditDetails1_3.class);
    }

    // Клієнт зробив одну трату в рахунок кредитних коштів
    // і одне поповнення на сумму меньшу ніж загальний відʼємний баланс,
    // та знаходиться у 1му місяці пільгового періоду
    public void TestCase2 (int clientId, long uid) throws IOException {
        preconditionsFoScripts.DeleteAllValuesFromTheTables();   // Видалення всіх записів з таблиць по рахунку
        preconditionsFoScripts.PreconditionsFoScript1_2();       // Додавання тестових данних до БД
        creditDetailsTemplate.CreditDetails(clientId, uid)       // Порівняння очікуваного результату з фактичним
                .statusCode(200)
                .body("result.script", equalTo("1"))
                .body("result.graceSum", equalTo(0))
                .body("result.minPaySum", equalTo(0))
                .body("result.minBillSum", equalTo(0))
                .body("result.lateFeeSum", equalTo(0))
                .body("result.interestOnDebt", equalTo(3))
                .body("result.interestRate", equalTo(25.90F))
                .body("result.interestCharge", equalTo(0))
                .body("result.expiredSum", equalTo(0))
                .body("result.totalSum", equalTo(30.00F))
                .body("result.graceEnd", equalTo("2023-02-28T00:00:00.000Z"))
                .body("result.graceStart", equalTo("2023-01-01T00:00:00.000Z"))
                .body("result.penaltySum", equalTo(0))
                .body("result.fullRepay", equalTo(30.00F))
                .body("result.interestGrace", equalTo(0.04F))
                .body("result.paymentState", equalTo("noMinPaym"))
                .body("result.cashFee", equalTo(0))
                .body("result.transferFee", equalTo(0))
                .body("result.contractState", equalTo("ACTIVE"))
                .body("result.expiredFixSum", equalTo(0))
                .body("result.expiredTotalSum", equalTo(0))
                .body("result.otherFees", equalTo(0))
                .extract().as(ResponseCreditDetails1_3.class);
    }
}
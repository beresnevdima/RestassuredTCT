package org.example.RestassuredTCT.CreditDetails.Script1;

/// Отримання та перевірка "script": "1"
/// - Трата, відкриття пільгового періоду
/// - Поповнення на сумму меньшу, ніж трата

import org.example.RestassuredTCT.CreditDetails.CreditDetailsTemplate;
import org.example.RestassuredTCT.DB.Example.SqlConnection;
import org.junit.Test;
import java.io.IOException;
import java.sql.SQLException;


public class Case2 {

    SqlConnection sqlConnection = new SqlConnection();
    CreditDetailsTemplate creditDetailsTemplate = new CreditDetailsTemplate();

    long uid = 2020005024L;
    int clientId = 500341;

    public Case2() throws IOException, SQLException {}

    @Test
    public void Case2test () throws IOException {
        sqlConnection.getConnection();
        creditDetailsTemplate.CreditDetails(clientId, uid);

    }
}

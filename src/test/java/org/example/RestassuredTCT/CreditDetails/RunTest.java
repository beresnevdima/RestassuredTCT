package org.example.RestassuredTCT.CreditDetails;

import org.example.RestassuredTCT.CreditDetails.Script1.Case2;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class RunTest {

    long uid = 2020005024L;
    int clientId = 500341;

    Case2 case2 = new Case2();

    public RunTest() throws IOException {
    }
@Test
    public void runTests () throws SQLException, IOException {

        case2.Case2test(clientId, uid);

    }

}

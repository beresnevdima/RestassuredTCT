package org.example.RestassuredTCT.CreditDetails;

import org.example.RestassuredTCT.CreditDetails.Scripts.Script0;
import org.junit.Test;
import java.io.IOException;
import java.sql.SQLException;

public class RunTest {
    int clientId = 500341;
    long uid = 2020005024L;
    Script0 script0 = new Script0();

    public RunTest() throws IOException {
    }
@Test
    public void runTests () throws SQLException, IOException {

        script0.TestCase1(clientId, uid);

    }
}

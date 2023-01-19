package org.example.RestassuredTCT.CreditDetails;

import org.example.RestassuredTCT.CreditDetails.Scripts.Script0;
import org.example.RestassuredTCT.CreditDetails.Scripts.Script1;
import org.junit.Test;
import java.io.IOException;
import java.sql.SQLException;

public class RunTest {
    int clientId = 500341;
    long uid = 2020005024L;

    Script0 script0 = new Script0();
    Script1 script1 = new Script1();

    public RunTest() throws IOException {
    }
@Test
    public void runTests () throws IOException {

        script0.TestCase1(clientId, uid);
        script1.TestCase1(clientId,uid);
        script1.TestCase2(clientId,uid);

    }
}

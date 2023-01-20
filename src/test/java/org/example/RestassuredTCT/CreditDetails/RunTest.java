package org.example.RestassuredTCT.CreditDetails;

import org.example.RestassuredTCT.CreditDetails.Scripts.Script0;
import org.example.RestassuredTCT.CreditDetails.Scripts.Script1;
import org.example.RestassuredTCT.SidTCT;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;

public class RunTest {
    int clientId = 500341;
    long uid = 2020005024L;
    static SidTCT sidTCT;
    Script0 script0;
    Script1 script1;

    @BeforeAll
    static void generateSid() throws IOException {
        sidTCT = new SidTCT();
    }
    @BeforeEach
    void init () throws IOException {

        CreditDetailsTemplate creditDetailsTemplate = new CreditDetailsTemplate(sidTCT);
     script0 = new Script0(creditDetailsTemplate);
     script1 = new Script1(creditDetailsTemplate);
    }
@Test
    public void runTests () throws IOException {
        script0.TestCase1(clientId, uid);
        script1.TestCase1(clientId,uid);
        script1.TestCase2(clientId,uid);

    }
}

package org.example.RestassuredTCT.CreditDetails;

import org.example.RestassuredTCT.CreditDetails.Scripts.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class RunTest {
    int clientId = 500341;
    long uid = 2020005024L;
    Script0 script0 = new Script0();
    Script1 script1 = new Script1();
    Script2 script2 = new Script2();
    Script3 script3 = new Script3();
    Script5 script5 = new Script5();
    Script6 script6 = new Script6();
    Script7 script7 = new Script7();
    Script8 script8 = new Script8();
    public RunTest() throws IOException {}

    // Перед запуском теста ОБОВʼЯЗКОВО перевести годинник на дату 02.01.2023
@Test
    public void runTests () throws IOException {
        script0.testCase1(clientId, uid);
        script1.testCase1(clientId,uid);
        script1.testCase2(clientId,uid);
        script2.testCase1(clientId, uid);
        script2.testCase2(clientId, uid);
        script3.testCase1(clientId, uid);
        script5.testCase1(clientId, uid);
        script5.testCase2(clientId, uid);
        script6.testCase1(clientId, uid);
        script6.testCase2(clientId, uid);
        script7.testCase1(clientId, uid);
        script7.testCase2(clientId, uid);
        script8.testCase1(clientId, uid);
        script8.testCase2(clientId, uid);
    }
}
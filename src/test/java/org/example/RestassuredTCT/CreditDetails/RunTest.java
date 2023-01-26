package org.example.RestassuredTCT.CreditDetails;

import org.example.RestassuredTCT.CreditDetails.Others.Script_6;
import org.example.RestassuredTCT.CreditDetails.Scripts.*;
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
    Script2 script2;
    Script3 script3;
    Script5 script5;
    Script6 script6;
    Script7 script7;
    Script8 script8;
//    Script_6 script_6;

    @BeforeAll
    static void generateSid() throws IOException {
        sidTCT = new SidTCT();
    }
    @BeforeEach
    void init () throws IOException {
        CreditDetailsTemplate creditDetailsTemplate = new CreditDetailsTemplate(sidTCT);
     script0 = new Script0(creditDetailsTemplate);
     script1 = new Script1(creditDetailsTemplate);
     script2 = new Script2(creditDetailsTemplate);
     script3 = new Script3(creditDetailsTemplate);
     script5 = new Script5(creditDetailsTemplate);
     script6 = new Script6(creditDetailsTemplate);
     script7 = new Script7(creditDetailsTemplate);
     script8 = new Script8(creditDetailsTemplate);
//     script_6 = new Script_6(creditDetailsTemplate);
    }

    // Перед запуском теста ОБОВʼЯЗКОВО перевести годинник на дату 02.01.2023
@Test
    public void runTests () throws IOException {
        script0.testCase1(clientId, uid);
        script1.TestCase1(clientId,uid);
        script1.TestCase2(clientId,uid);
        script2.TestCase1(clientId, uid);
        script2.TestCase2(clientId, uid);
        script3.TestCase1(clientId, uid);
        script5.TestCase1(clientId, uid);
        script5.TestCase2(clientId, uid);
        script6.TestCase1(clientId, uid);
        script6.TestCase2(clientId, uid);
        script7.TestCase1(clientId, uid);
        script7.TestCase2(clientId, uid);
        script8.TestCase1(clientId, uid);
        script8.TestCase2(clientId, uid);
//        script_6.TestCase1(clientId, uid);

    }
}

package org.example.RestassuredTCT.CreditDetails.Other;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RunSidGeneration {
    int clientId = 500341;
    long uid = 2020005024L;
    ScriptTest0 scriptTest0 = new ScriptTest0();

    public RunSidGeneration() throws IOException {}

    @Test
    public void runTests () throws IOException {
        scriptTest0.testCase1(clientId, uid);
        scriptTest0.testCase1(clientId, uid);
        scriptTest0.testCase1(clientId, uid);
        scriptTest0.testCase1(clientId, uid);
        scriptTest0.testCase1(clientId, uid);
    }
}

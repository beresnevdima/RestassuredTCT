package org.example.RestassuredTCT.Example;

import org.example.RestassuredTCT.DTO.Response.ResponseCreditDetails;
import org.example.RestassuredTCT.SidTCT;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreditDetails {


    SidTCT sidTCT = new SidTCT();
    String sid = sidTCT.getSid();
    long uid = 2020005024L;
    int ClientId = 500341;
    public CreditDetails() throws IOException {
    }
    @Test
    public void CreditDetails() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String baseUrl = System.getProperty("dragon-api.url");
        ResponseCreditDetails responseCreditDetails = given()
                .when()
                .header("Content-Type", "application/json")
                .header("sid", sid)
                .header("Client-Id", ClientId)
                .get(baseUrl + "/api/v1/info/thing/details/"+uid)
                .then().log().all()
                .statusCode(200)
                .body("result.script", equalTo("0"))
                .body("result.graceSum", equalTo(0))
                .body("result.paymentDue", equalTo("2023-02-28"))
                .extract().as(ResponseCreditDetails.class);
    }
}
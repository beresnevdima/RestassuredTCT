package org.example.RestassuredTCT.CreditDetails;

import org.example.RestassuredTCT.DTO.Response.ResponseCreditDetails;
import org.example.RestassuredTCT.SidTCT;
import java.io.IOException;
import static io.restassured.RestAssured.given;
public class CreditDetailsTemplate {

    SidTCT sidTCT = new SidTCT();
    String sid = sidTCT.getSidTCT();
    public long uid;
    public int clientId;

    public CreditDetailsTemplate() throws IOException {}

    public void CreditDetails(int clientId, long uid) throws IOException {
        this.uid = uid;
        this.clientId = clientId;

        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String baseUrl = System.getProperty("dragon-api.url");
        ResponseCreditDetails responseCreditDetails = given()
                .when()
                .header("Content-Type", "application/json")
                .header("sid", sid)
                .header("Client-Id", clientId)
                .get(baseUrl + "/api/v1/info/thing/details/"+uid)
                .then().log().all()
                .extract().as(ResponseCreditDetails.class);
    }
}

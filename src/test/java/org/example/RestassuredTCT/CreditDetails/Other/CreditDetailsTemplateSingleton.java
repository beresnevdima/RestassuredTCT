package org.example.RestassuredTCT.CreditDetails.Other;

import io.restassured.response.ValidatableResponse;
import java.io.IOException;
import static io.restassured.RestAssured.given;

public class CreditDetailsTemplateSingleton {

    public long uid;
    public int clientId;

    public ValidatableResponse creditDetails(int clientId, long uid) throws IOException {
        this.uid = uid;
        this.clientId = clientId;

        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String baseUrl = System.getProperty("dragon-api.url");
        return given()
                .when()
                .header("Content-Type", "application/json")
                .header("sid", SidGeneration.getSidGeneration().getSidGenerations())
                .header("Client-Id", clientId)
                .get(baseUrl + "/api/v1/info/thing/details/"+uid)
                .then().log().all();
    }
}
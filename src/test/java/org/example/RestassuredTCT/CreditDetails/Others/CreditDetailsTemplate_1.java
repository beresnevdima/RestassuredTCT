package org.example.RestassuredTCT.CreditDetails.Others;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.example.RestassuredTCT.SidTCT;

import java.io.IOException;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_INTEGER;

public class CreditDetailsTemplate_1 {
    SidTCT sidTCT;
    public long uid;
    public int clientId;

    public CreditDetailsTemplate_1(SidTCT sidTCT) {
        this.sidTCT = sidTCT;
    }

    public ValidatableResponse CreditDetails(int clientId, long uid) throws IOException {
        this.uid = uid;
        this.clientId = clientId;

        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String baseUrl = System.getProperty("dragon-api.url");
        return given()
//                config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL)))
                .when()
                .header("Content-Type", "application/json")
                .header("sid", sidTCT.getSid())
                .header("Client-Id", clientId)
                .get(baseUrl + "/api/v1/info/thing/details/"+uid)
                .then().log().all();
    }
}
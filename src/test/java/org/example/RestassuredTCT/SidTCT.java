package org.example.RestassuredTCT;

import org.example.RestassuredTCT.DTO.GetSidTCT;
import org.example.RestassuredTCT.DTO.RequestGetSidTCT;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class SidTCT {

    protected String getSidTCT() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String baseUrl = System.getProperty("iam.session.url");
        String scheme = System.getProperty("iam.session.auth");
        String login = System.getProperty("iam.session.login");
        String password = System.getProperty("iam.session.password");
        RequestGetSidTCT request = new RequestGetSidTCT(new RequestGetSidTCT.RequestInfo(scheme, login, password));
        GetSidTCT getSidTCT = given()
                .body(request)
                .when()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .post(baseUrl + "/sessions/open")
                .then().log().all()
                .body("value", notNullValue())
                .statusCode(200)
                .extract().as(GetSidTCT.class);
        String sid = getSidTCT.getValue();
        return (sid);
    }
}
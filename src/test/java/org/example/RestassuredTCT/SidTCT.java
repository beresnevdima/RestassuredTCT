package org.example.RestassuredTCT;

import org.example.RestassuredTCT.DTO.Response.ResponseSidTCT;
import org.example.RestassuredTCT.DTO.Request.RequestGetSidTCT;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class SidTCT {

//private String sid;

    public String getSidTCT() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String baseUrl = System.getProperty("iam.session.url");
        String scheme = System.getProperty("iam.session.auth");
        String login = System.getProperty("iam.session.login");
        String password = System.getProperty("iam.session.password");
        RequestGetSidTCT request = new RequestGetSidTCT(new RequestGetSidTCT.RequestInfo(scheme, login, password));
        ResponseSidTCT getSidTCT = given()
                .body(request)
                .when()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .post(baseUrl + "/sessions/open")
                .then().log().all()
                .body("value", notNullValue())
                .statusCode(200)
                .extract().as(ResponseSidTCT.class);
        String sid = getSidTCT.getValue();
        return (sid);
    }

//    public String getSid() throws Exception{
//    if( sid == null ){
//        this.sid = getSidTCT();
//    }
//
//
//        return sid;
//    }
}
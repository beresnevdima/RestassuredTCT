package org.example.RestassuredTCT;

import org.example.RestassuredTCT.DTO.Response.ResponseSid;
import org.example.RestassuredTCT.DTO.Request.RequestGetSid;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class SidTCT {
    private final String BASE_URL;
    private final String SCHEME;
    private final String LOGIN;
    private final String PASSWORD;

    public SidTCT() throws IOException{
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        this.BASE_URL = System.getProperty("iam.session.url");
        this.SCHEME = System.getProperty("iam.session.auth");
        this.LOGIN = System.getProperty("iam.session.login");
        this.PASSWORD = System.getProperty("iam.session.password");
    }

//    public String getSid(){
//        RequestGetSid request = new RequestGetSid(new RequestGetSid.RequestInfo(SCHEME, LOGIN, PASSWORD));
//        ResponseSid getSidTCT = given()
//                .body(request)
//                .when()
//                .header("Content-Type", "application/json")
//                .header("Accept", "application/json")
//                .post(BASE_URL + "/sessions/open")
//                .then().log().all()
//                .body("value", notNullValue())
//                .statusCode(200)
//                .extract().as(ResponseSid.class);
//        String sid = getSidTCT.getValue();
//        return (sid);
//    }

    public String getSid(){
        return ("230118om4XXjx9lgd2k5");
    }

}
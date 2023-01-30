package org.example.RestassuredTCT.CreditDetails.Other;

import org.example.RestassuredTCT.DTO.Request.RequestGetSid;
import org.example.RestassuredTCT.DTO.Response.ResponseSid;
import java.io.IOException;
import java.time.LocalDateTime;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class SidGeneration {
    private final String BASE_URL;
    private final String SCHEME;
    private final String LOGIN;
    private final String PASSWORD;
    private LocalDateTime timeTiLive = LocalDateTime.now();
    private String sid;
    private static SidGeneration sidGeneration;


    SidGeneration() throws IOException{
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        this.BASE_URL = System.getProperty("iam.session.url");
        this.SCHEME = System.getProperty("iam.session.auth");
        this.LOGIN = System.getProperty("iam.session.login");
        this.PASSWORD = System.getProperty("iam.session.password");
    }

    private String getSidGenerations1(){
        RequestGetSid request = new RequestGetSid(new RequestGetSid.RequestInfo(SCHEME, LOGIN, PASSWORD));
        ResponseSid getSidTCT = given()
                .body(request)
                .when()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .post(BASE_URL + "/sessions/open")
                .then().log().all()
                .body("value", notNullValue())
                .statusCode(200)
                .extract().as(ResponseSid.class);
        String sid = getSidTCT.getValue();
        return (sid);
    }

    public String getSidGenerations(){
        if( sid == null || LocalDateTime.now().isAfter(timeTiLive) ){
            this.sid = getSidGenerations1();
            this.timeTiLive = LocalDateTime.now().plusMinutes( 60 );
            return sid;
        }
        return sid;
    }

    public static SidGeneration getSidGeneration() throws IOException {
        if (sidGeneration == null){
            sidGeneration = new SidGeneration();
        }
        return sidGeneration;
    }

}

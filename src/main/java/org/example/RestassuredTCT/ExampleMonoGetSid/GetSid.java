package org.example.RestassuredTCT.ExampleMonoGetSid;

import net.minidev.json.JSONObject;
import org.example.RestassuredTCT.DTO.Request.RequestGetSid;
import org.example.RestassuredTCT.DTO.Response.ResponseSid;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

public class GetSid {

    private final String BASE_URL;
    private final String SCHEME;
    private final String LOGIN;
    private final String PASSWORD;

    public GetSid() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        this.BASE_URL = System.getProperty("iam.session.url");
        this.SCHEME = System.getProperty("iam.session.auth");
        this.LOGIN = System.getProperty("iam.session.login");
        this.PASSWORD = System.getProperty("iam.session.password");
    }
@Test
    public void getSid() {

        String sid = ResponseCache.getInstance().get("sid");

        if (sid == null) {
            Properties properties = new Properties(System.getProperties());
            String login = properties.getProperty(LOGIN);
            String password = properties.getProperty(PASSWORD);

            JSONObject requestSid = new JSONObject();
            JSONObject requestSid_1 = new JSONObject();
            requestSid_1.put("auth", "excl");
            requestSid_1.put("login", login);
            requestSid_1.put("password", password);
            requestSid.put("user", requestSid_1);

            RequestGetSid request = new RequestGetSid(new RequestGetSid.RequestInfo(SCHEME, LOGIN, PASSWORD));
            ResponseSid getSid = given()
                    .body(request)
                    .when()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .post(BASE_URL + "/sessions/open")
                    .then().log().all()
                    .body("value", notNullValue())
                    .statusCode(200)
                    .extract().as(ResponseSid.class);

            ResponseCache.getInstance().addResponse("sid", sid);
            }
//        return sid;
    }
}

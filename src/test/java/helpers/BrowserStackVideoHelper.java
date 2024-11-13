package helpers;

import config.TestEnvConfig;
import drivers.BrowserStackDriver;

import static io.restassured.RestAssured.given;

public class BrowserStackVideoHelper {

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        TestEnvConfig config = BrowserStackDriver.getTestEnvConfig();

        return given()
                .auth().basic(config.getUsername(), config.getPassword())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
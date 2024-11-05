package helpers;

import config.AuthConfig;
import utils.ConfigLoader;

import static io.restassured.RestAssured.given;

public class BrowserStackVideoHelper {

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        AuthConfig authConfig = ConfigLoader.getAuthConfig();

        return given()
                .auth().basic(authConfig.username(), authConfig.password())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
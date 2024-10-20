package helpers;

import config.AuthConfig;
import utils.ConfigLoader;

import static io.restassured.RestAssured.given;

public class BrowserStack {

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        AuthConfig config = ConfigLoader.getAuthConfig();

        return given()
                .auth().basic(config.username(), config.password())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
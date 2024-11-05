package tests.android;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.android.WikipediaArticleScreen;
import screens.android.WikipediaSearchResultsScreen;
import screens.android.WikipediaSearchScreen;
import tests.TestBase;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("android")
public class WikipediaSearchTests extends TestBase {

    private final WikipediaSearchScreen searchScreen = new WikipediaSearchScreen();
    private final WikipediaSearchResultsScreen searchResultsScreen = new WikipediaSearchResultsScreen();
    private final WikipediaArticleScreen articleScreen = new WikipediaArticleScreen();
    public String result;
    public static String deviceHost = System.getProperty("deviceHost");

    @Test
    void successfulSearchTest() {

        if (deviceHost.equals("emulator")) {
            step("Skip onboarding", () -> {
            back();
            });
        }
        String query = "Appium";

        step("Perform search", () -> {
            searchScreen.searchFor(query);
            sleep(500);
        });
        step("Verify result", () -> {
            assertThat(searchResultsScreen.getResultsCount()).isGreaterThan(0);
        });
    }

    @Test
    void successfulSearchAndOpenFirstResultTest() {

        String query = "Madagascar";
        int articleNumber = 0;


        if (deviceHost.equals("emulator")) {
            step("Skip onboarding", () -> {
            back();
            });
        }

        step("Perform search", () -> {
            searchScreen.searchFor(query);
            sleep(500);
        });
        step("Open page", () -> {
            result = searchResultsScreen.ppenFoundArticle(articleNumber);
            sleep(3000);
        });

        step("Verify result", () -> {
            assertThat(articleScreen.getTitle()).isEqualTo(query);
        });
    }
}
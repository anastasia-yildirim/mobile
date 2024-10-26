package tests.android;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.android.WikipediaSearchResultsScreen;
import pages.android.WikipediaSearchScreen;
import tests.TestBase;

import java.net.MalformedURLException;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("android")
public class WikipediaSearchTests extends TestBase {

    WikipediaSearchScreen searchScreen = new WikipediaSearchScreen();
    WikipediaSearchResultsScreen searchResultsScreen = new WikipediaSearchResultsScreen();
    String result;

    @Test
    void successfulSearchTest() throws MalformedURLException, InterruptedException {
        String query = "Appium";

        step("Perform search", () ->
                searchScreen.searchFor(query));
        step("Verify result", () -> {
            assertThat(searchResultsScreen.getResultsCount()).isGreaterThan(0);
        });
    }

    @Test
    void unsuccessfulSearchAndOpenFirstResultTest() throws MalformedURLException, InterruptedException {
        String query = "Italy";
        int articleNumber = 0;

        step("Perform search", () ->
                searchScreen.searchFor(query));
        step("Open page", () -> {
            result = searchResultsScreen.tryToOpenFoundArticle(articleNumber);
        });

        step("Verify result", () -> {
            assertThat(result).isEqualTo("An error occurred");
        });
    }
}
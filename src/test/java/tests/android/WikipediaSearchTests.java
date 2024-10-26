package tests.android;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.android.WikipediaArticleScreen;
import pages.android.WikipediaSearchResultsScreen;
import pages.android.WikipediaSearchScreen;
import tests.TestBase;

import java.net.MalformedURLException;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("android")
public class WikipediaSearchTests extends TestBase {

    WikipediaSearchScreen searchScreen = new WikipediaSearchScreen();
    WikipediaSearchResultsScreen searchResultsScreen = new WikipediaSearchResultsScreen();
    WikipediaArticleScreen articleScreen = new WikipediaArticleScreen();

    @Test
    void successfulSearchTest() throws MalformedURLException, InterruptedException {
        String query = "Appium";

        step("Perform search", () ->
                searchScreen.searchFor(query));
        step("Verify result", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
            assertThat(searchResultsScreen.getResultsCount()).isGreaterThan(0);
        });
    }

    @Test
    void searchAndOpenFirstResultTest() throws MalformedURLException, InterruptedException {
        String query = "Italy";
        int articleNumber = 0;

        step("Perform search", () ->
                searchScreen.searchFor(query));
        step("Open page", () ->
                searchResultsScreen.openFoundArticle(articleNumber));
        step("Verify result", () -> {
            assertThat(articleScreen.getSubtitle()).isEqualTo("Country in Southern Europe");
            assertThat(articleScreen.getTitle()).isEqualTo(query);
        });
    }
}
package tests.browserstack;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.android.WikipediaSearchResultsScreen;
import screens.android.WikipediaSearchScreen;
import tests.TestBase;
import java.util.concurrent.atomic.AtomicReference;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("browserstack")
public class BrowserStackSearchTests extends TestBase {

    private final WikipediaSearchScreen searchScreen = new WikipediaSearchScreen();
    private final WikipediaSearchResultsScreen searchResultsScreen = new WikipediaSearchResultsScreen();

    @Test
    void successfulSearchTest() {
        String query = "Appium";

        step("Perform search", () -> searchScreen.searchFor(query));
        step("Verify result", () -> {
            assertThat(searchResultsScreen.getResultsCount()).isGreaterThan(0);
        });
    }

    @Test
    void unsuccessfulSearchAndOpenFirstResultTest() {
        String query = "Italy";
        AtomicReference<String> result = new AtomicReference<>();
        int articleNumber = 0;

        step("Perform search", () -> searchScreen.searchFor(query));
        step("Open page", () -> result.set(searchResultsScreen.tryToOpenFoundArticle(articleNumber)));
        step("Verify result", () -> {
            assertThat(result.get()).isEqualTo("An error occurred");
        });
    }
}
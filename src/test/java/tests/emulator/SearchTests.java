package tests.emulator;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.android.WikipediaSearchResultsScreen;
import screens.android.WikipediaSearchScreen;
import tests.TestBase;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("emulator")
public class SearchTests extends TestBase {

    private final WikipediaSearchScreen searchScreen = new WikipediaSearchScreen();
    private final WikipediaSearchResultsScreen searchResultsScreen = new WikipediaSearchResultsScreen();

    @Test
    void successfulSearchTest() {

        String query = "Appium";

        step("Skip onboarding", Selenide::back);
        step("Perform search", () -> searchScreen.searchFor(query));
        step("Verify result", () -> {
            assertThat(searchResultsScreen.getResultsCount()).isGreaterThan(0);
        });
    }
}
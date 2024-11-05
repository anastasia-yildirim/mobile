package tests.ios;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.ios.SampleAppSearchResultsScreen;
import screens.ios.SampleAppSearchScreen;
import tests.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

import static io.qameta.allure.Allure.step;

@Tag("ios")
public class SampleAppSearchTests extends TestBase {

    private final SampleAppSearchScreen searchScreen = new SampleAppSearchScreen();
    private final SampleAppSearchResultsScreen searchResultsScreen = new SampleAppSearchResultsScreen();

    @Test
    void successfulSearchTest() {
        String query = "Appium";

        step("Perform search", () ->
                searchScreen.searchFor(query));

        step("Verify result", () ->
                assertThat(searchResultsScreen.getResult()).isEqualTo(query));
    }
}
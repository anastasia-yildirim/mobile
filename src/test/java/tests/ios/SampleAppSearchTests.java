package tests.ios;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ios.SampleAppSearchResultsScreen;
import pages.ios.SampleAppSearchScreen;
import tests.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

import static io.qameta.allure.Allure.step;

@Tag("ios")
public class SampleAppSearchTests extends TestBase {

    SampleAppSearchScreen searchScreen = new SampleAppSearchScreen();
    SampleAppSearchResultsScreen searchResultsScreen = new SampleAppSearchResultsScreen();

    String query = "Appium";

    @Test
    void successfulSearchTest() {
        step("Perform search", () ->
                searchScreen.searchFor(query));

        step("Verify result", () ->
                assertThat(searchResultsScreen.getResult()).isEqualTo(query));
    }
}
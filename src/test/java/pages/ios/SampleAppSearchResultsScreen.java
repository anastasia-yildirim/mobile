package pages.ios;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class SampleAppSearchResultsScreen {

    private final SelenideElement TEXT_OUTPUT = $(accessibilityId("Text Output"));

    public String getResult() {
        return TEXT_OUTPUT.getText();
    }
}

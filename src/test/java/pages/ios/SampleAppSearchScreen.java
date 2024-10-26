package pages.ios;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class SampleAppSearchScreen {

    private final SelenideElement TEXT_BUTTON = $(accessibilityId("Text Button"));
    private final SelenideElement TEXT_INPUT = $(accessibilityId("Text Input"));

    public void searchFor(String query){
        TEXT_BUTTON.click();
        TEXT_INPUT.click();
        TEXT_INPUT.sendKeys(query);
        TEXT_INPUT.pressEnter();
    }
}

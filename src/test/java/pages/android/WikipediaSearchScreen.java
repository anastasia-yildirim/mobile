package pages.android;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class WikipediaSearchScreen {

    private final SelenideElement SEARCH_BAR_AREA = $(accessibilityId("Search Wikipedia"));
    private final SelenideElement SEARCH_BAR_ELEMENT = $(id("org.wikipedia.alpha:id/search_src_text"));

    public void searchFor(String query) {
        SEARCH_BAR_AREA.click();
        SEARCH_BAR_ELEMENT.sendKeys(query);
    }

}

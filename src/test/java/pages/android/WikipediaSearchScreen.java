package pages.android;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class WikipediaSearchScreen {

    private final SelenideElement searchCard = $(accessibilityId("Search Wikipedia"));
    private final SelenideElement searchBar = $(id("org.wikipedia.alpha:id/search_src_text"));

    public void searchFor(String query) {
        searchCard.click();
        searchBar.sendKeys(query);
    }
}
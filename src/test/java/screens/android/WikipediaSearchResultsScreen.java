package screens.android;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

@Getter
public class WikipediaSearchResultsScreen {

    private final ElementsCollection textArea = $$(className("android.widget.TextView"));
    private final ElementsCollection foundItems = $$(id("org.wikipedia.alpha:id/page_list_item_title"));
    private final SelenideElement subtitle = $(id("pcs-edit-section-title-description"));

    public int getResultsCount() {

        return foundItems.size();
    }

    public String openFoundArticle(int articleNumber) {
        foundItems.get(articleNumber).click();
        subtitle.shouldBe(visible);

        return textArea.getFirst().getAttribute("text");
    }
}
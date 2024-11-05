package screens.android;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class WikipediaSearchResultsScreen {

    static final ElementsCollection textArea = $$(className("android.widget.TextView"));
    private final ElementsCollection foundItems = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    public int getResultsCount() {

        return foundItems.size();
    }

    public String ppenFoundArticle(int articleNumber) {
        foundItems.get(articleNumber).click();

        return textArea.get(0).getAttribute("text");
    }
}
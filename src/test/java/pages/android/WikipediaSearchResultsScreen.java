package pages.android;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class WikipediaSearchResultsScreen {

    private final ElementsCollection FOUND_ITEMS_CLICKABLE_AREAS = $$(className("android.view.ViewGroup"));
    private final ElementsCollection FOUND_ITEMS_TITLES = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    public void openFoundArticle(int resultNumber) {
        FOUND_ITEMS_CLICKABLE_AREAS.get(resultNumber).click();
    }

    public int getResultsCount() {
        return FOUND_ITEMS_TITLES.size();
    }
}
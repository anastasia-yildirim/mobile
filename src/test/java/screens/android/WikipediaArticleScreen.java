package screens.android;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;

public class WikipediaArticleScreen {

    private final SelenideElement articleTitle = $(className("android.webkit.WebView"));

    public String getTitle() {

        return articleTitle.getText();
    }

}
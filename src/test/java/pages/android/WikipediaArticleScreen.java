package pages.android;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class WikipediaArticleScreen {

    private final SelenideElement ARTICLE_TITLE = $(byXpath("/hierarchy/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget." +
            "FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/" +
            "android.view.View[1]"));

    private final SelenideElement ARTICLE_SUBTITLE = $(id("pcs-edit-section-title-description"));

    public String getTitle() {

        return ARTICLE_TITLE.getText();
    }

    public String getSubtitle() {

        return ARTICLE_SUBTITLE.getText();
    }
}

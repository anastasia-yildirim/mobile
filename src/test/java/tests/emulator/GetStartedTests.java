package tests.emulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.android.GetStartedScreen;
import screens.android.WikipediaSearchScreen;
import tests.TestBase;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("emulator")
@DisplayName("Проверка онбординга нового пользователя Wikipedia")
public class GetStartedTests extends TestBase {

    private final GetStartedScreen getStartedScreen = new GetStartedScreen();
    private final WikipediaSearchScreen searchScreen = new WikipediaSearchScreen();

    @Test
    void successfullySkipOnboarding() {
        step("Закрыть экран онбординга Get Started с помощью кнопки Skip", getStartedScreen::clickSkipButton);
        step("Убедиться, что отображается строка поиска", () ->
                assertThat(searchScreen.getSearchCard().isDisplayed()));
    }

    @Test
    void successfullyGoThroughOnboarding() {
        step("Перейти на следующий экран туториала, нажав Сontinue", getStartedScreen::clickContinueButton);

        step("Проверить, что отображается корректное название экрана", () ->
                getStartedScreen.checkPageTitleIsDisplayed(getStartedScreen.getExpectedTitleForSecondScreen()));

        step("Перейти на следующий экран туториала, нажав Сontinue", getStartedScreen::clickContinueButton);

        step("Проверить, что отображается корректное название экрана", () ->
                getStartedScreen.checkPageTitleIsDisplayed(getStartedScreen.getExpectedTitleForThirdScreen()));

        step("Перейти на следующий экран туториала, нажав Сontinue", getStartedScreen::clickContinueButton);

        step("Проверить, что отображается корректное название экрана", () ->
                getStartedScreen.checkPageTitleIsDisplayed(getStartedScreen.getExpectedTitleForFourthScreen()));

        step("Перейти на главный экран, нажав Get Started", getStartedScreen::clickGetStartedButton);

        step("Убедиться, что отображается строка поиска", () ->
                assertThat(searchScreen.getSearchCard().isDisplayed()));
    }
}
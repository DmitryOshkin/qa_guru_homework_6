package yandex.oshkin.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepsTest {

    private static final String REPOSITORY = "DmitryOshkin/qa_guru_homework_6";
    private static final int NUMBER = 2;

    @Test
    public void lambdaTestIssueSearch() {

        Allure.label("owner", "DmitryOshkin");
        Allure.feature("Issues");
        Allure.story("Поиск Issue в репозитории");
        Allure.label("severity", SeverityLevel.NORMAL.value());
        Allure.link("GitHub", "https://github.com/");

        step("Открываем главную страницу gitHub", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем наличие Issues с именем 'number " + NUMBER + "'", () -> {
            $(withText("number " + NUMBER)).should(Condition.visible);
        });

    }
}

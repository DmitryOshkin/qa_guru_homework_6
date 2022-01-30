package yandex.oshkin.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    @Test
    public void testIssueSearch() {

        //Открываем главную страницу gitHub
        open("https://github.com/");
        //Ищем репозиторий
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("DmitryOshkin/qa_guru_homework_6");
        $(".header-search-input").submit();
        //Переходим в репозиторий
        $(linkText("DmitryOshkin/qa_guru_homework_6")).click();
        //Открываем таб Issues
        $(partialLinkText("Issues")).click();
        //Проверяем наличие Issues с именем
        $(withText("number 2")).should(Condition.visible);
    }
}

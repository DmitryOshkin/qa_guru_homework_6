package yandex.oshkin.allure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    private static final String REPOSITORY = "DmitryOshkin/qa_guru_homework_6";
    private static final int NUMBER = 2;

    WebSteps steps = new WebSteps();

    @Test
    public void annotatedStepsTest() {

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(NUMBER);

    }

    @AfterEach
    public void saveSources() {
        steps.attachPageSource();
    }
}

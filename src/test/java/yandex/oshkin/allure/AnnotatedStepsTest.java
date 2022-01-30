package yandex.oshkin.allure;

import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    private static final String REPOSITORY = "DmitryOshkin/qa_guru_homework_6";
    private static final int NUMBER = 2;

    @Test
    public void annotatedStepsTest() {

        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(NUMBER);

    }
}

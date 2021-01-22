package suites.smokeTests;

import io.qameta.allure.Issue;
import listeners.CustomIRetryAnalyzer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import suites.BaseTest;
import static com.codeborne.selenide.Condition.*;

@Test(description = "Search text and result", priority = 1)
public class smokeTest extends BaseTest {
    public void open() {
        yandex.open();
        yandex.setTextInSearch("тест").
                getResults().first(10).
                excludeWith(text("тест")).
                shouldHaveSize(0);
    }

    @Issue("666")
    @Test(description = "Search text and dataProvider", dataProvider = "section", priority = 2,retryAnalyzer = CustomIRetryAnalyzer.class)
    public void sections(String text) {
        yandex.open();
        yandex.setTextInSearch(text).
                getResults().shouldHaveSize(1);
    }

    @DataProvider(name = "section", parallel = true)
    public Object[][] section() {
        return new Object[][]{{"дата_провайдер_1"}, {"дата_провайдер_2"}};
    }
}
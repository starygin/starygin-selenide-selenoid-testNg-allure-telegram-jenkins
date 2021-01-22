package suites.sanityTest;

import org.testng.annotations.Test;
import suites.BaseTest;

import static com.codeborne.selenide.Condition.text;

public class sanityTest extends BaseTest {

    @Test(description = "run the test every two days", priority = 10)
        public void open() {
            yandex.open();
            yandex.setTextInSearch("Тест будет запускаться раз в два дня").
                    getResults().shouldHaveSize(14).
                    excludeWith(text("Тест будет запускаться раз в два дня")).
                    shouldHaveSize(0);
        }
    }


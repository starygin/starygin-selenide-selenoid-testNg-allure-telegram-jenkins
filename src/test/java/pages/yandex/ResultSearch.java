package pages.yandex;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class ResultSearch {

    @Step("Получить результаты поиска")
    public ElementsCollection getResults() {
        return Selenide.$$x("//li[@class='serp-item']");
    }

}

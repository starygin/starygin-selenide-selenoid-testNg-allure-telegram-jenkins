package pages.yandex;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    @Step("������� https://yandex.ru/")
    public void open() {
        Selenide.open("https://yandex.ru/");
    }


    @Step("������ � ���� ����� {text}")
    public ResultSearch setTextInSearch(String text) {
        $(byId("text")).setValue(text);
        $(byText("�����")).click();
        return new ResultSearch();
    }

}

package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public abstract class AbstractStep {

    @Step("Open https://www.saucedemo.com/{urn}")
    protected void openPage (String urn, String pageIdSelector, Condition successCondition) {
        open(urn);
        $(pageIdSelector).shouldHave(successCondition);
    }
}

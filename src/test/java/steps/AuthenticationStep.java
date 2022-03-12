package steps;

import com.codeborne.selenide.Condition;
import constants.DomainConstants;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AuthenticationStep extends AbstractStep {

    static {
        System.setProperty("username","standard_user");
        System.setProperty("password","secret_sauce");
    }
    public static final String USERNAME_CSS = ".input_error[name=user-name] ";
    public static final String PASSWORD_CSS = ".input_error[name=password]";
    public static final String LOGIN_BUTTON_CSS = ".submit-button";

    @Step("Open Sausedemo + Login {username}/*****")
    public void login(String username, String password) {
        $(USERNAME_CSS).sendKeys(username);
        $(PASSWORD_CSS).sendKeys(password);
        $(LOGIN_BUTTON_CSS).click();
    }

    public AuthenticationStep open() {
        openPage(DomainConstants.BASE_URL,
                LOGIN_BUTTON_CSS,
                Condition.value(DomainConstants.LOGIN_BUTTON_VALUE)
        );
        return this;
    }

    @Step("Valid credentials login")
    public CatalogPageStep validLogin() {
        login(System.getProperty("username"),System.getProperty("password"));
        return new CatalogPageStep();
    }
}
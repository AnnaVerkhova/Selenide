package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPageStep extends AbstractStep {

    public static final String CHECKOUT_OVERVIEW_URL = "checkout-step-two.html/";
    public static final String TITLE_TEXT = ("//span[@class='title' and text()='Checkout: Overview']");
    public static final String TITLE_CSS = ".title";
    public static final String FINISH_BUTTON_CSS = ".cart_button";

    @Step("Checking CheckoutOverview page")
    public CheckoutOverviewPageStep visiblePageCheckoutOverview() {
        $(TITLE_CSS).shouldBe(Condition.visible);
        return this;
    }

    @Step("Open CheckoutOverview page")
    public CheckoutOverviewPageStep open() {
        openPage(CHECKOUT_OVERVIEW_URL,
                TITLE_CSS,
                Condition.text(TITLE_TEXT)
        );
        return this;
    }

    @Step("Completion of testing")
    public CheckoutCompletePageStep finish (){
        $(FINISH_BUTTON_CSS).click();
        return new CheckoutCompletePageStep();
    }
}

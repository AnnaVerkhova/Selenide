package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePageStep extends AbstractStep{

    public static final String CHECKOUT_COMPLETE_URL = "checkout-complete.html/";
    public static final String TITLE_TEXT = ("//span[@class='title' and text()='Checkout: Overview']");
    public static final String TITLE_CSS = ".title";

    @Step("Checking CheckoutOverview page")
    public CheckoutCompletePageStep visiblePageCheckoutComplete() {
        $(TITLE_CSS).shouldBe(Condition.visible);
        return this;
    }


}

package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;


public class CartPageStep extends AbstractStep {

    public static final String CART_URL = "cart.html/";
    public static final String TITLE_TEXT = ("//span[@class='title' and text()='Your Cart']");
    public static final String TITLE_CSS = ".title";
    public static final String CHECKOUT_BUTTON_CSS = ".checkout_button";

    private CheckoutPageStep checkoutPageStep;

    @Step("Open cart page")
    public CartPageStep open() {
        openPage(CART_URL,
                TITLE_CSS,
                Condition.text(TITLE_TEXT)
        );
        return this;
    }

    @Step("Checking cart page")
    public CartPageStep visiblePageCart() {
        $(TITLE_CSS).shouldBe(Condition.visible);
        return this;
    }
    @Step("Click button CHECKOUT")
    public CheckoutPageStep checkout(){
        $(CHECKOUT_BUTTON_CSS).click();
        return new  CheckoutPageStep();
    }
}

package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPageStep extends AbstractStep{

    public static final String CHECKOUT_URL = "checkout-step-one.html/";
    public static final String TITLE_TEXT = ("//span[@class='title' and text()='Checkout: Your Information']");
    public static final String TITLE_CSS = ".title";
    public static final String FIRST_NAME_CSS =".input_error[name=firstName]";
    public static final String LAST_NAME_CSS =".input_error[name=lastName]";
    public static final String POSTAL_CODE_CSS =".input_error[name=postalCode]";
    public static final String CONTINUE_BUTTON_CSS = ".submit-button";


    @Step("Checking сheckout page")
    public CheckoutPageStep visiblePageCheckout() {
        $(TITLE_CSS).shouldBe(Condition.visible);
        return this;
    }

    @Step("Open сheckout page")
    public CheckoutPageStep open() {
        openPage(CHECKOUT_URL,
                TITLE_CSS,
                Condition.text(TITLE_TEXT)
        );
        return this;
    }

    static {
        System.setProperty("firstname","Anna");
        System.setProperty("lastname","Verkhova");
        System.setProperty("postalcode","123");
    }

    @Step("Fill in the details {firstname}/{lastname}{postalcode}")
    public void inputDate(String firstname, String lastname,String postalcode) {
        $(FIRST_NAME_CSS).sendKeys(firstname);
        $(LAST_NAME_CSS).sendKeys(lastname);
        $(POSTAL_CODE_CSS).sendKeys(postalcode);
        $(CONTINUE_BUTTON_CSS).click();
    }

    @Step("Valid credentials ")
    public CheckoutOverviewPageStep validInputDate() {
        inputDate(System.getProperty("firstname"),System.getProperty("lastname"),System.getProperty("postalcode"));
        return new CheckoutOverviewPageStep();
    }
}

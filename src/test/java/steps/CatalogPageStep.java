package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPageStep extends AbstractStep {

    public static final String CATALOG_URL = "inventory.html/";
    public static final String TITLE_CSS = ".title";
    public static final String TITLE_TEXT = "Products";
    public static final String CART_ELEMENT_CSS = ".shopping_cart_link";
    public static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";
    private CartPageStep cartPageStep;


    @Step("Open catalog page")
    public CatalogPageStep open() {
        openPage(CATALOG_URL,
                TITLE_CSS,
                Condition.text(TITLE_TEXT)
        );
        return this;
    }

    @Step("Checking catalog page")
    public CatalogPageStep visiblePageCatalog() {
        $(TITLE_CSS).shouldBe(Condition.visible);
        return this;
    }

    @Step("Add product to cart")
    public CatalogPageStep addProductToCart(String partialProductTitle) {
        $(By.xpath(String.format(PRODUCT_XPATH_PATTERN, partialProductTitle))).click();
        return this;
    }

    @Step("Open cart page")
    public CartPageStep openCartPage() {
        $(CART_ELEMENT_CSS).click();
        return new CartPageStep();
    }
}



package tests;

import org.testng.annotations.Test;

public class PostUpdateTest extends BaseTest {

    public static final String TEST_PRODUCT_TITLE = "Test.allTheThings() T-Shirt (Red)";
    public static final String TEST_PRODUCT2_TITLE = "Sauce Labs Onesie";

    @Test
    public void ProductTest() {
        LoginSteps.open()
                .validLogin()
                .visiblePageCatalog()
                .addProductToCart(TEST_PRODUCT_TITLE)
                .addProductToCart(TEST_PRODUCT2_TITLE)
                .openCartPage()
                .visiblePageCart()
                .checkout()
                .visiblePageCheckout()
                .validInputDate()
                .visiblePageCheckoutOverview()
                .finish()
                .visiblePageCheckoutComplete()
                ;
    }
}
package tests;

import com.codeborne.selenide.Configuration;
import constants.DomainConstants;
import org.testng.annotations.BeforeMethod;
import steps.AuthenticationStep;

public class BaseTest {

    static {
        System.setProperty("browser","chrome");
        System.setProperty("baseUrl","https://www.saucedemo.com/");
    }

    AuthenticationStep LoginSteps = new AuthenticationStep();


    @BeforeMethod
    public void setup(){
        Configuration.baseUrl = DomainConstants.BASE_URL;
        Configuration.headless = false;
        Configuration.browser =System.getProperty("browser");

    }

}

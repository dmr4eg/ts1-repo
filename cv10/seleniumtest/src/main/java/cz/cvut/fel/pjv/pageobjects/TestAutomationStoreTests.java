package cz.cvut.fel.pjv.pageobjects;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestAutomationStoreTests {
    @Test
    public void registrationTest() {
        System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
        WebDriver driver = new SafariDriver();
        new MainPage(driver)
                .openEShop()
                .clickLoginOrRegister()
                .clickContinue()
                .typeFirstName("John")
                .typeFirstName("Text");
    }
}

package cz.cvut.fel.pjv.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    @FindBy(how = How.CSS, using = "ul[id='customer_menu_top'] li a")
    private WebElement loginOrRegisterAnchor;
    public MainPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
//        wait.until(ExpectedConditions.visibilityOf(loginOrRegisterAnchor));
        this.driver = driver;
    }

    public MainPage openEShop(){
        driver.get("https://automationteststore.com/");
        return this;
    }
    public AccountLoginPage clickLoginOrRegister(){
        loginOrRegisterAnchor.click();
        return new AccountLoginPage(driver);
    }
}

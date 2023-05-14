package cz.cvut.fel.pjv.pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;

    @FindBy(how = How.CSS, using = "#AccountFrm_firstname")
    private WebElement firstNameInput;

    @FindBy(how = How.CSS, using = ".maintext")
    private WebElement pageTitle;

    public RegistrationPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
    }

    public RegistrationPage typeFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegistrationPage titleHasText(String titleText) {
        Assertions.assertEquals(titleText, pageTitle.getText());
        return this;
    }


}

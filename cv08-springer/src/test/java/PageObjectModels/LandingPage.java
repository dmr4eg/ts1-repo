package PageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    WebDriver driver;

    @FindBy(css = ".register-link.flyout-caption")
    private WebElement redirectToLoginButton;

    @FindBy(css = "#advanced-search-link")
    private WebElement redirectToAdvancedSearch;

    @FindBy(css = "img[alt=\"Search Options\"")
    private WebElement gearButton;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLandingPage(){
        driver.get("https://link.springer.com/");
    }

    public void clickLoginButton(){
        redirectToLoginButton.click();
    }

    public void clickAdvancedSearchButton() {
        gearButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // Wait for a maximum of 10 seconds
        wait.until(ExpectedConditions.visibilityOf(redirectToAdvancedSearch));

        redirectToAdvancedSearch.click();
    }
}

package PageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(css = "#login-box-email")
    private WebElement emailInput;

    @FindBy(css = "#login-box-pw")
    private WebElement passwordInput;

    @FindBy(css = ".form-submit > button:nth-child(1)")
    private WebElement loginSubmitButton;

    @FindBy(css = "#logo > img:nth-child(1)")
    private WebElement logo;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage(){
        driver.get("https://link.springer.com/signup-login");
    }

    public void fillOutEmail(String email){
        emailInput.sendKeys(email);
    }

    public void fillOutPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void submitLogin(){
        loginSubmitButton.click();
    }

    public void clickLogo(){
        logo.click();
    }
}

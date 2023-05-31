package PageObjectModels;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class AdvancedSearch {
    WebDriver driver;

    @FindBy(css = ".register-link.flyout-caption")
    private WebElement redirectToLoginButton;

    @FindBy(css = "#advanced-search-link")
    private WebElement redirectToAdvancedSearch;

    @FindBy(css = "img[alt=\"Search Options\"")
    private WebElement gearButton;

    @FindBy(css = "#all-words")
    private WebElement allOfTheWords;

    @FindBy(css = "#least-words")
    private WebElement atleastOneOfTheWords;

    @FindBy(css = "#facet-start-year")
    private WebElement startYear;

    @FindBy(css = "#facet-end-year")
    private WebElement endYear;

    @FindBy(css = "#submit-advanced-search")
    private WebElement submitSearch;

    @FindBy(css = "button.cc-button:nth-child(1)")
    private WebElement acceptCookiesButton;

    @FindBy(css = "#title-is")
    private WebElement titleInput;

    public AdvancedSearch(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openAdvancedSearchPage(){
        driver.get("https://link.springer.com/advanced-search");
    }

    public void searchForAllOfTheWords(String input){
        allOfTheWords.sendKeys(input);
    }

    public void clickAdvancedSearchButton() {
        gearButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(redirectToAdvancedSearch));

        redirectToAdvancedSearch.click();
    }

    public void searchAtLeastOneOfTheWords(String input){
        atleastOneOfTheWords.sendKeys(input);
    }

    public void setStartYear(int startYear){
        this.startYear.sendKeys(String.valueOf(startYear));
    }

    public void setEndYear(int endYear){
        this.endYear.sendKeys(String.valueOf(endYear));
    }

    public void submitSearch(){
        this.submitSearch.click();
    }

    public void openNthResult(int n){
        String cssSelector;
        cssSelector = String.format("li.no-access:nth-child(%d) > h2:nth-child(4) > a:nth-child(1)", n);
        if (!isElementPresent(cssSelector)){
            cssSelector = String.format("#results-list > li:nth-child(%d) > h2:nth-child(3) > a:nth-child(1)", n);
        }

        WebElement searchResultLink = driver.findElement
                (new By.ByCssSelector(cssSelector));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchResultLink));

        searchResultLink.click();
    }

    public void openNthResultInNewTab(int n){
        String cssSelector;
        cssSelector = String.format("li.no-access:nth-child(%d) > h2:nth-child(4) > a:nth-child(1)", n);
        if (!isElementPresent(cssSelector)){
            cssSelector = String.format("#results-list > li:nth-child(%d) > h2:nth-child(3) > a:nth-child(1)", n);
        }

        WebElement searchResultLink = driver.findElement
                (new By.ByCssSelector(cssSelector));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchResultLink);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchResultLink));

        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).click(searchResultLink).keyUp(Keys.CONTROL).build().perform();
    }

    private boolean isElementPresent(String cssSelector) {
        try {
            // Attempt to find the element using the given locator
            driver.findElement(new By.ByCssSelector(cssSelector));
            return true; // Element found, so it exists
        } catch (Exception e) {
            return false; // Element not found, so it does not exist
        }
    }

    public void searchForArticles(){
        for (int i = 1; i <= 12; i++) {
            String cssSelector = String.format("#content-type-facet > ol:nth-child(2) > " +
                    "li:nth-child(%d) > a:nth-child(1) > span:nth-child(2)", i);
            if (isElementPresent(cssSelector)){
                WebElement span = driver.findElement(new By.ByCssSelector(cssSelector));
                if (Objects.equals(span.getText(), "Article")){
                    span.click();
                    return;
                }
            }
            else {
                return;
            }
        }
    }

    public void searchByTitle(String string){
        titleInput.sendKeys(string);
    }

    public void acceptCookies(){
        acceptCookiesButton.click();
    }
}

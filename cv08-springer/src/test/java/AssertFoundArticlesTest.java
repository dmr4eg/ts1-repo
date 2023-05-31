import PageObjectModels.AdvancedSearch;
import PageObjectModels.Article;
import PageObjectModels.LandingPage;
import PageObjectModels.LoginPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriterSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;



public class AssertFoundArticlesTest {
    WebDriver driver;
    LandingPage landingPage;
    AdvancedSearch advancedSearch;
    LoginPage loginPage;
    Article article;
    static List<String> articleNames = new ArrayList<>();
    static List<String> articleDOIs = new ArrayList<>();
    static List<String> articlePublishingDates = new ArrayList<>();
    @BeforeEach
    public void setup(){
        driver = new FirefoxDriver();
        landingPage = new LandingPage(driver);
        advancedSearch = new AdvancedSearch(driver);
        loginPage = new LoginPage(driver);
        article = new Article(driver);
    }
    @Order(1)
    @Test
    public void advancedSearch(){
        landingPage.openLandingPage();
        advancedSearch.acceptCookies();
        landingPage.clickAdvancedSearchButton();
        advancedSearch.searchForAllOfTheWords("Page Object Model");
        advancedSearch.searchAtLeastOneOfTheWords("Sellenium Testing");
        advancedSearch.setStartYear(2023);
        advancedSearch.setEndYear(2023);
        advancedSearch.submitSearch();
        advancedSearch.searchForArticles();

        for (int i = 1; i <= 4; i++){
            advancedSearch.openNthResultInNewTab(i);
        }



        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (int j = 1; j <= 4; j++){
            driver.switchTo().window(tabs.get(j));
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            articlePublishingDates.add(article.getPublishedDate());
            articleDOIs.add(article.getDOI());
            articleNames.add(article.getTitle());
        }
        driver.quit();

        try {
            FileWriter csvWriter = new FileWriter("./src/test/resources/search_results.csv");

            // Write the header row
            csvWriter.append("Article Name");
            csvWriter.append(",");
            csvWriter.append("DOI");
            csvWriter.append(",");
            csvWriter.append("Publishing Date");
            csvWriter.append("\n");

            // Write each search result
            for (int i = 0; i < articleNames.size(); i++) {
                csvWriter.append(articleNames.get(i));
                csvWriter.append(",");
                csvWriter.append(articleDOIs.get(i));
                csvWriter.append(",");
                csvWriter.append(articlePublishingDates.get(i));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Order(2)
    @ParameterizedTest(name = "Article_{index}: {0}, {1}, {2}")
    @CsvFileSource(resources = "./search_results.csv", numLinesToSkip = 1)
    public void assertSearchResults(String articleName, String articleDOI, String articlePublishingDate) {
        //OPEN PAGE AND REDIRECT TO LOGIN PAGE
        landingPage.openLandingPage();
        advancedSearch.acceptCookies();
        landingPage.clickLoginButton();

        //FILL OUT EMAIL AND PASSWORD AND LOG IN
        loginPage.fillOutEmail("bob@ross.cz");
        loginPage.fillOutPassword("A12345");
        loginPage.submitLogin();
        loginPage.clickLogo();

        //SEARCH FOR THE BOOK
        landingPage.clickAdvancedSearchButton();
        advancedSearch.searchByTitle(articleName);
        advancedSearch.submitSearch();
        advancedSearch.searchForArticles();
        advancedSearch.openNthResult(1);

        Assertions.assertEquals(articleName, article.getTitle());
        Assertions.assertEquals(articleDOI, article.getDOI());
        Assertions.assertEquals(articlePublishingDate, article.getPublishedDate());

        //CLOSE BROWSER
        driver.close();
    }
}



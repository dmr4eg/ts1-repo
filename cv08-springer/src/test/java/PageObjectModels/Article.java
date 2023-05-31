package PageObjectModels;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Article {

    WebDriver driver;

    @FindBy(css = "span[data-test=\"article-publication-year\"]")
    private WebElement articlePublicationYear;

    @FindBy(css = "span.c-bibliographic-information__value:nth-child(3)")
    private WebElement DOI;

    @FindBy(css = ".c-article-title")
    private WebElement title;

    @FindBy(css = "li.c-bibliographic-information__list-item:nth-child(2) > " +
            "p:nth-child(1) > span:nth-child(2) > time:nth-child(1)")
    private WebElement publishedDate;

    public Article(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getArticlePublicationYear(){
        return Integer.parseInt(articlePublicationYear.getText());
    }

    public String getDOI(){
        return DOI.getText();
    }


    public String getTitle(){
        return title.getText();
    }

    public String getPublishedDate(){
        return publishedDate.getText();
    }
}

import com.google.common.annotations.VisibleForTesting;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTests {
    @Test
    public void firstSeleniumTest() {
        System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
        WebDriver driver = new SafariDriver();
        driver.get("https://automationteststore.com/index.php?rt=account/create");
        String titleText = driver.findElement(By.cssSelector("h1 span.maintext")).getText();
        System.out.println(titleText);

        driver.findElement(By.cssSelector("#AccountFrm_firstname")).sendKeys("John");
        driver.findElement(By.cssSelector("#AccountFrm_lastname")).sendKeys("Bruh");

        driver.findElement(By.cssSelector("#AccountFrm_email")).sendKeys("sadas@asdasd.cz");
        driver.findElement(By.cssSelector("#AccountFrm_telephone")).sendKeys("1234567890");

        driver.findElement(By.cssSelector("#AccountFrm_address_1")).sendKeys("asdasd");

        driver.findElement(By.cssSelector("#AccountFrm_city")).sendKeys("Prague");

        driver.findElement(By.cssSelector("#AccountFrm_zone_id")).sendKeys("Praha");

        driver.findElement(By.cssSelector("#AccountFrm_postcode")).sendKeys("12345");

        driver.findElement(By.cssSelector("#AccountFrm_loginname")).sendKeys("lol123");
        driver.findElement(By.cssSelector("#AccountFrm_password")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("#AccountFrm_confirm")).sendKeys("qwerty");

        driver.findElement(By.cssSelector("#AccountFrm_loginname")).sendKeys("12345");

        Select countrySelect = new Select(driver.findElement(By.cssSelector("#AccountFrm_country_id")));
        countrySelect.selectByVisibleText("Czech Republic");
        driver.findElement(By.cssSelector("#AccountFrm_agree")).click();
        driver.findElement(By.cssSelector("button[title='Continue']")).click();


//        driver.close();
    }
}

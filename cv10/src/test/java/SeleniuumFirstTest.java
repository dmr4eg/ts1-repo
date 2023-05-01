import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniuumFirstTest {
    @Test
    public void firstSeleniumTest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationteststore.com/index.php?rt=account/create");
        String title = driver.findElement(By.cssSelector("h1 span.maintext")).getText();
        System.out.println(title);
        driver.findElement(By.cssSelector("#AccountFrm_firstname")).sendKeys("Alisher");
        Select countrySelect = new Select(driver.findElement(By.cssSelector("#AccountFrm_country_id")));
        countrySelect.selectByVisibleText("Viet Nam");
        driver.findElement(By.cssSelector("#AccountFrm_lastname")).sendKeys("Nurakhmetov");
        driver.findElement(By.cssSelector("#AccountFrm_email")).sendKeys("csgocsgo70@gmail.com");
        driver.findElement(By.cssSelector("#AccountFrm_address_1")).sendKeys("Pushkina");
        driver.findElement(By.cssSelector("#AccountFrm_city")).sendKeys("DamirChan");
        Select regionSelect = new Select(driver.findElement(By.cssSelector("#AccountFrm_zone_id")));
        regionSelect.selectByVisibleText("An Giang");
        driver.findElement(By.cssSelector("#AccountFrm_postcode")).sendKeys("12345");
        driver.findElement(By.cssSelector("#AccountFrm_loginname")).sendKeys("ZALUPKIN");
        driver.findElement(By.cssSelector("#AccountFrm_password")).sendKeys("domojchochu");
        driver.findElement(By.cssSelector("#AccountFrm_confirm")).sendKeys("domojchochu");
        driver.findElement(By.cssSelector("#AccountFrm_agree")).click();
        driver.findElement(By.cssSelector("button[title='Continue']")).click();

        //        driver.close();
    }
}

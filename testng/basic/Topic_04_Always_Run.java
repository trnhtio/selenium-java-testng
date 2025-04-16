package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_04_Always_Run {
    // Arrange
    // Setup/ initial data/ Browser/ Driver/ Variable/ DB/...
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        Assert.assertTrue(false);

        System.out.println("---------Pass before class----------");
    }

    // Action
    @Test
    public void register() {
        System.out.println("Action and Verify");

        // ----------------Action----------------
        // open page

        // fill data

        // Submit

        // ----------------Assert----------------
        // Verify success message

    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
       driver.quit();
       System.out.println("---------Pass after class----------");
    }
}
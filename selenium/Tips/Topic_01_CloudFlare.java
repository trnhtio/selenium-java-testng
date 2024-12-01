package Tips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_01_CloudFlare {
    WebDriver driver;

    //'/Users/lap14811/code/Selenium_Online_31/02- selenium/selenium-java-testng/~/Users/lap14811/Library/Application Support/Microsoft Edge/ User Data'
    @BeforeClass
    public void beforeClass() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--user-data-dir=/Users/lap14811/Library/Application Support/Microsoft Edge/");
        edgeOptions.addArguments("--profile-directory=Profile 7");
        driver = new EdgeDriver(edgeOptions);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @Test
    public void TC_01_Nopcommerce() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/register");
        Thread.sleep(2000);
    }

   // @AfterClass
   // public  void afterClass(){
    //    driver.quit();
    //}
}
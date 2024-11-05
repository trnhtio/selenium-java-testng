package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_Relative_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Relative_Locator() {
        driver.get("https://www.facebook.com/");

        //1 - Khai báo biến
        // Khi dữ liệu này được sử dụng nhiều lần = tái sử dụng (reuseable)
        String emailAddress = "totrinh.qa@gmail.com";
        By emailTextboxBy = By.cssSelector("");
        WebElement emailTextboxElement = driver.findElement(emailTextboxBy);


        emailTextboxElement.clear();
        emailTextboxElement.isDisplayed();
        emailTextboxElement.sendKeys( "");


        //2 - Không khai báo biến
        // Khi chỉ dùng 1 lần
        driver.findElement(emailTextboxBy).sendKeys("");

        WebElement priceFromElement = driver.findElement(RelativeLocator.with(By.tagName("input"))
                .toLeftOf(By.name("price[to]"))
                .below(By.id("sku"))
                .above(By.id("tax_class_id")));

        System.out.println(priceFromElement);

    }

    @Test
    public void TC_02_() {

    }

    @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
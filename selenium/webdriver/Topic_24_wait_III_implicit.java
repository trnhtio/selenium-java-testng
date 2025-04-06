package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class Topic_24_wait_III_implicit {
    WebDriver driver;

    @BeforeMethod
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test(description = "Thời gian implicit ngắn hơn element nó xuất hiện")
    public void TC_01_() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        // Click button Start
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Loading icon sẽ xuất hiện trong vòng 5s

        // Hello world sẽ hiển thị -> verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");


    }
    @Test(description = "Thời gian implicit = thời gian element nó xuất hiện")
    public void TC_02_() {
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Click button Start
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Loading icon sẽ xuất hiện trong vòng 5s

        // Hello world sẽ hiển thị -> verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }
    @Test(description = "Thời gian implicit dài hơn thời gian element nó xuất hiện")
    public void TC_03_() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // Click button Start
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Loading icon sẽ xuất hiện trong vòng 5s

        // Hello world sẽ hiển thị -> verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }
    @Test(description = "Thời gian implicit = 0 ")
    public void TC_04_() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        // Click button Start
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Loading icon sẽ xuất hiện trong vòng 5s

        // Hello world sẽ hiển thị -> verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }

    @AfterMethod
    public  void cleanBrowser(){
        driver.quit();
    }
}
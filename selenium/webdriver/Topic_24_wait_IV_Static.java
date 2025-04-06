package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Topic_24_wait_IV_Static {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        // Click button Start
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Loading icon sẽ xuất hiện trong vòng 5s
        sleepInSecond(0);

        // Hello world sẽ hiển thị -> verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");
    }
    @Test
    public void TC_02_() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        // Click button Start
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Loading icon sẽ xuất hiện trong vòng 5s
        sleepInSecond(3);

        // Hello world sẽ hiển thị -> verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");
    }
    @Test
    public void TC_03_() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        // Click button Start
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Loading icon sẽ xuất hiện trong vòng 5s
        sleepInSecond(5);

        // Hello world sẽ hiển thị -> verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");
    }
    @Test
    public void TC_04_() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        // Click button Start
        driver.findElement(By.cssSelector("div#start>button")).click();
        // Loading icon sẽ xuất hiện trong vòng 5s
        sleepInSecond(10);

        // Hello world sẽ hiển thị -> verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");
    }

    public void sleepInSecond(long timeInSec){
        try {
            Thread.sleep(timeInSec*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public  void clearBrowser(){
        driver.quit();
    }
}
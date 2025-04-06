package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_wait_V_Explicit_2 {
    WebDriver driver;
    WebDriverWait explicitWait;

    By startBtn = By.cssSelector("div#start>button");
    By loadingIcon = By.cssSelector("div#loading");
    By helloText = By.cssSelector("div#finish>h4");



    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

    }


    @Test(description = "Thời gian explicit = 0 ")
    public void TC_01_() {

        driver.get("https://automationfc.github.io/dynamic-loading/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(0));

        explicitWait.until(ExpectedConditions.elementToBeClickable(startBtn));
        driver.findElement(startBtn).click();
        // 1 - chờ cho step trước hoàn thành -> loading icon biếtn mất - không quan tâm step sau Hello text xuất hiện
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(helloText));

        //2- Chờ cho step sau xuất hiện (hello text hiển thị) - khong quan tâm step trước
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(helloText));

        Assert.assertEquals(driver.findElement(helloText).getText(),"Hello World!");

    }

    @Test(description = "Thời gian explicit nhỏ hơn điều kiện xảy ra ")
    public void TC_02_() {

        driver.get("https://automationfc.github.io/dynamic-loading/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        explicitWait.until(ExpectedConditions.elementToBeClickable(startBtn));
        driver.findElement(startBtn).click();
        // 1 - chờ cho step trước hoàn thành -> loading icon biếtn mất - không quan tâm step sau Hello text xuất hiện
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(helloText));

        //2- Chờ cho step sau xuất hiện (hello text hiển thị) - khong quan tâm step trước
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(helloText));

        Assert.assertEquals(driver.findElement(helloText).getText(),"Hello World!");

    }

    @Test(description = "Thời gian explicit = điều kiện xảy ra ")
    public void TC_03_() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        explicitWait.until(ExpectedConditions.elementToBeClickable(startBtn));
        driver.findElement(startBtn).click();
        // 1 - chờ cho step trước hoàn thành -> loading icon biếtn mất - không quan tâm step sau Hello text xuất hiện
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(helloText));

        //2- Chờ cho step sau xuất hiện (hello text hiển thị) - khong quan tâm step trước
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(helloText));

        Assert.assertEquals(driver.findElement(helloText).getText(),"Hello World!");
    }
    @Test(description = "Thời gian explicit lớn hơn điều kiện xảy ra")
    public void TC_04_() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        explicitWait.until(ExpectedConditions.elementToBeClickable(startBtn));
        driver.findElement(startBtn).click();
        // 1 - chờ cho step trước hoàn thành -> loading icon biếtn mất - không quan tâm step sau Hello text xuất hiện
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(helloText));

        //2- Chờ cho step sau xuất hiện (hello text hiển thị) - khong quan tâm step trước
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(helloText));

        Assert.assertEquals(driver.findElement(helloText).getText(),"Hello World!");
    }

    @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
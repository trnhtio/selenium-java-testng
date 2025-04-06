package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_wait_VIII_pageReady {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_element_Invisible() {
        driver.get("https://api.orangehrm.com/");

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner")));

        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div#project h1"),"OrangeHRM REST API Documentation"));
        Assert.assertEquals(driver.findElement(By.cssSelector("div#project h1")).getText(),"OrangeHRM REST API Documentation");

    }

    @Test
    public void TC_02_All_Element_invisible() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //Neu tat ca cac page trong app deu co su kien loading thi nen viet thanh ham dung chung
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='username']")));
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.oxd-button--main")).click();

        Assert.assertTrue(isAllloadingSpinnerInvisible());

        // chuyen qua trang PIM
        explicitWait.until((ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']"))));
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Assert.assertTrue(isAllloadingSpinnerInvisible());

        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div.oxd-topbar-header h6"),"PIM"));
        Assert.assertEquals(driver.findElement(By.cssSelector("div.oxd-topbar-header h6")).getText(),"PIM");

        // chuyen qua trang Time
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Time']")));
        driver.findElement(By.xpath("//span[text()='Time']")).click();
        Assert.assertTrue(isAllloadingSpinnerInvisible());

        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div.oxd-topbar-header h6"),"Time"));
        Assert.assertEquals(driver.findElement(By.cssSelector("div.oxd-topbar-header h6")).getText(),"Time");

    }
    @Test
    public void TC_03_pageReady(){
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#Email")));
        driver.findElement(By.cssSelector("input#Email")).sendKeys("admin@yourstore.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.login-button")).click();
        Assert.assertTrue(isPageLoadedSuccess());

        // chuyen qua trang product
        driver.get("https://admin-demo.nopcommerce.com/Admin/Customer/List");
        Assert.assertTrue(isPageLoadedSuccess());

        driver.get("https://admin-demo.nopcommerce.com/Admin/Order/List");
        Assert.assertTrue(isPageLoadedSuccess());

        driver.get("https://admin-demo.nopcommerce.com/Admin/Product/List");
        Assert.assertTrue(isPageLoadedSuccess());
    }

    public boolean isAllloadingSpinnerInvisible(){
        return explicitWait.until(ExpectedConditions.
                invisibilityOfAllElements(driver.findElements(By.cssSelector("div.oxd-loading-spinner"))));
    }

    public boolean isPageLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
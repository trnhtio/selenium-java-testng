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

public class Topic_24_wait_V_Explicit_1 {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_() {
        // Chờ cho 1 alert xuất hiện trên HTML + sau đó click vào
        explicitWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        // Element clickable
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isSelected());

        // Element visible (all)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isDisplayed());

        // Element selected(checkbox/ Radio)
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isSelected());

        // Invisible (all elements)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isDisplayed());

        // Element size
        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(""),15));
        Assert.assertEquals(driver.findElement(By.cssSelector("")),15);

        // Attribute
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector(""),"value","TrinhTT2"));
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getDomAttribute("value"),"TrinhTT2");

        // Text
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector(""),"TrinhTT"));
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getText(),"TrinhTT");
    }

    @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
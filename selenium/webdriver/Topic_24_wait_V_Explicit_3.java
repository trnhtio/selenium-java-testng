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

public class Topic_24_wait_V_Explicit_3 {
    WebDriver driver;
    WebDriverWait explicitWait;

    String uploadFilePath = System.getProperty("user.dir") + "/uploadFiles/";
    String germann = "benaja-germann.jpg";
    String zheng = "haotian-zheng.jpg";
    String neverchange = "thingsneverchange-unsplash.jpg";

    String germannPath = uploadFilePath + germann;
    String zhengPath = uploadFilePath + zheng;
    String neverchangePath = uploadFilePath + neverchange;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_Choose_Calendar() {
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // wait until date time is displayed
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1")));

        // wait until text show
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"No Selected Dates to display."));
        Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(),"No Selected Dates to display.");

        // wait to click current date
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/a[text()='29']")));

        // click
        driver.findElement(By.xpath("//td/a[text()='29']")).click();

        // wait loading icon
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div:not([style='display:none'])>div.raDiv")));

        // wait until update date text
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"Tuesday, April 29, 2025"));
        Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(),"Tuesday, April 29, 2025");

        // wait chosen date attribute class  rcSelected
        explicitWait.until(ExpectedConditions.attributeContains(By.xpath("//a[text()='29']/parent::td"),"class","rcSelected"));
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='29']/parent::td")).getDomAttribute("class").contains("rcSelected"));
    }

    @Test
    public void TC_02_Upload_File() {
        driver.get("https://gofile.io/?t=uploadFiles");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // wait until all loading icon invisibility
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(By.cssSelector("div#index_loader"))));

        // Load file
        driver.findElement(By.cssSelector("input[type='file']")).sendKeys(germannPath + "\n" +zhengPath);

        // wait until all progress bar invisibility
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div#fileList div.progress-container"))));

        // wait until text display
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div.text-center>h2"),"Upload Complete"));
        Assert.assertEquals(driver.findElement(By.cssSelector("div.text-center>h2")).getText(),"Upload Complete");

        //
       driver.get(driver.findElement(By.cssSelector("a.linkSuccessCard")).getDomAttribute("href"));

        //
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(By.cssSelector("div#index_loader"))));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='truncate']/a[text()='"+germann+"']")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='truncate']/a[text()='" + germann + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='truncate']/a[text()='" + zheng + "']")).isDisplayed());

    }

    @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
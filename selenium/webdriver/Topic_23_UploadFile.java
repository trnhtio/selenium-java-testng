package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_23_UploadFile {
    WebDriver driver;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_singeFile() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadFile = By.xpath("//input[@type='file']");
        // Load file len
        //driver.findElement(uploadFile)
        //.sendKeys("/Users/lap14811/code/Selenium_Online_31/02- selenium/selenium-java-testng/sourceDocs/uploadFiles/benaja-germann.jpg");

        driver.findElement(uploadFile).sendKeys(germannPath);
        //driver.findElement(uploadFile).sendKeys(zhengPath);
        driver.findElement(uploadFile).sendKeys(neverchangePath);

        // Verify file loaded
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + germann + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + neverchange + "']")).isDisplayed());
        // upload tung  file
        List<WebElement> startBtn = driver.findElements(By.cssSelector("table button.start"));

        for (WebElement start: startBtn){
            start.click();
            Thread.sleep(2000);
        }

        // Verify sau khi upload
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ germann +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ neverchange +"']")).isDisplayed());


    }

    @Test
    public void TC_02_multiFiles() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadFile = By.xpath("//input[@type='file']");
        // Load file len
        driver.findElement(uploadFile).sendKeys(germannPath + "\n"+ neverchangePath);

        // Verify file loaded
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + germann + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + neverchange + "']")).isDisplayed());
        // upload tung  file
        List<WebElement> startBtn = driver.findElements(By.cssSelector("table button.start"));

        for (WebElement start: startBtn){
            start.click();
            Thread.sleep(2000);
        }

        // Verify sau khi upload
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ germann +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ neverchange +"']")).isDisplayed());


    }

    @AfterClass
    public  void afterClass(){
       driver.quit();
    }
}
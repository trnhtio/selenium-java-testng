package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_Iframe {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Iframe() {
        driver.get("https://embedgooglemap.net/");

        // Switch to Iframe B
        driver.switchTo().frame(driver.findElement(By.cssSelector("div.gmap_canvas>iframe"))); //iframe 1
        //driver.switchTo().frame(driver.findElement(By.cssSelector("div#mapDiv>div>div>iframe"))); // iframe 2
        // driver.switchTo().frame(driver.findElement(By.cssSelector("div#mapDiv button iframe"))); // iframe 3
        //
        // Dang o IframeB
       String addressName = driver.findElement(By.cssSelector("div.place-name")).getText();
       System.out.println(addressName);

       //B chứa Iframe C

       //Switch vao Iframe C
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#mapDiv>div>div>iframe")));

        // Đang ở C
        System.out.println(driver.getPageSource());
        // Từ C quay lại B
        driver.switchTo().parentFrame();
        addressName = driver.findElement(By.cssSelector("div.place-name")).getText();
        System.out.println(addressName);

        //Tu B quay lai A
        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("input#s")).clear();
        driver.findElement(By.cssSelector("input#s")).sendKeys("Hanoi, Viet Nam");

    }

    @Test
    public void TC_02_FormSite() throws InterruptedException {
        // Truy cập site
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        Thread.sleep(3000);
        // Accept cookie
        driver.findElement(By.cssSelector("button.osano-cm-accept-all")).click();

        // click img to show form
        driver.findElement(By.cssSelector("div#imageTemplateContainer img")).click();
        Thread.sleep(3000);

        // switch vào frame
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));

        // Thao tác trong form
        new Select(driver.findElement(By.xpath("//label[contains(text(),'Year')]/following-sibling::select"))).selectByVisibleText("Sophomore");
        new Select(driver.findElement(By.xpath("//label[contains(text(),'Residence')]/following-sibling::select"))).selectByVisibleText("East Dorm");

        driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();
        Thread.sleep(3000);
        // Click submit button
        driver.findElement(By.cssSelector("input#FSsubmit")).click();

        //Thoát khỏi frame
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("nav[class='header header--desktop'] a.menu-item-login")).click();
        driver.findElement(By.cssSelector("button#login")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(),"Username and password are both required.");

    }

    @AfterClass
    public  void afterClass(){
       driver.quit();
    }
}
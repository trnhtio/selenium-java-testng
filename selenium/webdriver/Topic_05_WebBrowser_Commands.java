package webdriver;

import net.bytebuddy.matcher.InheritedAnnotationMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Topic_05_WebBrowser_Commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        // Tương tác với Browser thông qua biến driver

    }

    @Test
    public void TC_01_Browser() throws MalformedURLException {
        // mở ra URL bất kỳ
        driver.get("https://facebook.com");

        // Đóng browser - không quan tâm có bao nhiêu tab/ windows
        driver.quit();
        // nếu chỉ đóng 1 tab
        driver.close();

        //Tim 1 element voi locator la tham so truyen vao
        driver.findElements(By.cssSelector(""));


        //Lấy URL ở page hiện tại
        driver.getCurrentUrl();
        // Lay title o page hien tai
        driver.getTitle();
        // Lay ra window ID owr page hien tai
        driver.getWindowHandle();
        //Lay ra tat ca cac window ID cua cac tab/window
        driver.getWindowHandles();
        // Lay ra source code
        driver.getPageSource();

        //Alert-Frame/ iFrame-window/ Tab

        //Alert
        driver.switchTo().alert();

        //Frame/ iFrame
        //Switch vao frame/ iframe
        driver.switchTo().frame("");

        //Window - tab
       // driver.switchTo().window("");
        //driver.switchTo().newWindow(windownType.TAB).get("https://facebook.com");


        // set browser co kich thuoc bao nhie
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().window().getSize();

        //set browser tai vi tri
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().getPosition();

        // Selenium log: browser/server/dirver/network
        driver.manage().logs().get(LogType.BROWSER);
        driver.manage().logs().get(LogType.SERVER);
        driver.manage().logs().getAvailableLogTypes();

        // quay lai trang truoc do
        driver.navigate().back();

        // chuyen tiep den trang truoc do
        driver.navigate().forward();

        // Tai lai trang truoc do
        driver.navigate().refresh();


        // mo 1 url
        driver.navigate().to("https://facebook.com");
        driver.navigate().to(new URL("https://facebook.com"));

        driver.get("https://facebook.com");
        //
    }

    @Test
    public void TC_02_() {

    }

    @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_02_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_ID() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElements(By.id("txtSearch"));
    }

    @Test
    public void TC_02_Class() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.className("field_btn"));

    }
    @Test
    public void TC_03_Name() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.name("txtFirstname"));
        driver.findElement(By.name("txtEmail"));
        driver.findElement(By.name("txtCEmail"));
        driver.findElement(By.name("txtPassword"));
        driver.findElement(By.name("txtCPassword"));
        driver.findElement(By.name("txtPhone"));
        driver.findElement(By.name("chkRight"));

    }
    @Test
    public void TC_04_Link() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.linkText("Đăng Ký"));
        driver.findElement(By.linkText("Đăng Nhập"));


    }

    @Test
    public void TC_05_Partial_Link() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.partialLinkText("Ký"));
        driver.findElement(By.partialLinkText("Nhập"));
    }

    @Test
    public void TC_06_TagName() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Tìm nhiều element giống nhau
        int linkNumber = driver.findElements(By.tagName("a")).size();
        System.out.println("TagName_Total link = " + linkNumber);
        //
        }

    @Test
    public void TC_07_CSS() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //CSS vs ID
        driver.findElements(By.cssSelector("input[id='txtEmail']"));
        driver.findElements(By.cssSelector("#txtEmail"));
        driver.findElements(By.cssSelector("input#txtEmail"));

        //CSS vs Class

        driver.findElements(By.cssSelector("div[class='field_btn']"));
        driver.findElements(By.cssSelector("div.field_btn"));
        driver.findElements(By.cssSelector(".field_btn"));

        //CSS vs Name
        driver.findElements(By.cssSelector("input[name='txtEmail']"));

        //CSS vs Link
        driver.findElement(By.cssSelector("a[href^= 'https://alada.vn/tai-khoan/dang-ky.html']"));

        //CSS vs Partial link
        driver.findElement(By.cssSelector("a[href^= 'https://alada.vn']"));
        driver.findElement(By.cssSelector("a[href*= 'tai-khoan/']"));
        driver.findElement(By.cssSelector("a[href$= 'tai-khoan/dang-ky.html']"));

        //CSS vs TagName
        int linkNumber = driver.findElements(By.cssSelector("a")).size();
        System.out.println("CSS_Total link = " + linkNumber);
    }

    @Test
    public void TC_08_XPath() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //XPath vs ID
        driver.findElements(By.xpath("//input[@id='txtEmail']"));

        //XPath vs Class
        driver.findElements(By.xpath("//div[@class='field_btn']"));

        //XPath vs Name
        driver.findElements(By.xpath("//input[@name='txtEmail']"));

        //XPath vs Link
        driver.findElement(By.xpath("//a[@href= 'https://alada.vn/tai-khoan/dang-ky.html']"));
        driver.findElement(By.xpath("//a[text() = 'Đăng Ký']"));

        //XPath vs Partial link
        driver.findElement(By.xpath("//a[starts-with(@href,'https://alada.vn')]"));
        driver.findElement(By.xpath("//a[contains(@href,'tai-khoan/')]"));

        //Xpath không support
        //driver.findElement(By.xpath("//a[ends-with(@href,'https://alada.vn')]"));

        //XPath vs TagName
        int linkNumber = driver.findElements(By.xpath("//a")).size();
        System.out.println("XPath_Total link = " + linkNumber);
    }


    @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
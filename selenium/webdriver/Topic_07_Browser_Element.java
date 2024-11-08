package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_Browser_Element {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Page_Url() {
        driver.get("http://live.techpanda.org/");

        // Click vao My Account tai footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        // 1 Dung nhieu hon 2 lan -> khai bao bien
        //String loginPageURL= driver.getCurrentUrl();
       // Assert.assertEquals(loginPageURL,"http://live.techpanda.org/index.php/customer/account/login/");

        // 2 Dung 1 lan thi khong can khai bao
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");

        // Click chuyển qua trang register
        driver.findElement(By.xpath ("//a[@title='Create an Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");
    }

    @Test
    public void TC_02_getTitle() {
        driver.get("http://live.techpanda.org/");

        //Click footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        // Verify title của LoginPage
        Assert.assertEquals(driver.getTitle(),"Customer Login");
        //Click create an account
        driver.findElement(By.xpath ("//a[@title='Create an Account']")).click();
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");

    }

    @Test
    public void TC_03_Navigation() {
        driver.get("http://live.techpanda.org");

        //Click footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        // Verify title của LoginPage
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
        //Click create an account
        driver.findElement(By.xpath ("//a[@title='Create an Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");
        // Quay lại trang trước đó
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");

        //Chuyển tiếp về trang trươcs đó
        driver.navigate().forward();
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");

    }
    @Test
    public void TC_04_Page_Source(){
        driver.get("http://live.techpanda.org/");
        // Click My account tại footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        // Tuyệt đối = bằng nhau
        //Assert.assertEquals(driver.getPageSource(),"");
        //Tương đối
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
        // Chuyển qua trang register
        driver.findElement(By.xpath ("//a[@title='Create an Account']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));

    }


    @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
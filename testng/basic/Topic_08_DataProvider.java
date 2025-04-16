package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
// Data Driven Testing: có 1 testcase và cần chạy qua 1 bộ dữ liệu
// Cần tạo ra 1000 user(thông tin user được lưu vào file external/internal) vào hệ thống
// Run a test case multiple times with different input and validation values
public class Topic_08_DataProvider {
    WebDriver driver;
    By emailTextbox = By.cssSelector("input#email");
    By passwordTextbox = By.cssSelector("input#pass");
    By loginButton = By.cssSelector("button#send2");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "loginData")
    public void shouldBeLoginToSystem(String username, String password, String zipCode) {
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(emailTextbox).sendKeys(username);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains(username));

        // Mua Hàng

        // Thanh Toán

        // Ship Hàng

        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
    }

    @DataProvider(name = "loginData")
    public Object[][] UserAndPasswordData() {
        return new Object[][]{
                {"selenium_11_01@gmail.com", "111111", "65000"},
                {"selenium_11_02@gmail.com", "111111", "65000"},
                {"selenium_11_03@gmail.com", "111111", "65000"}
        };
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

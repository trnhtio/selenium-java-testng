package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_04_Register {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        // Arrange
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Register_01_Empty_data() {
        // Action 1
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        // Action 2
        driver.findElement(By.xpath("//form[@id='frmLogin']//button[text='ĐĂNG KÝ']")).click();

        // Assert 1

    }

    @Test
    public void Register_02_Invalid_Email() {

    }

    @Test
    public void Register_03_Incorrect_Confirm_Email() {

    }


    @Test
    public void Register_04_Incorrect_Password() {

    }

    @Test
    public void Register_05_Incorrect_Confirm_Password() {

    }

    @Test
    public void Register_06_Invalid_PhoneNumber() {

    }



    @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
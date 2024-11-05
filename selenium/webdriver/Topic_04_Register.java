package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
        driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();

        // Acction 3 Check error msg
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");
    }

    @Test
    public void Register_02_Invalid_Email() {

        // Action1
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action2 : Nhập thông tin
        driver.findElement(By.name("txtFirstname")).sendKeys("To Trinh");
        driver.findElement(By.name("txtEmail")).sendKeys("trinhtt2.@..");
        driver.findElement(By.name("txtCEmail")).sendKeys("trinhtt2.@..");
        driver.findElement(By.name("txtPassword")).sendKeys("Aa@123456");
        driver.findElement(By.name("txtCPassword")).sendKeys("Aa@123456");
        driver.findElement(By.name("txtPhone")).sendKeys("0123456789");

        // Action 3: Click button đăng ký
        driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();

        // Action 4: Check error message
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
    }

    @Test
    public void Register_03_Incorrect_Confirm_Email() {
        // Action1
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action2 : Nhập thông tin
        driver.findElement(By.name("txtFirstname")).sendKeys("To Trinh");
        driver.findElement(By.name("txtEmail")).sendKeys("trinhtt2.vng@gmail.com");
        driver.findElement(By.name("txtCEmail")).sendKeys("trinhtt3.vng@gmail.com");
        driver.findElement(By.name("txtPassword")).sendKeys("Aa@123456");
        driver.findElement(By.name("txtCPassword")).sendKeys("Aa123456");
        driver.findElement(By.name("txtPhone")).sendKeys("0123456789");

        // Action 3: Click button đăng ký
        driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();

        // Action 4: Check error message
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");

    }
    @Test
    public void Register_04_Incorrect_Password() {
            // Action1
            driver.get("https://alada.vn/tai-khoan/dang-ky.html");

            //Action2 : Nhập thông tin
            driver.findElement(By.name("txtFirstname")).sendKeys("To Trinh");
            driver.findElement(By.name("txtEmail")).sendKeys("trinhtt2.vng@gmail.com");
            driver.findElement(By.name("txtCEmail")).sendKeys("trinhtt2.vng@gmail.com");
            driver.findElement(By.name("txtPassword")).sendKeys("1234");
            driver.findElement(By.name("txtCPassword")).sendKeys("1234");
            driver.findElement(By.name("txtPhone")).sendKeys("0123456789");

            // Action 3: Click button đăng ký
            driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();

            // Action 4: Check error message
            Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");

    }

    @Test
    public void Register_05_Incorrect_Confirm_Password() {
        // Action1
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action2 : Nhập thông tin
        driver.findElement(By.name("txtFirstname")).sendKeys("To Trinh");
        driver.findElement(By.name("txtEmail")).sendKeys("trinhtt2.vng@gmail.com");
        driver.findElement(By.name("txtCEmail")).sendKeys("trinhtt2.vng@gmail.com");
        driver.findElement(By.name("txtPassword")).sendKeys("Aa@123456");
        driver.findElement(By.name("txtCPassword")).sendKeys("Aa123456");
        driver.findElement(By.name("txtPhone")).sendKeys("0123456789");

        // Action 3: Click button đăng ký
        driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();

        // Action 4: Check error message
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");

    }

    @Test
    public void Register_06_Invalid_PhoneNumber() {

        // Action1
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action2 : Nhập thông tin
        driver.findElement(By.name("txtFirstname")).sendKeys("To Trinh");
        driver.findElement(By.name("txtEmail")).sendKeys("trinhtt2.vng@gmail.com");
        driver.findElement(By.name("txtCEmail")).sendKeys("trinhtt2.vng@gmail.com");
        driver.findElement(By.name("txtPassword")).sendKeys("Aa@123456");
        driver.findElement(By.name("txtCPassword")).sendKeys("Aa@123456");

        //Case1: < 10 số
        driver.findElement(By.name("txtPhone")).sendKeys("01234");
        driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        //Case2: >11 số
        driver.findElement(By.name("txtPhone")).clear();
        driver.findElement(By.name("txtPhone")).sendKeys("012345678909");
        driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        //Case 3: Có chứa text
        driver.findElement(By.name("txtPhone")).clear();
        driver.findElement(By.name("txtPhone")).sendKeys("01234567x78");
        driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập con số");

        //Case 4: Không start = 0xxx
        driver.findElement(By.name("txtPhone")).clear();
        driver.findElement(By.name("txtPhone")).sendKeys("12341234567");
        driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
    }



    @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
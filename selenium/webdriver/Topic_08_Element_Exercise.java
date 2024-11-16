package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_08_Element_Exercise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().setSize(new Dimension(1366,768));
    }

    @Test
    public void TC_01_Displayed() {
        // truy cập vào trang
        driver.get("https://automationfc.github.io/basic-form/index.html");

        // Kiểm tra các phần tử hiển thị trên trang + có hiển thị thì nhập giá trị  "Automation testing" vào Email
        // Nếu không hiển thị in ra không hiển thị
        // Email
        if (driver.findElement(By.cssSelector("input#mail")).isDisplayed()){
            driver.findElement(By.cssSelector("input#mail")).sendKeys("Automation Testing");
            System.out.println("Email is displayed");
        } else {
            System.out.println("Email is NOT displayed");
        }
        // Age (under 18)
        if (driver.findElement(By.cssSelector("input#under_18")).isDisplayed()){
            driver.findElement(By.cssSelector("input#under_18")).click();
            System.out.println("Age under 18 is displayed");
        } else {
            System.out.println("Age under 18 is NOT displayed");
        }
        //Education
        if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()){
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("Automation Testing");
            System.out.println("Education is displayed");
        } else {
            System.out.println("Education is NOT displayed");
        }
        // Kiểm tra phần tử "Name: User5" không hiển thị trên trang
        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()){
            driver.findElement(By.xpath("//h5[text()='Name: User5']/following-sibling::a")).click();
            System.out.println("Name user5 is displayed");
        } else {
            System.out.println("Name user5 is NOT displayed");
        }
    }

    @Test
    public void TC_02_Enabled() {
        // Truy cập vào trang https://automationfc.github.io/basic-form/index.html
        driver.get("https://automationfc.github.io/basic-form/index.html");

        // Kiểm tra các phần tử sau enable trên trang
        // Email/Age (under18)/ Education/ Job role 01/ Job role02/ Interests (development) checkbox/ Slider01
        if (driver.findElement(By.cssSelector("input#mail")).isEnabled()){
            System.out.println("Email is enabled");
        } else{
            System.out.println("Email is disabled");
        }
        if (driver.findElement(By.cssSelector("input#under_18")).isEnabled()){
            System.out.println("Age under 18 is enabled");
        } else {
            System.out.println("Age under 18 is disabled");
        }
        if (driver.findElement(By.cssSelector("textarea#edu")).isEnabled()){
            System.out.println("Education is enabled");
        } else {
            System.out.println("Education is disabled");
        }
        if (driver.findElement(By.cssSelector("select#job1")).isEnabled()){
            System.out.println("Job role 01 is enabled");
        } else {
            System.out.println("Job role 01 is disabled");
        }
        //Kiểm tra các phần tử sau disable : slider 02
        if (driver.findElement(By.cssSelector("input#slider-2")).isEnabled()){
            System.out.println("Slider2 is enabled");
        } else {
            System.out.println("Slider is disabled");
        }

    }
    @Test
    public void TC_03_Selected() {
        // Truy cập vào trang
        driver.get("https://automationfc.github.io/basic-form/index.html");
        // Click chọn "Age under 18 radio" và Language Java checkbox -> in ra log có hiển thị trên trang hay không
        // Age
        driver.findElement(By.cssSelector("input#under_18")).click();
        if (driver.findElement(By.cssSelector("input#under_18")).isSelected()){
            System.out.println("Age under 18 is selected");
        } else {
            System.out.println("Age under 18 is deselected");
        }
        // Java
        driver.findElement(By.cssSelector("input#java")).click();
        if (driver.findElement(By.cssSelector("input#java")).isSelected()){
            System.out.println("Java is selected");
        } else {
            System.out.println("Java is deselected");
        }
        // Click chọn lần nữa
        driver.findElement(By.cssSelector("input#under_18")).click();
        driver.findElement(By.cssSelector("input#java")).click();

        if (driver.findElement(By.cssSelector("input#under_18")).isSelected()){
            System.out.println("Age under 18 is selected");
        } else {
            System.out.println("Age under 18 is deselected");
        }
        // Java
        if (driver.findElement(By.cssSelector("input#java")).isSelected()){
            System.out.println("Java is selected");
        } else {
            System.out.println("Java is deselected");
        }

    }
    @Test
    public void TC_04_Register() throws InterruptedException {
        // Truy cập vào trang
        driver.get("https://login.mailchimp.com/signup/");

        By signUpButton = By.cssSelector("button#create-account-enabled");
        //Nhập dữ liệu valid vào email (userName tự động lấy data Email truyền qua)
        driver.findElement(By.cssSelector("input#email")).sendKeys("kaitoKID123@gmail.com");

        // Nhập dữ liệu check validate Password (các dòng text sẽ green khi nhập valid"
        // Null
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signUpButton));
        driver.findElement(signUpButton).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());

        // Number
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("123");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signUpButton));
        driver.findElement(signUpButton).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());

        // lower letter
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("kaito");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signUpButton));
        driver.findElement(signUpButton).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        // uppercase letter
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("KID");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signUpButton));
        driver.findElement(signUpButton).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());

        // special
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("@@@@@");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signUpButton));
        driver.findElement(signUpButton).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        // more than 8 characters
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("12345678");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signUpButton));
        driver.findElement(signUpButton).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        // username check
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("Tt@1234");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(signUpButton));
        driver.findElement(signUpButton).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
    }


   @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
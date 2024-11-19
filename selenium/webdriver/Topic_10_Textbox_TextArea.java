package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_10_Textbox_TextArea {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_TechPanda() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        String firstName = "Trinh";
        String lastName = "To";
        String fullName = firstName +" "+lastName;
        String emailAddress = "trinhtt2"+ new Random().nextInt(9999) + "@gmail.com";
        String password = "Tt@123456";
        String thoughtReview = "Best phone\n" + "Best provider\n" + "1234";
        String summaryReview = "Love it\n" + "Good\n" + "1234";
        String nickName = "ttt2";

        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("email_address")).sendKeys(emailAddress);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmation")).sendKeys(password);

        driver.findElement(By.cssSelector("button[title='Register']")).click();

        Assert.assertEquals(driver.findElement(
                By.cssSelector("li.success-msg span")).getText(),
                "Thank you for registering with Main Website Store.");

        String contactInformation = driver.findElement(
                By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        Assert.assertTrue(contactInformation.contains(fullName));
        Assert.assertTrue(contactInformation.contains(emailAddress));

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();

        driver.findElement(By.cssSelector("input[id='Quality 1_5']")).click();
        driver.findElement(By.cssSelector("textarea#review_field")).sendKeys(thoughtReview);
        driver.findElement(By.cssSelector("input#summary_field")).sendKeys(summaryReview);
        driver.findElement(By.cssSelector("input#nickname_field")).sendKeys(nickName);

        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();
        Assert.assertEquals(driver.findElement(
                By.cssSelector("li.success-msg span")).getText(),
                "Your review has been accepted for moderation.");

    }

    @Test
    public void TC_02_OrangeHM() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //Khai báo các biến dùng nhiều lần
        String firstName = "Trinh";
        String lastName = "Tô";
        String userName = "Tô Trinh" + new Random().nextInt(9999);
        String password = "Tt@123456";
        String passportNumber = "123-123-123";
        String passportComment = "abcd\n" + "efgh";

        // Loading: Nếu vẫn còn loading thì dữ liệu chưa được load xong
        // Login Admmin/ admin123
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password'")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[contains(string(), 'Login')]")).click();
        Thread.sleep(5000);

        // Mở trang PIM
        //span[text()='PIM']/parent::a : tăng vào click vào thẻ span
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Thread.sleep(3000);
        // Mở trang Add employee
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        Thread.sleep(5000);
        // Nhập thông tin hợp lệ vào textbox FirstName/ LastName
        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[name='lastName'")).sendKeys(lastName);

        // lấy thông tin employee ID
        String employeeID = driver.findElement
                        (By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value");

        //Click create login detail
        driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div/label")).click();


        //Nhập thông tin vào username/password/confirm password
        driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys(userName);
        driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys(password);

        // Click Save button
        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Thread.sleep(8000);

        // Verify dữ liệu đã nhập ở Add Employee đúng với personal detail đã nhập
            // input[name='firstName'] -> dùng assertEqual.getAtribute()
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getAttribute("value"), firstName );
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getAttribute("value"), lastName );
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"), employeeID );

        // Click vào tab Immigration
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();

        // Click Add tại Assigned Immigration Records
        driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button[contains(string(),'Add')]")).click();

        //Nhập dữ liệu vào Number/ Comments và click Save
            //label[text()='Number']/parent::div/following-sibling::div/input
        driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(passportNumber);
        driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).sendKeys(passportComment);
        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();

        // Click vào icon Pencil (edit)
        driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
        Thread.sleep(5000);
        // Verify dữ liệu đã tạo hiển thị đúng
            // AssertEquals -> getAttribute
        Assert.assertEquals(driver.findElement(By.xpath(
                "//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"), passportNumber);
        Assert.assertEquals(driver.findElement(By.xpath(
                "//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), passportComment);

        // Click vào tên User và chọn Logout
            //p.oxd-userdropdown-icon
        driver.findElement(By.cssSelector("p.oxd-userdropdown-name")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        Thread.sleep(5000);
        // Login again
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[name='password'")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(string(), 'Login')]")).click();
        Thread.sleep(5000);
        // Vào màn hình My Info
        driver.findElement(By.xpath("//span[text()='My Info']")).click();
        Thread.sleep(5000);
        //Verify thông tin đúng FirstName/LastName/EmployeeID
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getAttribute("value"), firstName );
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getAttribute("value"), lastName );
        Assert.assertEquals(driver.findElement(By.xpath(
                "//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"), employeeID );
        // Kiểm tra employeeID disable -> dùng assertFalse
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).isEnabled());

        //Vào Immigration -> click Edit (pencil)
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Thread.sleep(3000);

        // Click vào icon Pencil (edit)
        driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
        Thread.sleep(5000);

        // Verify thông tin hiển thị đúng
        Assert.assertEquals(driver.findElement(By.xpath(
                "//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"), passportNumber);
        Assert.assertEquals(driver.findElement(By.xpath(
                "//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), passportComment);

    }

    @AfterClass
    public  void afterClass(){
      driver.quit();
   }
}
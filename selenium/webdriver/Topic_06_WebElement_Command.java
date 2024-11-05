package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06_WebElement_Command {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Element() {
        // Tương tác trực tiếp lên
        driver.findElements(By.cssSelector(""));

        // Thao tác nhiều lần lên 1 element -> khai báo biến
        WebElement element = driver.findElement(By.cssSelector("input#firstname"));

        //Xoá dữ liệu ở trong 1 editable element (nhập)
        //Textbox/ TextArea/ Dropdown

        element.clear();
        // Nhập dữ liệu vào 1 editable elemennt
        element.sendKeys("");

        //1- Element cha dùng 1 loại locator - element con 1 loại locator
        //driver.findElements(By.cssSelector("div.form-fields"))
        //        .findElement(By.xpath("//input[@id='FirstName]"));

        //2 - cả cha vs con đều chung 1 loại locator
        driver.findElements(By.cssSelector(""));

        //Click lên clickable element
        element.click();

        //Tương đương với submit thông tin để gửi lên server
        //Giả lập Enter
        //Register/Login/Search
        element.submit();

        //Verify thông tin/ dữ liệu đã action

        //Kiểm tra 1 element có hiển thị hay không
        // Áp dụng cho tất cả các loại element
        element.isDisplayed();

        //Kiểm tra 1 element đã được chọn hay chưa
        // Áp dụng: checkbox/ radio/ dropdown
        element.isSelected();

        element.isEnabled();

        //take screenshot
        element.getScreenshotAs(OutputType.FILE);
        element.getScreenshotAs(OutputType.BYTES);
        element.getScreenshotAs(OutputType.BASE64);

    }

    @Test
    public void TC_02_() {

    }

    @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_24_wait_II_findElement {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");
    }

    @Test
    public void TC_01_find_Element() {

        // Tìm thấy 0 element
        // Vào không tìm thấy emlement và sẽ tìm đi tìm lại mỗi 0.5s/lần cho đến khi hết timeout của implicitWait (10s đã set)
        // Đánh fail test case tại vị trí này và show lỗi "NoSuchElementException"
        driver.findElement(By.cssSelector("input#emailAddress"));

        // Tìm thấy 1 element
        // Vào sẽ tìm element ngay chứ không chờ hết timeout của implicitWait
        //driver.findElement(By.cssSelector("input#email"));

        // Tìm thấy nhiều element
        // Lấy element được tìm thấy đầu tiên
        //driver.findElement(By.cssSelector("input:not([type=hidden])")).sendKeys("trinhtt2");

    }

    @Test
    public void TC_02_find_Elements() {

        List<WebElement> elementList = driver.findElements(By.cssSelector("input:not([type=hidden])"));
        System.out.println(elementList.size());

        //Thao tac voi List
        //elementList.get(1).sendKeys("ttt2");

        for (WebElement element: elementList){
            element.sendKeys("ttt2");
        }

    }

    @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
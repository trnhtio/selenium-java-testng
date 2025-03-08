package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_24_wait_I_elementStatus {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_visible() throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(5000);
        // đk1: Element có hiển thị trên UI và có trong cây HTML
        // Nếu 1 element thoả mãn điều kiện số 1: element đó gọi là hiển thị (visible/displayed)
        // Vì có trên UI thì 100% phải có trong html

        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();
        //Cho cho element hien thi
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='tel']")));

    }

    @Test
    public void TC_02_Invisible_HTML() throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        // Khong hien thi tren UI- có trong HTML
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#header-account a[title='My Account']")));
    }

    @Test
    public void TC_02_Invisible_Not_HTML() throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();

        driver.findElement(By.cssSelector("p.login-with-email")).click();

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input[name='tel']")));

    }
    @Test
    public void TC_03_present() throws InterruptedException {
        driver.get("https://live.techpanda.org/");

        // condition 1: element is displayed in UI and HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.footer a[title='My Account']")));

        // condition2: email is NOT displayed in UI but in HTML
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#header-account a[title='My Account']")));


    }

    @Test
    public void TC_04_Staleness_01() throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(5000);
        // ĐK 3: element không hiển thị trên UI và không có trong HTML
        // Điều kiện cần = visible not in HTML
        // Điều kiện đủ = element tại thời điểm A có trong HTML (present) và sau đó dùng element kiểm tra tại thời điểm B thì không còn

        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();

        //Phone textbox có xuất hiện trong HTML
        WebElement phoneTextbox = driver.findElement(By.cssSelector("input[name='tel']"));

        driver.findElement(By.cssSelector("p.login-with-email")).click();

        // tới đây đã chuyển qua email -> phone không còn xuất hiện trên UI + HTML -> wait staleness là đúng
        explicitWait.until(ExpectedConditions.stalenessOf(phoneTextbox));
    }

    @Test
    public void TC_04_Staleness_02() throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(5000);
        // ĐK 3: element không hiển thị trên UI và không có trong HTML
        // Điều kiện cần = visible not in HTML
        // Điều kiện đủ = element tại thời điểm A có trong HTML (present) và sau đó dùng element kiểm tra tại thời điểm B thì không còn

        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();

        driver.findElement(By.cssSelector("p.login-with-email")).click();

        // tới đây đã chuyển qua email -> phone không còn xuất hiện trên UI + HTML -> SAI - Không phù hợp với waitStaleness
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("input[name='tel']"))));
    }

    @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_19_Shadow_DOM {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Github() {
        driver.get("https://automationfc.github.io/shadow-dom/");

        // element khong nam trong shadow
        String scrollText = driver.findElement(By.xpath("//a[@href='scroll.html']")).getText();
        System.out.println(scrollText);

        // element nam trong shadow
        // Tìm ra element chứa Shadow dau tien
        WebElement firstShadowHostElement = driver.findElement(By.xpath("//div[@id='shadow_host']"));
        // Lấy ra cái shadow
        SearchContext firstShadowRoot = firstShadowHostElement.getShadowRoot();
        // shadow khong dung xPath + khong quet locator tu ben ngoai shadow
        String shadowText = firstShadowRoot.findElement(By.cssSelector("a")).getText();
        System.out.println(shadowText);

        firstShadowRoot.findElement(By.cssSelector("input[type='text']")).sendKeys("selenium");

        System.out.println(firstShadowRoot.findElement(By.cssSelector("span#shadow_content>span")).getText());

        // lấy ra cái element chua shadow thứ 2 (nằm trong shadow đầu tiên)
        WebElement secondShadowHostElement = firstShadowRoot.findElement(By.cssSelector("div#nested_shadow_host"));

        // lay shadow 2 nam trong shadow 1
        SearchContext secondShadowRoot = secondShadowHostElement.getShadowRoot();

        // lay text ra
        secondShadowRoot.findElement(By.cssSelector("div#nested_shadow_content>div")).getText();
        System.out.println(secondShadowRoot);

    }

    @Test
    public void TC_02_AppSpot() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");
        Thread.sleep(5000);

        WebElement firstShadowHostElement = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
        SearchContext firstShadowRoot = firstShadowHostElement.getShadowRoot();

        firstShadowRoot.findElement(By.cssSelector("input#input")).sendKeys("Harry Potter");
        Thread.sleep(3000);


        WebElement secondShadowHostElement = firstShadowRoot.findElement(By.cssSelector("app-toolbar>book-input-decorator"));
        SearchContext secondShadowRoot = secondShadowHostElement.getShadowRoot();


        secondShadowRoot.findElement(By.cssSelector("div.icon")).click();
        Thread.sleep(3000);

        WebElement thirdShadowHostElement = firstShadowRoot.findElement(By.cssSelector("main.main-content>book-explore"));
        SearchContext thirdShadowRoot = thirdShadowHostElement.getShadowRoot();

        List<WebElement> forthShadowHostElements = thirdShadowRoot.findElements(By.cssSelector("ul.books>li>book-item"));

        for (WebElement element : forthShadowHostElements){
            SearchContext shadowRoot = element.getShadowRoot();
            System.out.println(shadowRoot.findElement(By.cssSelector("div.title-container>h2")).getText());
        }


    }

    @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
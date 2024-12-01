package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Custom_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_jqueryUI() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        // gọi hàm - chọn all -> extract -> method
        // Dropdown Salutation
        selectItemInDropdown("span#salutation-button","ul#salutation-menu div","Dr.");
        selectItemInDropdown("span#salutation-button","ul#salutation-menu div","Mrs.");
        selectItemInDropdown("span#salutation-button","ul#salutation-menu div","Prof.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(),"Prof.");

        // Speed
        selectItemInDropdown("span#speed-button","ul#speed-menu div","Slow");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(),"Slow");
        //File
        //selectItemInDropdown("span#files-button","ul#speed-menu div","ui.jQuery.js");
        //Number
        //selectItemInDropdown("span#number-button","ul#number-menu div","16");
    }
    @Test
    public void TC_02_React_Semantic() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInDropdown("div.dropdown","div.item>span.text","Jenny Hess");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Jenny Hess");
    }

    @Test
    public void TC_03_VueJS() throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInDropdown("li.dropdown-toggle","ul.dropdown-menu>li","Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Second Option");

    }
    // Viết hàm
    // hàm dùng chung cho nhiều dropdown

    private void selectItemInDropdown(String parentLocator, String childLocator, String textItem) throws InterruptedException {
        driver.findElement(By.cssSelector(parentLocator)).click();
        Thread.sleep(2000);
        // Wait explicit
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));

        // Tìm và lấy ra all items và lưu vào 1 biến
        List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));
        //Duyệt từng element và kiểm tra
        for (WebElement item : allItems) {
            if (item.getText().equals(textItem)){
                item.click();
                Thread.sleep(1500);
                break;
            }
        }
    }

    // Wait explicit
        // List <Element>
        // Vòng lặp for
        // Điều kiện if
        // Câu lệnh : break
        // Viết hàm (reusable function)
        // Tham số truyền vào (parameter)

    @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
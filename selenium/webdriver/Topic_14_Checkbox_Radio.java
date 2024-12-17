package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_14_Checkbox_Radio {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_KendoUI_checkbox() throws InterruptedException {

        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");

        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@id='demo-runner']")));
        Thread.sleep(2000);
        // Click chọn Dual-zone air conditioning
        // Nếu element chưa được chọn thì click
        // Nếu chọn rồi thì không cần click nữa
        if (!driver.findElement(dualZoneCheckbox).isSelected()){
            driver.findElement(dualZoneCheckbox).click();
            Thread.sleep(2000);
        }
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());
        // Sau khi checkbox đã được chọn thì bỏ chọn
        // Verify nó chưa được chọn
        if (driver.findElement(dualZoneCheckbox).isSelected()){
         driver.findElement(dualZoneCheckbox).click();
         Thread.sleep(2000);
        }
       Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());
    }

    @Test
    public void TC_02_KendoUI_Radio() throws InterruptedException {

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        // Click vào radio 2.0 petro, 147kW

        By TwoPetrol = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@id='demo-runner']")));
        Thread.sleep(2000);
        //Kiểm tra radio đã chọn chưa/ nếu chưa chọn lại
        if (!driver.findElement(TwoPetrol).isSelected()){
            driver.findElement(TwoPetrol).click();
            Thread.sleep(2000);
        }
        Assert.assertTrue(driver.findElement(TwoPetrol).isSelected());
    }

    @Test
    public void TC_03_Material_Radio() throws InterruptedException {
        driver.get("https://material.angular.io/components/radio/examples");
        // click vào radio button "Summer"
        By MaterialRadio = By.xpath("//input[@id='mat-radio-2-input']");
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("div[class='docs-example-viewer-body ng-star-inserted']")));
        Thread.sleep(1000);
        //Kiểm tra radio đã chọn chưa - nếu chưa chọn lại
        if (!driver.findElement(MaterialRadio).isSelected()) {
            driver.findElement(MaterialRadio).click();
            Thread.sleep(1500);
        }
        Assert.assertTrue(driver.findElement(MaterialRadio).isSelected());
    }

    @Test
    public void TC_04_Material_Checkbox() throws InterruptedException {
        //Truy cập trang
        driver.get("https://material.angular.io/components/checkbox/examples");
        //Check vào checkbox Checked + Indeterminate
        By Checked = By.xpath("//input[@id='mat-mdc-checkbox-0-input']");

        if (!driver.findElement(Checked).isSelected()){
            driver.findElement(Checked).click();
            Thread.sleep(2000);
        }
        Assert.assertTrue(driver.findElement(Checked).isSelected());
        //Indeterminate
        By Indeterminate = By.xpath("//input[@id='mat-mdc-checkbox-1-input']");

        if (!driver.findElement(Indeterminate).isSelected()){
            driver.findElement(Indeterminate).click();
            Thread.sleep(2000);
        }
        Assert.assertTrue(driver.findElement(Indeterminate).isSelected());
        // Bỏ chọn - kiểm tra bỏ chọn

        if (driver.findElement(Checked).isSelected()){
            driver.findElement(Checked).click();
            Thread.sleep(2000);
        }
        Assert.assertFalse(driver.findElement(Checked).isSelected());

        if (driver.findElement(Indeterminate).isSelected()){
            driver.findElement(Indeterminate).click();
            Thread.sleep(2000);
        }
        Assert.assertFalse(driver.findElement(Indeterminate).isSelected());

    }
    @Test
    public void TC_05_Select_All() throws InterruptedException {
        driver.get("https://automationfc.github.io/multiple-fields/");
        Thread.sleep(3000);
        // Chọn hết checkbox
        // Kiểm tra checkbox đã được chọn div.form-single-column input[type='checkbox']
        // Select/deselect 1 item = Heart Attack
        //Verify các điều kiện trên

        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));

        for (WebElement checkbox : allCheckboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
        //Verify
        for (WebElement checkbox : allCheckboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }
        // De-select all
        for (WebElement checkbox : allCheckboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
        //Verify bỏ chọn all
        for (WebElement checkbox : allCheckboxes) {
            Assert.assertFalse(checkbox.isSelected());
        }
        // Chỉ chọn 1
        for (WebElement checkbox : allCheckboxes){
            if (checkbox.getDomAttribute("value").equals("Fainting Spells") && !checkbox.isSelected()){
                checkbox.click();
            }
        }
        for (WebElement checkbox : allCheckboxes){
            if (checkbox.getDomAttribute("value").equals("Fainting Spells")){
                Assert.assertTrue(checkbox.isSelected());
            }
        }
    }

    @AfterClass
    public  void afterClass(){
        driver.quit();
    }
}
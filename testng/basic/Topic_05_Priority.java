package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_05_Priority {
    // Arrange
    // Setup/ initial data/ Browser/ Driver/ Variable/ DB/...

    // Action
    @Test
    public void TM_01_register() {
        System.out.println("Register new account");

        // ----------------Action----------------
        // open page

        // fill data

        // Submit

        // ----------------Assert----------------
        // Verify success message

    }
    @Test(priority = 1)
    public void TM_02_login() {
        System.out.println("Login to system");

    }
    @Test(priority = 2)
    public void TM_03_order() {
        System.out.println("Order product");

    }
    @Test(priority = 3)
    public void TM_04_pay() {
        System.out.println("Pay product");

    }
    @Test(priority = 4)
    public void TM_05_ship() {
        System.out.println("Ship product");

    }
}
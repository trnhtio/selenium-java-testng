package basic;

import org.testng.annotations.Test;

public class Topic_06_Skip {
    // Arrange
    // Setup/ initial data/ Browser/ Driver/ Variable/ DB/...

    // Action
    @Test
    public void TM_01_register() {
        System.out.println("Register new account");

    }
    @Test
    public void TM_02_login() {
        System.out.println("Login to system");

    }
    //Nếu muốn skip test case nào thì enable = false hoặc comment annotations lại
    @Test(enabled = false)
    public void TM_03_order() {
        System.out.println("Order product");

    }
//    @Test
    public void TM_04_pay() {
        System.out.println("Pay product");

    }
    @Test(enabled = false)
    public void TM_05_ship() {
        System.out.println("Ship product");

    }
}
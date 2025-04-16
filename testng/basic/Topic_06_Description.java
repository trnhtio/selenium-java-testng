package basic;

import org.testng.annotations.Test;

public class Topic_06_Description {
    // Cung cấp thêm thông tin cho team member/non-tech
    // Cung cấp thông tin cho chính bản thân để sau ni đọc lại/ nắm business
    // Liên kết 1 ID/Ticket của một hệ thống quản lý testcase/ document
    // Hiển thị thông tin trong report

    // Action
    @Test(description = "Azure#9948 - Register new account")
    public void TM_01_register() {
        System.out.println("Register new account");

    }
    @Test(description = "Azure#1234 - login to system and verify account is created success ")
    public void TM_02_login() {
        System.out.println("Login to system");

    }
    @Test
    public void TM_03_order() {
        System.out.println("Order product");

    }
    @Test
    public void TM_04_pay() {
        System.out.println("Pay product");

    }
    @Test
    public void TM_05_ship() {
        System.out.println("Ship product");

    }
}
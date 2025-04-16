package basic;

import org.testng.annotations.*;

public class Topic_01_Annotations {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @Test
    public void TC_01(){
        System.out.println("Test method 01");
    }
    @Test
    public void TC_02(){
        System.out.println("Test method 02");
    }
    @Test
    public void TC_03(){
        System.out.println("Test method 03");
    }
}

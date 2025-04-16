package platformWeb;

import org.testng.annotations.*;

public class Web_01_User {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");

    }

    @Test(groups = {"platformWeb", "User"})
    public void TC_01_CreateNewUser(){

    }
    @Test(groups = {"platformWeb", "User"})
    public void TC_02_EditUser(){

    }
    @Test(groups = {"platformWeb", "User"})
    public void TC_03_ViewUser(){

    }
    @Test(groups = {"platformWeb", "User"})
    public void TC_04_DelUser(){

    }


   @AfterClass
    public void afterClass(){
        System.out.println("After Class");

    }
}

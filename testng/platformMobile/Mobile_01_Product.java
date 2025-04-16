package platformMobile;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Mobile_01_Product {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");

    }

    @Test(groups = {"platformMobile", "Product"})
    public void TC_01_CreateNewProduct(){

    }
    @Test(groups = {"platformMobile", "Product"})
    public void TC_02_EditProduct(){

    }
    @Test(groups = {"platformMobile", "Product"})
    public void TC_03_ViewProduct(){

    }
    @Test(groups = {"platformMobile", "Product"})
    public void TC_04_DelProduct(){

    }


   @AfterClass
    public void afterClass(){
        System.out.println("After Class");

    }
}

package basic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_02_Assert {
    @Test
    public void login(){
        //Nếu như trong 1 tc chỉ có thực hiện action click/select/sendkey/getText/... thì không biết được là tc đó chạy đúng hay sai
        // assertTrue - kiểm tra 1 điều kiện đúng
        // assertFalse - Kiểm tra 1 điều kiện sai
        Assert.assertTrue(5 > 3);

        boolean status = 5 < 3;
        System.out.println(status);
        Assert.assertFalse(status);
        // assertEquals - Kiểm tra 2 điều kiện bằng nhau
        String studentName = "Dang Thuy Tram";
        Assert.assertEquals(studentName,"Dang Thuy Tram");

        Object name = "Dang Thuy Tram";
        Assert.assertEquals(studentName,name);

        int iNumber = 15;
        float fNumber = 15;
        String sNum = "15";
        Assert.assertEquals(iNumber,fNumber);
        // assertNOTQuals - Kiểm tra 2 điều kiện không bằng nhau
        // assertNull
        // assertNotNull
    }
}

package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class Topic_01_DataType {

    // Java có 2 nhóm kiểu dữ liệu
    // 1 - Kiểu dữ liệu nguyên thuỷ (Primitive Type)
    // 8 kiểu đại diện (chia ra gồm 4 nhóm)
    // Kiểu ký tự (đại diện cho 1 ký tự)
    char c = '9';

    // Kiểu số nguyên (không có thập phân)
    byte bNumber = 11;
    short sNumber = 100;
    int iNumber = 90000;
    long lNumber = 1000000000;

    // Kiểu số thực (có thập phân)
    float fNumber = 19.9f;
    double dNumber = 19.9d;

    //kiểu logic
    boolean sex = true;

    // 2- Kiểu dữ liệu tham chiếu (Reference Type)
    // Kiểu mảng (Array)
    // Mảng kiểu String
    String[] studentName = {"Tô Trinh", "Tô Trinh 1", "Tô Trinh 2"};
    int[] studentAge = {20,22, 28};

    // Kiểu Object )đại diện cho các kiểu dữ liệu khác)
    // Đối tượng => Chuyển đổi qua các dữ liệu khác
    Object studentAddress = "123 location";
    Object employeeAge = 28;
    Object employeeSex = false;

    // Kiểu chuỗi (String)
    String name = "Tô Trinh";
    String employeeNumber = "123";

    // Class/ Interface/ Collection
    FirefoxDriver ffDriver = new FirefoxDriver();
    // public class FirefoxDriver

    // Interface
    WebDriver driver = new ChromeDriver();
    // public interface webDriver

    // Collection
    List<WebElement> textboxes = driver.findElements(By.cssSelector(""));
    ArrayList<String> studentCity = new ArrayList<String>();

}

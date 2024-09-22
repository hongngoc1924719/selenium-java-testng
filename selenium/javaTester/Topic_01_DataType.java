package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class Topic_01_DataType {
    // 1 kiểu dữ liệu sẽ được sử dụng cho 1 thông tin/ thuộc tính nào đó
    // Mỗi ngôn ngữ lập trình sẽ có quy ước các kiểu dữ liệu khác nhau

    // Java có 2 nhóm kiểu dữ liệu
    // 1 - Kiểu dữ liệu nguyên thủy (Primitive Type)
    // 8 kiểu đại diện (chia ra gồm 4 nhóm)
    // kiểu kí tự (đại diện cho 1 kí tự)
    char c = 'N';

    // kiểu số nguyên (ko có thập phân)
    byte bNumber = 9;
    short sNumber = 1000;
    int iNumber = 10000;
    long lNumber = 1000000;

    // kiểu số thực (có thập phân)
    float fNumber = 16.8f;
    double dNumber = 12.3d;

    // kiểu logic
    boolean yes_no = true;

    // 2 - Kiểu dữ liệu tham chiếu ( Reference Type)
    // kiểu mảng (Array)
    // Mảng kiểu String
    String[] studentName = {"Nguyễn Thị Hồng Ngọc", "Nguyễn Mai Hương", "Nguyễn Gia Bảo"};
    int[] studentAge = {20, 30, 40};

    // kiểu Object (đại diện cho các kiểu dữ liệu khác)
    // Đối tượng => chuyển đổi qua các kiểu dữ liệu khác
    Object studentAddress = "Đan Phượng, Hà Nội";
    Object employeeAge = 35;
    Object employeeSex = false;

    // kiểu chuỗi (String)
    String name = "Ngoc";
    String employeeNumber = "217";

    // public class FirefoxDriver
    FirefoxDriver ffDriver = new FirefoxDriver();

    // public interface WebDriver
    WebDriver driver = new ChromeDriver();

    // Java Collection
    List<WebElement> textboxes = driver.findElements(By.cssSelector(""));
    ArrayList<String> studentCity = new ArrayList<String>();

}

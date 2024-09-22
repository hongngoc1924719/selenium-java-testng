package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_02_By_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_ID() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtSearch"));
    }

    @Test
    public void TC_02_Class() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.className("inputsearch2"));
    }

    @Test
    public void TC_03_Name() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.name("txtFirstname"));
        driver.findElement(By.name("txtEmail"));
        driver.findElement(By.name("txtCEmail"));
        driver.findElement(By.name("txtPassword"));
        driver.findElement(By.name("txtCPassword"));
        driver.findElement(By.name("txtPhone"));
    }

    @Test
    public void TC_04_Link() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.linkText("Đăng Ký"));
        driver.findElement(By.linkText("Đăng Nhập"));
    }

    @Test
    public void TC_05_PartialLink() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.linkText("Ký"));
        driver.findElement(By.partialLinkText("Nhập"));
    }

    @Test
    public void TC_06_TagName() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        int linkNumber = driver.findElements(By.tagName("input")).size();
        System.out.println("Tổng số lượng link = " + linkNumber);
    }

    @Test
    public void TC_07_Css() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.cssSelector("input[id='chkRight']"));
    }

    @Test
    public void TC_08_Xpath() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']"));
        driver.findElement(By.xpath("//button[@id='btndknfooter']"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

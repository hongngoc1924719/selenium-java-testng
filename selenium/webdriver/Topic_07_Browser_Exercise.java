package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_Browser_Exercise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Page_URL() {
        driver.get("https://live.techpanda.org/");

        // Click vào My Account tại footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        // 1 - dùng nhiều hơn 2 lần trở lên
        String loginPageURL = driver.getCurrentUrl();
        Assert.assertEquals(loginPageURL,"https://live.techpanda.org/index.php/customer/account/login/");

        // 2 - dùng có 1 lần duy nhất
        // Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/login/");

        // Click chuyển qua trang create an account
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/create/");
    }

    @Test
    public void TC_02_Page_Title() {
        driver.get("https://live.techpanda.org/");

        // Click vào My Account tại footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        Assert.assertEquals(driver.getTitle(),"Customer Login");

        // Click chuyển qua trang create an account
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }

    @Test
    public void TC_03_Navigation() {
        driver.get("https://live.techpanda.org/");

        // Click vào My Account tại footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        // Click chuyển qua trang create an account
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/create/");

        // Quay lại trang trước đó
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/login/");

        // Chuyển tiếp về trang trước đó
        driver.navigate().forward();
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }

    @Test
    public void TC_04_Page_Source() {
        driver.get("https://live.techpanda.org/");

        // Click vào My Account tại footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        // Tuyệt đối = bằng nhau
        // Assert.assertEquals(driver.getPageSource(),"");

        // Tương đối = assertTrue/False
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        // Click chuyển qua trang create an account
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

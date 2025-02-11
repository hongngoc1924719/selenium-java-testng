package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_18_Fixed_Popup {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_ZingPoll_Fixed_In_DOM() throws InterruptedException {
        driver.get("https://zingpoll.com");
        driver.findElement(By.cssSelector("a#Loginform")).click();
        Thread.sleep(2000);

        // Kiem tra popup login hien thi
        By loginpopup = By.cssSelector("div#Login div.modal-dialog");
        Assert.assertTrue(driver.findElement(loginpopup).isDisplayed());

        // Close popup
        driver.findElement(By.cssSelector("div#Login div.modal-dialog button.close")).click();
        Thread.sleep(2000);

        // Kiem tra popup login ko hien thi
        Assert.assertFalse(driver.findElement(loginpopup).isDisplayed());
    }

    @Test
    public void TC_02_NgoaiNgu24h_Fixed_Not_Found_In_DOM() throws InterruptedException {
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();

        // Kiem tra pop up hien thi
        By loginpopup = By.cssSelector("div[role='dialog']");
        Assert.assertTrue(driver.findElement(loginpopup).isDisplayed());

        driver.findElement(By.cssSelector("input[placeholder='Tài khoản đăng nhập']")).sendKeys("automationfc");
        driver.findElement(By.name("password")).sendKeys("automationfc");
        driver.findElement(By.xpath("//div[@id='custom-dialog']//button[text()='Đăng nhập']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#notistack-snackbar")).getText(),"Bạn đã nhập sai tài khoản hoặc mật khẩu!");

        // Close popup
        driver.findElement(By.cssSelector("div#custom-dialog h2>button")).click();
        Thread.sleep(3000);

        // Kiem tra popup ko con hien thi
        Assert.assertEquals(driver.findElements(loginpopup).size(),0);
    }

    @Test
    public void TC_03_Tiki_Fixed_Not_Found_In_DOM() throws InterruptedException {
        driver.get("https://tiki.vn/");
        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();
        Thread.sleep(2000);

        By Loginpopup = By.cssSelector("div[role='dialog']");

        // Kiem tra popup login hien thi
        Assert.assertTrue(driver.findElement(Loginpopup).isDisplayed());
        // Close popup
        driver.findElement(By.cssSelector("button.btn-close")).click();
        Thread.sleep(2000);
        // Kiem tra popup ko con hien thi
        Assert.assertEquals(driver.findElements(Loginpopup).size(),0);
    }


    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}

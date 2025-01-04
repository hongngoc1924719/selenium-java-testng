package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.Colors;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_13_Button {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.get("https://www.fahasa.com/customer/account/create");
    }

    @Test
    public void TC_01_Button() throws InterruptedException {
        By loginButton = By.cssSelector("button.fhs-btn-login");

        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();

        // Verify button disabled
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());

        Assert.assertEquals(Color.fromString(driver.findElement(loginButton)
                .getCssValue("background-color"))
                .asHex().toUpperCase(),"#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("ngoc@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456789");
        Thread.sleep(2000);

        // Verify button enabled
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());

        Assert.assertEquals(Color.fromString(driver.findElement(loginButton)
                        .getCssValue("background-color"))
                .asHex().toUpperCase(),"#C92127");

    }

    @Test
    public void TC_02_() {
        By registerButton = By.cssSelector("button.fhs-btn-register");
        // 1- CLickable
        // Chờ cho 1 element không được phép click trong vòng 10s
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                not(ExpectedConditions.elementToBeClickable(registerButton)));

        // 2 - Text hiển thị đúng
        Assert.assertEquals(driver.findElement(registerButton).getText().trim(),"Đăng ký");

        // 3 - Background màu gì
        String backgroundRegister = driver.findElement(registerButton).getCssValue("background-color");
        Assert.assertEquals(backgroundRegister,"rgba(0, 0, 0, 0)");

        // Convert qua màu chung all browser: HEXA
        Assert.assertEquals(Color.fromString(backgroundRegister).asHex().toUpperCase(),"#00000000");

        // 4 - Disable / Enable
        // Mong đợi element là enable thì assertTrue
        // Mong đợi element là disable thì assertFalse
        Assert.assertFalse(driver.findElement(registerButton).isEnabled());

    }

    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}

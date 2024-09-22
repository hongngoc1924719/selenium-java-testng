package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_Relative_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Relative_Locator() {
        driver.get("http://live.techpanda.org/index.php/customer/account/create");

        // 1 - Khai báo biến
        // Khi dữ liệu này được sử dụng nhiều lần = tái sử dụng (reusable)
        String emailAddress = "automationtest@gmail.com";
        By emailTextboxBy = By.cssSelector("");
        WebElement emailTextboxElement = driver.findElement(emailTextboxBy);

        emailTextboxElement.clear();
        emailTextboxElement.isDisplayed();
        emailTextboxElement.sendKeys("");

        // 2 - Không khai báo biến
        // khi chỉ sử dụng 1 lần
        driver.findElement(emailTextboxBy).sendKeys("");
    }

    @Test
    public void TC_02_NopCommerce_Register() {
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        // Male option
        driver.findElement(By.xpath("//input[@id='gender-male']"));

        // Female option
        driver.findElement(By.xpath("//input[@id='gender-female']"));

        // First Name text box
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        // Last Name text box
        driver.findElement(By.xpath("//input[@name='LastName']"));

        // Day dropdown list
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));

        // Month dropdown list
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));

        // Year dropdown list
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));

        // Email text box
        driver.findElement(By.xpath("//input[@name='Email']"));

        // Company text box
        driver.findElement(By.xpath("//input[@id='Company']"));

        // Newsletter checkbox
        driver.findElement(By.xpath("//input[@id='Newsletter']"));

        // Password text box
        driver.findElement(By.xpath("//input[@id='Password']"));

        // Confirm Password text box
        driver.findElement(By.xpath("//input[@id='Password']"));

        // Register button
        driver.findElement(By.xpath("//button[@id='register-button']"));

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

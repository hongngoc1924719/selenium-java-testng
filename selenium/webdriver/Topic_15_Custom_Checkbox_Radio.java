package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_15_Custom_Checkbox_Radio {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Ubuntu() throws InterruptedException {
        driver.get("https://login.ubuntu.com/");
        Thread.sleep(3000);

        // Dùng hàm click của JS, verify bình thường
        By registerRadio = By.cssSelector("input#id_new_user");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                driver.findElement(registerRadio));
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(registerRadio).isSelected());

        By termCheckbox = By.cssSelector("input#id_accept_tos");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                driver.findElement(termCheckbox));
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(termCheckbox).isSelected());

    }

    @Test
    public void TC_02_Google_Form() throws InterruptedException {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        Thread.sleep(3000);

        // Click lên radio button
        By canthoRadio = By.cssSelector("div[aria-label='Cần Thơ']");
        driver.findElement(canthoRadio).click();
        Thread.sleep(3000);

        // Verify = cách hiển thị
        Assert.assertTrue(driver.findElement(By.cssSelector("div[aria-label='Cần Thơ'][aria-checked='true']")).isDisplayed());

        // Verify lấy thuộc tính ra => Nên dùng
        Assert.assertEquals(driver.findElement(canthoRadio).getDomAttribute("aria-checked"),"true");

        // Click lên checkbox
        By miquangCheckbox = By.cssSelector("div[aria-label='Mì Quảng']");
        driver.findElement(miquangCheckbox).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(miquangCheckbox).getDomAttribute("aria-checked"),"true");

        // Select all checkboxes
        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("div[role='checkbox']"));
        for (WebElement checkbox : allCheckboxes){
            if (!checkbox.getDomAttribute("aria-checked").equals("true")){
                checkbox.click();
            }
        }
        // Verify all
        for (WebElement checkbox : allCheckboxes){
            Assert.assertEquals(checkbox.getDomAttribute("aria-checked"),"true");
        }

    }


    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}

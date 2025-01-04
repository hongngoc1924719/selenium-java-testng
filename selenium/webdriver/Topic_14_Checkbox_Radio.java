package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_14_Checkbox_Radio {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();

    }

    @Test
    public void TC_01_KendoUI_Checkbox() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        Thread.sleep(3000);

        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

        // Click chọn
        driver.findElement(dualZoneCheckbox).click();
        Thread.sleep(2000);

        // Verify chọn thành công
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());

        // Click bỏ chọn
        driver.findElement(dualZoneCheckbox).click();
        Thread.sleep(2000);

        // Verify bỏ chọn thành công
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());
    }

    @Test
    public void TC_02_KendoUI_Radio_Button() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        Thread.sleep(3000);
        By twoPetrol = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");

        // Click chọn
        driver.findElement(twoPetrol).click();
        Thread.sleep(2000);

        // Verify chọn thành công
        Assert.assertTrue(driver.findElement(twoPetrol).isSelected());
    }
    @Test
    public void TC_03_Select_All() throws InterruptedException {
        driver.get("https://automationfc.github.io/multiple-fields/");
        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));

        // 1 - Select hết tất cả checkbox
        for (WebElement checkbox: allCheckboxes){
            if (!checkbox.isSelected()){
                checkbox.click();
            }
        }
        // Verify điều kiện
        for (WebElement checkbox: allCheckboxes){
            Assert.assertTrue(checkbox.isSelected());
        }

        // 2 - Deselect hết tất cả checkbox
        for (WebElement checkbox: allCheckboxes){
            if (checkbox.isSelected()){
                checkbox.click();
            }
        }
        // Verify điều kiện
        for (WebElement checkbox: allCheckboxes){
            Assert.assertFalse(checkbox.isSelected());
        }

        // 3 - Select / Deselect 1 item trong all item
        for (WebElement checkbox: allCheckboxes){
            if (checkbox.getDomAttribute("value").equals("Fainting Spells") && !checkbox.isSelected()){
                    checkbox.click();
            }
        }
        // Verify điều kiện
        for (WebElement checkbox: allCheckboxes){
            if(checkbox.getDomAttribute("value").equals("Fainting Spells")){
                Assert.assertTrue(checkbox.isSelected());
            }
        }

    }

    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}

package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Custom_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_JQuery() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        // Salutation
        selectItemInSelectableDropdown("span#salutation-button","ul#salutation-menu div","Dr.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(),"Dr.");

        // Speed
        selectItemInSelectableDropdown("span#speed-button","ul#speed-menu div","Fast");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(),"Fast");
    }

    @Test
    public void TC_02_React_Semantic() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectItemInSelectableDropdown("div.dropdown","div.item>span.text","Jenny Hess");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Jenny Hess");

        selectItemInSelectableDropdown("div.dropdown","div.item>span.text","Christian");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Christian");
    }

    @Test
    public void TC_03_VueJS() throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInSelectableDropdown("li.dropdown-toggle","ul.dropdown-menu a","First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"First Option");

        selectItemInSelectableDropdown("li.dropdown-toggle","ul.dropdown-menu a","Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Second Option");

        selectItemInSelectableDropdown("li.dropdown-toggle","ul.dropdown-menu a","Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Third Option");
    }

    @Test
    public void TC_04_Editable() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

        selectItemInEditableDropdown("input.search","div.item>span.text","Afghanistan");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Afghanistan");

        selectItemInEditableDropdown("input.search","div.item>span.text","Albania");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Albania");
    }

    @Test
    public void TC_05_Huawei() throws InterruptedException {
        driver.get("https://id5.cloud.huawei.com/CAS/portal/userRegister/regbyemail.html");

        selectItemInHuaweiDropdown("div[ht='input_emailregister_dropdown']","input[ht='input_emailregister_search']",
                "ul.hwid-alpla-list span","South Korea");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[ht='input_emailregister_dropdown']>span")).getText(),"South Korea");

        selectItemInHuaweiDropdown("div[ht='input_emailregister_dropdown']","input[ht='input_emailregister_search']",
                "ul.hwid-alpla-list span","Kenya");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[ht='input_emailregister_dropdown']>span")).getText(),"Kenya");
    }
    private void selectItemInSelectableDropdown(String parentLocator, String childLocator, String textItem) throws InterruptedException {
        driver.findElement(By.cssSelector(parentLocator)).click();
        Thread.sleep(2000);

        // Chờ cho tất cả các item được load ra hết
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.cssSelector(childLocator)));

        // Tìm và lấy ra hết tất cả các item bên trong và lưu vào 1 biến (kiểu dữ liệu là List)
        List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));

        // Duyệt qua từng cái element để kiểm tra
        for (WebElement item : allItems) {
            // Kiểm tra điều kiện: nếu text của item lấy ra bằng với mong đợi,
            if (item.getText().trim().equals(textItem)){
                // Click vào chính item đó
                item.click();
                Thread.sleep(1500);
                // Thoát khỏi vòng lặp
                break;
            }
        }
    }

    private void selectItemInEditableDropdown(String parentLocator, String childLocator, String textItem) throws InterruptedException {
        driver.findElement(By.cssSelector(parentLocator)).clear();
        driver.findElement(By.cssSelector(parentLocator)).sendKeys(textItem);
        Thread.sleep(2000);

        // Chờ cho tất cả các item được load ra hết
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.cssSelector(childLocator)));

        // Tìm và lấy ra hết tất cả các item bên trong và lưu vào 1 biến (kiểu dữ liệu là List)
        List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));

        // Duyệt qua từng cái element để kiểm tra
        for (WebElement item : allItems) {
            // Kiểm tra điều kiện: nếu text của item lấy ra bằng với mong đợi,
            if (item.getText().trim().equals(textItem)){
                // Click vào chính item đó
                item.click();
                Thread.sleep(1500);
                // Thoát khỏi vòng lặp
                break;
            }
        }
    }

    private void selectItemInHuaweiDropdown(String parentLocator, String editableLocator, String childLocator, String textItem) throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentLocator)));
        driver.findElement(By.cssSelector(parentLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector(editableLocator)).clear();
        driver.findElement(By.cssSelector(editableLocator)).sendKeys(textItem);
        Thread.sleep(1500);

        // Chờ cho tất cả các item được load ra hết
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.cssSelector(childLocator)));

        // Tìm và lấy ra hết tất cả các item bên trong và lưu vào 1 biến (kiểu dữ liệu là List)
        List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));

        // Duyệt qua từng cái element để kiểm tra
        for (WebElement item : allItems) {
            // Kiểm tra điều kiện: nếu text của item lấy ra bằng với mong đợi,
            if (item.getText().trim().equals(textItem)){
                // Click vào chính item đó
                item.click();
                Thread.sleep(1500);
                // Thoát khỏi vòng lặp
                break;
            }
        }
    }

// Chưa học
    // Wait explicit
    // List<Web element>: nhiều element
    // Vòng lặp for + Điều kiện if + Câu lệnh break
    // Viết hàm (reusable function)
    // Tham số truyền vào (parameter)

    // Mục đích của việc viết hàm
    // tái sử dụng nhiều lần (reusable)
    // dễ dàng bảo trì (maintainable)
    // dễ dàng mở rộng (extendable)
    // dễ đọc code (readable)

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

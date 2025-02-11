package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_18_Random_Popup {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_JavaCodeGeeks() throws InterruptedException {
        driver.get("https://www.javacodegeeks.com/");

        By newsletterPopupBy = By.xpath("//div[@data-title='Newsletter-Books Anime Brief' " +
                "and not(contains(@style,'display:none'))]");

        // Hien thi thi close di roi action tiep
        if (driver.findElements(newsletterPopupBy).size() > 0
                && driver.findElements(newsletterPopupBy).get(0).isDisplayed()) {
            System.out.println("------- GO TO IF-------");
           driver.findElement(By.xpath("//div[@data-title='Newsletter-Books Anime Brief' " +
                   "and not(contains(@style,'display:none'))]//a[contains(@onclick, 'lepopup_close')]")).click();
           Thread.sleep(2000);
        }

        System.out.println("------- IGNORE IF-------");
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile");
        driver.findElement(By.cssSelector("form#search span.tie-icon-search")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("header>h1.page-title")).isDisplayed());
    }

    @Test
    public void TC_02_VNK_Edu() throws InterruptedException {
        driver.get("https://vnk.edu.vn/");
        By marketingPopupBy = By.cssSelector("div.popmake-content");

        if (driver.findElements(marketingPopupBy).size() > 0
                && driver.findElements(marketingPopupBy).get(0).isDisplayed()) {
            System.out.println("------- GO TO IF-------");
            driver.findElement(By.cssSelector("div.popmake-content~button")).click();
            Thread.sleep(2000);
        }

        System.out.println("------- IGNORE IF-------");
        driver.findElement(By.xpath("//ul[@id='mega-menu-primary']//a[text()='Liên hệ']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div.title-content>h1")).isDisplayed());
    }

    @Test
    public void TC_03_DeHieu() throws InterruptedException {
        driver.get("https://dehieu.vn/");
        Thread.sleep(7000);

        By contentPopupBy = By.cssSelector("div.modal-content");
        if (driver.findElements(contentPopupBy).size() > 0
                && driver.findElements(contentPopupBy).get(0).isDisplayed()) {
            System.out.println("------- GO TO IF-------");
            driver.findElement(By.cssSelector("div.modal-content button.close")).click();
            Thread.sleep(2000);
        }

        System.out.println("------- IGNORE IF-------");
        driver.findElement(By.cssSelector("input.search-form")).sendKeys("co dien");
        driver.findElement(By.cssSelector("button.header-search")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div.course-item")).isDisplayed());

    }

    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}

package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_18_Action_P2 {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void initialBrowser() {
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        action = new Actions(driver);
    }

    @Test
    public void TC_01_ClickAndHold_Fix() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> numbers = driver.findElements(By.cssSelector("ol#selectable>li"));
        action.clickAndHold(numbers.get(4)).pause(Duration.ofSeconds(2))
                .moveToElement(numbers.get(11)).pause(Duration.ofSeconds(2))
                .release().perform();

        List<WebElement> numberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(numberSelected.size(),8);
    }

    @Test
    public void TC_02_ClickAndHold_Random() {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> numbers = driver.findElements(By.cssSelector("ol#selectable>li"));

        String osName = System.getProperty("os.name");
        Keys keys = null;

        if (osName.contains("Windows")){
            keys = Keys.CONTROL;
        } else {
            keys = Keys.COMMAND;
        }
        action.keyDown(keys).perform(); // Nhấn phím Ctrl xuống
        action.click(numbers.get(2)).pause(Duration.ofSeconds(1))
                .click(numbers.get(5)).pause(Duration.ofSeconds(1))
                .click(numbers.get(11)).pause(Duration.ofSeconds(1))
                .click(numbers.get(13)).pause(Duration.ofSeconds(1))
                .click(numbers.get(19)).pause(Duration.ofSeconds(1))
                .perform();
        action.keyUp(keys).perform();

        List<WebElement> numberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(numberSelected.size(),5);
    }

    @Test
    public void TC_03_ClickAndHold_Fix() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement doubleClick = driver.findElement(By.xpath("//button[text()='Double click me']"));

        if (driver.toString().contains("Firefox")){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", (doubleClick));
        }

        action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']")))
                .pause(Duration.ofSeconds(2))
                .perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!");
    }

    @Test
    public void TC_04_RightClick() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());
        action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).pause(Duration.ofSeconds(2)).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());

        action.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-visible.context-menu-hover")).isDisplayed());

        action.click(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());
    }

    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}

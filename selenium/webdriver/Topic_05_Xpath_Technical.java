package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_05_Xpath_Technical {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_() {
        driver.get("http://live.techpanda.org/index.php/mobile.html");
        // text()='...'
        driver.findElement(By.xpath("//span[text()='Add to Cart']"));
        // contains(text(),'...')
        driver.findElement(By.xpath("//div[contains(text(),'This is root of mobile')]"));
        // contains(.,'...')
        driver.findElement(By.xpath("//a[contains(.,'Add to Wishlist')]"));
        // contains(string(),'...')
        driver.findElement(By.xpath("//a[contains(string(),'Add to Wishlist')]"));
        //span[text()=concat('Hello "John", What',"'s happened?")]
        // AND
        driver.findElement(By.xpath("//input[@type='email' and @id='email']"));
        // OR
        driver.findElement(By.xpath("//input[@type='email' or @id='email']"));
        // outside parent
        driver.findElement(By.xpath("//span[text()='Add to Cart'][1]")
    }

    @Test
    public void TC_02_() {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        // inside parent
        driver.findElement(By.xpath("//ol[@id='selectable']/li[12]")
        // position()
        driver.findElement(By.xpath("//ol[@id='selectable']/li[position()=1]"));
        // last()
        driver.findElement(By.xpath("//ol[@id='selectable']/li[last()]"));
        // gần kề last
        driver.findElement(By.xpath("//ol[@id='selectable']/li[last()-1]"));
    }

    @Test
    public void TC_03_() {
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        // not
        driver.findElement(By.xpath("//div[not(@style='display:none;')]/div[@class='raDiv']"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

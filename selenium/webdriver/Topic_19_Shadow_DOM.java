package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

public class Topic_19_Shadow_DOM {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


    }

    @Test
    public void TC_01_Github() {
        driver.get("https://automationfc.github.io/shadow-dom/");

        String scrolltext = driver.findElement(By.xpath("//a[@href='scroll.html']")).getText();
        System.out.println(scrolltext);

        WebElement firstshadowHostElement = driver.findElement(By.xpath("//div[@id='shadow_host']"));
        SearchContext firstshadowRoot = firstshadowHostElement.getShadowRoot();
        String shadowText = firstshadowRoot.findElement(By.cssSelector("a")).getText();
        System.out.println(shadowText);

        firstshadowRoot.findElement(By.cssSelector("input[type='text']")).sendKeys("Selenium");
        System.out.println(firstshadowRoot.findElement(By.cssSelector("span#shadow_content>span")).getText());

        WebElement secondshadowHostElement = firstshadowRoot.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext secondshadowRoot = secondshadowHostElement.getShadowRoot();
        System.out.println(secondshadowRoot.findElement(By.cssSelector("div#nested_shadow_content>div")).getText());
    }

    @Test
    public void TC_02_Appspot() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");
        Thread.sleep(5000);

        WebElement firstshadowHostElement = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
        SearchContext firstshadowRoot = firstshadowHostElement.getShadowRoot();

        firstshadowRoot.findElement(By.cssSelector("input#input")).sendKeys("Harry Potter");
        Thread.sleep(3000);

        WebElement secondshadowHostElement = firstshadowRoot.findElement(By.cssSelector("app-toolbar>book-input-decorator"));
        SearchContext secondshadowRoot = secondshadowHostElement.getShadowRoot();

        secondshadowRoot.findElement(By.cssSelector("div.icon")).click();
        Thread.sleep(2000);

        WebElement thirdshadowHostElement = firstshadowRoot.findElement(By.cssSelector("main.main-content>book-explore"));
        SearchContext thirdshadowRoot = thirdshadowHostElement.getShadowRoot();

        List<WebElement> forthshadowHostElements = thirdshadowRoot.findElements(By.cssSelector("ul.books>li>book-item"));

        for (WebElement element : forthshadowHostElements) {
            SearchContext shadowRoot = element.getShadowRoot();
            System.out.println(shadowRoot.findElement(By.cssSelector("div.title-container>h2")).getText());
        }

    }


    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}

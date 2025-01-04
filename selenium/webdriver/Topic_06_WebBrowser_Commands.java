package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Topic_06_WebBrowser_Commands {
    WebDriver driver;

    @Parameters("")
    @BeforeClass
    public void beforeClass() {
        // Tương tác với Browser thông qua biến driver
        driver = new FirefoxDriver();
        System.out.println("Driver ID = " + driver.manage());
    }

    @Test
    public void TC_01_Browser() throws MalformedURLException {
        // Mở ra 1 URL bất kì
        driver.get("https://www.facebook.com/login/"); //**

        // Đóng browser - ko quan tâm có bao nhiêu tab/window
        driver.quit(); //**

        // Đóng browser - chỉ đóng tab/ window hiện tại
        // Nếu chỉ có 1 tab/window thì cũng tương tự đóng browser
        driver.close();

        // Tìm 1 element vs locator là tham số truyền vào
        driver.findElement(By.cssSelector("")); //**

        // Tìm nhiều element vs locator là tham số truyền vào
        driver.findElements(By.cssSelector("")); //**

        // Sử dụng luôn ko cần lưu trữ (1)
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/login/");

        // Lấy ra Url ở page hiện tại (2)
        String homePageUrl = driver.getCurrentUrl();
        System.out.println("Page URL = " + driver.getCurrentUrl());

        // Step 10
        driver.get(homePageUrl);
        Assert.assertEquals(homePageUrl, "https://www.facebook.com/login/");

        // Lấy ra title ở page hiện tại
        driver.getTitle();
        System.out.println("Page Title = " + driver.getTitle());

        // Lấy ra window ID ở page hiện tại
        driver.getWindowHandle();
        System.out.println("Window ID = " + driver.getWindowHandle());

        // Lấy ra tất cả các window ID của các tab/window
        driver.getWindowHandles();

        // Lấy ra source code của page hiện tại
        driver.getPageSource();
        System.out.println("Page Source Code = " + driver.getPageSource());

        TargetLocator switchTo = driver.switchTo();

        switchTo.alert();

        // Alert - Frame/ iFrame - Window/ Tab
        // Alert
        driver.switchTo().alert(); //**

        // Frame - iFrame
        // Switch vào frame/ iframe
        driver.switchTo().frame(""); //**

        // Switch ra trang cha trở lại (chỉ có 1 frame)
        driver.switchTo().defaultContent();

        // Switch từ frame con ra frame cha (nhiều frame lồng nhau)
        driver.switchTo().parentFrame();

        // Window - TAB
        driver.switchTo().window(""); //**
        driver.switchTo().newWindow(WindowType.TAB).get("https://live.techpanda.org/");
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://live.techpanda.org/");

        // Set timeout để tìm element (áp dụng cho 2 hàm findElement/ findElements)
        // Trường hợp ko tìm thấy sẽ chờ hết chừng đó thời gian rồi mới show lỗi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //**

        // Set timeout để chờ page được load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Set timeout để chờ cho đoạn code JS được thực thi thành công
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        // Cookie
        driver.manage().getCookies();
        // driver.manage().addCookie();

        // Browser: fullscreen/ maximize/ minimize
        driver.manage().window().maximize(); //**
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();

        // Set browser có kích thước bằng bao nhiêu (Responsive)
        driver.manage().window().setSize(new Dimension(1920,1080));

        // Set browser tại vị trí nào
        driver.manage().window().setPosition(new Point(0,0));

        // Selenium Log: Browser/ Driver/ Network
        driver.manage().logs().get(LogType.BROWSER);
        driver.manage().logs().get(LogType.PERFORMANCE);
        driver.manage().logs().get(LogType.CLIENT);
        driver.manage().logs().get(LogType.SERVER);
        driver.manage().logs().getAvailableLogTypes();

        // Step Log = Log4J

        // Quay lại trang trước đó
        driver.navigate().back();

        // Chuyển tiếp đến trang trước đó
        driver.navigate().forward();

        // Refresh lại trang hiện tại
        driver.navigate().refresh();

        // Mở 1 URL
        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().to(new URL("https://www.youtube.com/"));
    }

    @AfterClass
    public void afterClass() {

        driver.quit();

    }

}

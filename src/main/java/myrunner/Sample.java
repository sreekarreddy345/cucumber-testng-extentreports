package myrunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sample {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SreekarJava\\install\\chromedriver_win32_1\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        Thread.sleep(5000);
    }
}

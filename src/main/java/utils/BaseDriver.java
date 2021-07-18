package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseDriver {
    public static WebDriver driver;
    public static Properties prop;
    public static String environment;

    public static void getDriver() {
//        if (driver == null) {
        switch (BaseDriver.getPropertyValue("browser")) {
            case "chrome":
//                    WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\sreek\\Downloads\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
//        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        String url = getPropertyValue("url");
        driver.get(url);

    }

    private static String getPropertyValue(String key) {
        String path = "";


        path = "./src/main/resources/configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            prop = new Properties();
            prop.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println("Incorrect path");
        }
        return prop.getProperty(key);
    }

}

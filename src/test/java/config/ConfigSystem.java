package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Authentication;

public class ConfigSystem {
    public static WebDriver setup() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver.exe");
        driver.get("https://opensource-demo.orangehrmlive.com");
        Thread.sleep(5000);
        new Authentication(driver).login();
        return driver;
    }
}

package testcases;

import model.AdminData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Authentication;

public class LoginTest {
    private WebDriver driver;
    private AdminData adminData;
    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver.exe");
        driver.get("https://opensource-demo.orangehrmlive.com");
        Thread.sleep(5000);
        new Authentication(driver).login();

//        driver.quit();
    }
    @Test
    void testLogout() throws InterruptedException {
        Authentication service = new Authentication(driver);
        service.logout();
    }
}

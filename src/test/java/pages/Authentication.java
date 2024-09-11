package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Authentication {
    private final WebDriver driver;
    public Authentication(WebDriver driver){
        this.driver = driver;
    }
    public void login() throws InterruptedException {
        //input username
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
        Thread.sleep(2000);
        //input password
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys(("admin123"));
        Thread.sleep(2000);
        //button login
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        Thread.sleep(10000);
    }
    public void logout() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[3]/ul/li")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a")).click();
    }
}

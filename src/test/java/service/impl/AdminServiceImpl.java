package service.impl;

import lombok.Getter;
import model.AdminData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import service.AdminService;

import java.util.UUID;

@Getter
public class AdminServiceImpl implements AdminService {

    private WebDriver driver;

    private AdminData adminData;


    @Override
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void setAdminData(AdminData adminData) {
        this.adminData = adminData;
    }

    @Override
    public void tabAdmin() throws InterruptedException {
        //click tab admin
        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[1]")).click();
        Thread.sleep(3000);
    }

    @Override
    public void emptyData() throws InterruptedException {
        //click btn update
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[2]")).click();
        Thread.sleep(4000);

        //click checkbox Change password
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[5]/div/div[2]/div/label/span/i")).click();
        Thread.sleep(1000);

        clearUpdateFields();

        //click btn submit
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
        Thread.sleep(4000);
    }

    @Override
    public void emptyDataAdd() throws InterruptedException {
        //click btn add
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
        Thread.sleep(4000);
        //click btn submit
        driver.findElement(By.xpath(("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"))).click();
        Thread.sleep(4000);
    }

    @Override
    public void messageError() throws InterruptedException {
        AdminData admin = getAdminData();

        //click role user
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")).click();
        Thread.sleep(1000);
        //role user
        driver.findElement(By.xpath(String.format("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[%d]", admin.getRole()))).click();
        Thread.sleep(1000);

        //click status
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")).click();
        Thread.sleep(1000);
        //status
        driver.findElement(By.xpath(String.format("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[%d]", admin.getStatus()))).click();
        Thread.sleep(1000);

        //password
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys(admin.getPassword());
        Thread.sleep(1000);

        //nhập employee
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).sendKeys("a");
        Thread.sleep(3000);
        //click 1 employee
        driver.findElement(By.xpath(String.format("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[%d]", admin.getEmployee()))).click();
        Thread.sleep(1000);

        //username
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).sendKeys(admin.getUsername());
        Thread.sleep(1000);

        //password
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys(admin.getPassword());
        Thread.sleep(1000);

        //confirm password
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys(admin.getConfirmPassword());
        Thread.sleep(1000);
    }

    @Override
    public void updateUser(AdminData adminData) throws InterruptedException {
        // Click role
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")).click();
        Thread.sleep(1000);
        //role user
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]")).click();
        Thread.sleep(1000);

        //click status
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")).click();
        Thread.sleep(1000);
        //status
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]")).click();
        Thread.sleep(1000);

        //password
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys("diepnguyen2k3@");
        Thread.sleep(1000);

        //confirm password
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys("diepnguyen2k3@");
        Thread.sleep(1000);

        //enter employee
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).sendKeys("a");
        Thread.sleep(3000);
        //click 1 employee
        driver.findElement(By.xpath(String.format("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[%d]", adminData.getEmployee()))).click();
        Thread.sleep(1000);

        //username
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).sendKeys(adminData.getUsername());
        Thread.sleep(1000);

        //btn submit
        driver.findElement(By.xpath(("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"))).click();
        Thread.sleep(1000);
    }

    @Override
    public void addUser(AdminData admin) throws InterruptedException {
        // Xóa trường employee
        WebElement employeeField = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input"));
        // Xóa trường username
        WebElement usernameField = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"));
        // Xóa trường password
        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input"));
        // Xóa trường confirm password
        WebElement confirmPasswordField = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input"));

        // Nhập dữ liệu mới
        //click role user
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")).click();
        Thread.sleep(1000);
        //role user
        driver.findElement(By.xpath(String.format("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[%d]", admin.getRole()))).click();
        Thread.sleep(1000);
        //click status
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")).click();
        Thread.sleep(1000);
        //status
        driver.findElement(By.xpath(String.format("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[%d]", admin.getStatus()))).click();
        Thread.sleep(1000);
        //password
        passwordField.sendKeys(admin.getPassword());
        Thread.sleep(1000);
        //confirm password
        confirmPasswordField.sendKeys(admin.getConfirmPassword());
        Thread.sleep(1000);
        //nhập employee
        employeeField.sendKeys("a");
        Thread.sleep(3000);
        //click 1 employee
        driver.findElement(By.xpath(String.format("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[%d]", admin.getEmployee()))).click();
        Thread.sleep(1000);
        //username
        usernameField.sendKeys(admin.getUsername());
        Thread.sleep(1000);
        //btn submit
        driver.findElement(By.xpath(("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"))).click();
        Thread.sleep(1000);
    }

    @Override
    public void clearAddFields() {
        // Xóa trường employee
        WebElement employeeField = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input"));
        employeeField.sendKeys(Keys.CONTROL + "a");
        employeeField.sendKeys(Keys.DELETE);
        // Xóa trường username
        WebElement usernameField = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"));
        usernameField.sendKeys(Keys.CONTROL + "a");
        usernameField.sendKeys(Keys.DELETE);
        // Xóa trường password
        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input"));
        passwordField.sendKeys(Keys.CONTROL + "a");
        passwordField.sendKeys(Keys.DELETE);
        // Xóa trường confirm password
        WebElement confirmPasswordField = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input"));
        confirmPasswordField.sendKeys(Keys.CONTROL + "a");
        confirmPasswordField.sendKeys(Keys.DELETE);
    }

    @Override
    public void clearUpdateFields() throws InterruptedException {
        // clear field employee
        WebElement employeeField = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input"));
        employeeField.sendKeys(Keys.CONTROL + "a");
        employeeField.sendKeys(Keys.DELETE);

        // clear field username
        WebElement usernameField = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"));
        usernameField.sendKeys(Keys.CONTROL + "a");
        usernameField.sendKeys(Keys.DELETE);

        // clear field password
        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input"));
        passwordField.sendKeys(Keys.CONTROL + "a");
        passwordField.sendKeys(Keys.DELETE);

        // clear field confirm password
        WebElement confirmPasswordField = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input"));
        confirmPasswordField.sendKeys(Keys.CONTROL + "a");
        confirmPasswordField.sendKeys(Keys.DELETE);

        /*=========== Clear Dropdown ===========*/
        //click role user
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")).click();
        Thread.sleep(1000);
        //role user
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[1]")).click();
        Thread.sleep(1000);

        //click status
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")).click();
        Thread.sleep(1000);
        //status
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[1]")).click();
        Thread.sleep(1000);
    }

    @Override
    public boolean isValid() {
        //check error username
        WebElement usernameError = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"));
        boolean isUsernameMessage = usernameError.isDisplayed() && usernameError.getText().contains("Should be at least 5 characters");
        //check error password
        WebElement passwordError = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input"));
        boolean isPasswordMessage = passwordError.isDisplayed() && passwordError.getText().contains("Should be at least 7 characters");
        //check error confirm password
        WebElement confirmPasswordError = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input"));
        boolean isConfirmPasswordMessage = confirmPasswordError.isDisplayed() && confirmPasswordError.getText().contains("Passwords do not match");
        return !isUsernameMessage || !isPasswordMessage || !isConfirmPasswordMessage;
    }

    // Handle
    @Override
    public String generateUniqueUsername() {
        return "user_" + UUID.randomUUID().toString().substring(0, 5);
    }

    //Delete user
    @Override
    public void handleDeleteUser() throws InterruptedException {
        //tìm username
//        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[2]/div/div[1]/div/div/label/input")).click();
//        Thread.sleep(1000);
        //click icon delete
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[2]/div/div[6]/div/button[1]")).click();
        Thread.sleep(1000);
        //click btn yes
        try {
            driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div/div[3]/button[2]")).click();
            Thread.sleep(1000);
        } catch (Exception e) {
            // Error
        }
    }

    @Override
    public void cancelDeleteUser() throws InterruptedException {
        //click icon delete
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[2]/div/div[6]/div/button[1]")).click();
        Thread.sleep(1000);
        //click icon cancel
        try {
            driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div/div[3]/button[1]")).click();
            Thread.sleep(1000);
        } catch (Exception e) {
            // Error
        }
    }

    //Hàm xóa tất cả
    @Override
    public void deleteSelectedUser() throws InterruptedException {
        //click vào checkbox tổng
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[1]/div/label/span/i")).click();
        Thread.sleep(1000);
        try{
            //click btn delete selected
            driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/button")).click();
            Thread.sleep(1000);
            //click btn delete
            driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div/div[3]/button[2]")).click();
            Thread.sleep(1000);
        }catch (Exception e){

        }
    }


}

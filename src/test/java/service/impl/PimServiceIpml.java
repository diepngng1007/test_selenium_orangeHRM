package service.impl;

import lombok.Getter;
//import lombok.Setter;
import model.PIMData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import service.PimService;

import java.util.UUID;

@Getter
//@Setter
public class PimServiceIpml implements PimService {

    private WebDriver driver;
    private PIMData PIMData;

    @Override
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void setPIMData(PIMData pimData) {
        this.PIMData = pimData;
    }


    @Override
    public void tabPIM() throws InterruptedException {
        //Click tab PIM
        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]")).click();
        Thread.sleep(3000);
    }

    @Override
    public void emptyDataAdd() throws InterruptedException {
        //click btn add
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
        Thread.sleep(1000);
        //click btn submit
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
        Thread.sleep(1000);
    }

    @Override
    public void emptyDataUpdate() throws InterruptedException {


    }

    @Override
    public void updateEmployee() throws InterruptedException {

    }

    //Personal Detail Page - Màn save
    @Override
    public boolean enterInvalidDate() throws InterruptedException {
        //check License Expiry Date
        WebElement lsDateError = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[2]/div/div[2]/div/div/input"));
        boolean isLsDataMessage = lsDateError.isDisplayed() && lsDateError.getText().contains("Should be a valid date in yyyy-dd-mm format");
        //check message date of birth
        WebElement dateOfBirthError = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[1]/div/div[2]/div/div/input"));
        boolean isDateOfBirthMessage = dateOfBirthError.isDisplayed() && dateOfBirthError.getText().contains("Should be a valid date in yyyy-dd-mm format");
        return !isLsDataMessage && !isDateOfBirthMessage;
    }

    @Override
    public void clearDataEmployee() throws InterruptedException {
        Thread.sleep(5000);
        //clear first name
        WebElement firstName = driver.findElement(By.cssSelector("[name='firstName']"));
        firstName.sendKeys(Keys.CONTROL + "a");
        firstName.sendKeys(Keys.DELETE);
        //clear middle name
        WebElement middleName = driver.findElement(By.cssSelector("[name='middleName']"));
        middleName.sendKeys(Keys.CONTROL + "a");
        middleName.sendKeys(Keys.DELETE);
        //clear last name
        WebElement lastName = driver.findElement(By.cssSelector("[name='lastName']"));
        lastName.sendKeys(Keys.CONTROL + "a");
        lastName.sendKeys(Keys.DELETE);
        //clear License Expiry Date
        WebElement lsDate = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[2]/div/div[2]/div/div/input"));
        lsDate.sendKeys(Keys.CONTROL + "a");
        lsDate.sendKeys(Keys.DELETE);
        //clear Date of birth
        WebElement dateOfBirth = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[1]/div/div[2]/div/div/input"));
        dateOfBirth.sendKeys(Keys.CONTROL + "a");
        dateOfBirth.sendKeys(Keys.DELETE);
    }

    @Override
    public void enterAgainEmployeeForSave(PIMData pimData) throws InterruptedException {
    //nhâp lại dữ liệu mới
        //first name
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div[1]/div[2]/input")).sendKeys(pimData.getFirstNamep());
        Thread.sleep(1000);
        //middle name
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/input")).sendKeys(pimData.getMiddleNamep());
        Thread.sleep(1000);
        //last name
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input")).sendKeys(pimData.getLastNamep());
        Thread.sleep(1000);
        //employee id
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(pimData.getEmployeeIdp());
        Thread.sleep(1000);
        //tgian gia hạn blx
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[2]/div/div[2]/div/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[2]/div/div[2]/div/div/input")).sendKeys(pimData.getLEDate());
        Thread.sleep(1000);
        //date of birth
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[1]/div/div[2]/div/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[1]/div/div[2]/div/div/input")).sendKeys(pimData.getDateOfBirth());
        Thread.sleep(1000);
        //click btn save
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/button")).click();
        Thread.sleep(1000);
    }

    @Override
    public void emptySaveEmployee() throws InterruptedException {
        //click btn add
//        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
//        Thread.sleep(1000);
        // clear data
        clearDataEmployee();
        Thread.sleep(4000);
        //click btn save
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/button")).click();
        Thread.sleep(1000);

    }

    // employee
    @Override
    public void addEmployee(PIMData pimData) throws InterruptedException {
        //enter new data
        //first name
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")).sendKeys(pimData.getFirstName());
        Thread.sleep(1000);
        //middle name
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/input")).sendKeys(pimData.getMiddleName());
        Thread.sleep(1000);
        //last name
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input")).sendKeys(pimData.getLastName());
        Thread.sleep(1000);
        //employee id
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")).sendKeys(pimData.getEmployeeId());
        Thread.sleep(1000);
        //btn change ava
//        try{
//            WebElement imageUpload = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/div/button"));
//            imageUpload.click();
//            Thread.sleep(2000);
//            imageUpload.sendKeys(System.getProperty("user/dir") + "\\file\\shin-image.jpg");
//            Thread.sleep(1000);
//            imageUpload.sendKeys(pimData.getImagePath());
//        }catch(Exception e){
//
//        }
        //btn save add
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
        Thread.sleep(1000);
    }

    @Override
    public String randomIDEmployee() {
        return UUID.randomUUID().toString().substring(0, 5);
    }

    @Override
    public boolean checkValidate() throws InterruptedException {
        WebElement errorEmployeeId = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input"));
        boolean messageEmployeeId = errorEmployeeId.isDisplayed() && errorEmployeeId.getText().contains("Should not exceed 10 characters");
        return !messageEmployeeId;
    }

    @Override
    public void clearAddFields() throws InterruptedException {
        //clear first name
        WebElement firstName = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input"));
        firstName.sendKeys(Keys.CONTROL + "a");
        firstName.sendKeys(Keys.DELETE);
        //clear middle name
        WebElement middleName = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/input"));
        middleName.sendKeys(Keys.CONTROL + "a");
        middleName.sendKeys(Keys.DELETE);
        //clear last name
        WebElement lastName = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input"));
        lastName.sendKeys(Keys.CONTROL + "a");
        lastName.sendKeys(Keys.DELETE);
        //clear employee id
        WebElement employeeId = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input"));
        employeeId.sendKeys(Keys.CONTROL + "a");
        employeeId.sendKeys(Keys.DELETE);
    }

}

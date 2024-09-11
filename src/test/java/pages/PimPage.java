package pages;

import config.ConfigSystem;
import model.PIMData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.PimService;
import service.impl.PimServiceIpml;

import java.time.Duration;

import static model.PIMData.*;

public class PimPage {
    private final PimService pimService;
    private WebDriver driver;

    public PimPage() {
        this.pimService = new PimServiceIpml();
    }

    public void setUp() throws InterruptedException {
        pimService.setDriver(ConfigSystem.setup());
    }

    public void addEmployee() throws InterruptedException {
        pimService.tabPIM();
        pimService.emptyDataAdd();
        setupInvalidData();
        pimService.clearAddFields();

        if (pimService.checkValidate()) {
            pimService.addEmployee(setupValidData());
        }
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/button"))); // Chờ nút lưu xuất hiện

    }

    public void saveChangeEmployee() throws InterruptedException {
//        pimService.tabPIM();
//        this.addEmployee();
        pimService.emptySaveEmployee();
        checkInvalidPersonal();
        if (pimService.enterInvalidDate()) {
            pimService.clearDataEmployee();
            pimService.enterAgainEmployeeForSave(checkValidPersonal());
        }
    }

    //data valid & invalid of employee
    public PIMData setupValidData() throws InterruptedException {
        return builder()
                .firstName("nguyen")
                .middleName("ngoc")
                .lastName("diep")
                .imagePath(System.getProperty("user/dir") + "\\file\\shin-image.jpg")
                .employeeId(pimService.randomIDEmployee())
                .build();
    }

    public void setupInvalidData() throws InterruptedException {
        pimService.setPIMData(builder()
                .firstName("nguyen")
                .middleName("ngoc")
                .lastName("diep")
                .imagePath(System.getProperty("user/dir") + "\\file\\shin-image.jpg")
                .employeeId("abc12345678910")
                .build());
    }

    //PersonalDetail Page (invalid & valid)
    public void checkInvalidPersonal() throws InterruptedException {
        pimService.setPIMData(PIMData.builder()
                .firstNamep("Nguyen")
                .middleNamep("Ngoc")
                .lastNamep("Diep")
                .employeeIdp("091c1111111111")
                .dateOfBirth("hihihi")
                .lEDate("hehehe")
                .build()
        );
    }

    public PIMData checkValidPersonal() throws InterruptedException {
        return builder()
                .firstNamep("Nguyen")
                .middleNamep("Ngoc")
                .lastNamep("Diep")
                .employeeIdp(pimService.randomIDEmployee())
                .dateOfBirth("2003-10-07")
                .lEDate("2024-12-12")
                .build();
    }

}

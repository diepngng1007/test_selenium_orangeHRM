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
    }

    public void saveChangeEmployee() throws InterruptedException {
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
                .imagePath("C:\\Users\\admin\\Pictures\\Hinh-Nen-cu-Shin.jpg")
                .employeeId(pimService.randomIDEmployee())
                .build();
    }

    public void setupInvalidData() throws InterruptedException {
        pimService.setPIMData(builder()
                .firstName("nguyen")
                .middleName("ngoc")
                .lastName("diep")
                .imagePath("C:\\Users\\admin\\Pictures\\Hinh-Nen-cu-Shin.jpg")
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

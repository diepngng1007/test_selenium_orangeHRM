package service;

import model.PIMData;
import org.openqa.selenium.WebDriver;

public interface PimService {
    //for add
    void setDriver(WebDriver driver);

    void setPIMData(PIMData pimData);

    void tabPIM() throws InterruptedException;

    void emptyDataAdd() throws InterruptedException;

    void addEmployee(PIMData PIMData) throws InterruptedException;

    String randomIDEmployee();

    boolean checkValidate() throws InterruptedException;

    void clearAddFields() throws InterruptedException;


    //for update
    void emptyDataUpdate() throws InterruptedException;

    void updateEmployee() throws InterruptedException;

    //for personal detail page
    boolean enterInvalidDate() throws InterruptedException;

    void clearDataEmployee() throws InterruptedException;

    void enterAgainEmployeeForSave(PIMData pimData) throws InterruptedException;

    void emptySaveEmployee() throws InterruptedException;

//    void chooseDate() throws InterruptedException;


}

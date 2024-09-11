package service;

import model.AdminData;
import org.openqa.selenium.WebDriver;

public interface AdminService {
    void setDriver(WebDriver driver);

    void setAdminData(AdminData adminData);

    void tabAdmin() throws InterruptedException;

    void emptyData() throws InterruptedException;

    void emptyDataAdd() throws InterruptedException;

    void messageError() throws InterruptedException;

    void updateUser(AdminData adminData) throws InterruptedException;

    void addUser(AdminData adminData) throws InterruptedException;

    void clearAddFields() throws InterruptedException;

    void clearUpdateFields() throws InterruptedException;

    boolean isValid();

    String generateUniqueUsername();

    void handleDeleteUser() throws InterruptedException;

    void cancelDeleteUser() throws InterruptedException;

    void deleteSelectedUser() throws InterruptedException;
}

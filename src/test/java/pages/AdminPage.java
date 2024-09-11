package pages;

import config.ConfigSystem;
import model.AdminData;
import service.AdminService;
import service.impl.AdminServiceImpl;

public class AdminPage {
    private final AdminService adminService;

    private AdminData adminData;

    public AdminPage() { // constructor
        this.adminService = new AdminServiceImpl();
    }

    public void setUp() throws InterruptedException {
        adminService.setDriver(ConfigSystem.setup());
    }

    public void addUser() throws InterruptedException {
        adminService.tabAdmin();

        adminService.emptyDataAdd(); // Case 1

        setupInvalidData();
//        adminService.messageError();

        adminService.clearAddFields();

        if (adminService.isValid()) {
            adminService.addUser(setupValidData());
        }

    }

    public void updateUser() throws InterruptedException {
        adminService.tabAdmin();

        adminService.emptyData(); // Case 1

        setupInvalidData();
        adminService.messageError(); // Case 2

        adminService.clearUpdateFields();

        if (adminService.isValid()) {
            adminService.updateUser(setupValidData()); // Case 3
        }
    }


    public void deleteUser() throws InterruptedException {
        adminService.tabAdmin();
//        AdminService adminService = new AdminServiceImpl();
        adminService.handleDeleteUser();
    }


    public void cancelDeleteUser() throws InterruptedException {
        adminService.tabAdmin();
        adminService.cancelDeleteUser();
    }

    public void deleteSelectedUser() throws InterruptedException {
        adminService.tabAdmin();
        adminService.deleteSelectedUser();
    }
    /**
     * setup invalid data
     */
    private void setupInvalidData() {
        adminService.setAdminData(AdminData.builder()
                .role(3)
                .status(3)
                .employee(2)
                .username("hack")
                .password("Hack")
                .confirmPassword("Mismatch")
                .build());
    }

    /**
     * setup valid data
     */
    private AdminData setupValidData() {
        return AdminData.builder()
                .role(3)
                .status(3)
                .employee(2)
                .username(adminService.generateUniqueUsername())
                .password("ValidPass1")
                .confirmPassword("ValidPass1")
                .build();
    }
}

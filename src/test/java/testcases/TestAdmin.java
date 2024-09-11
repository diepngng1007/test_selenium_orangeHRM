package testcases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AdminPage;

public class TestAdmin {
    private final AdminPage admin;

    public TestAdmin() {
        this.admin = new AdminPage();
    }

    @BeforeEach
    void setup() throws InterruptedException {
        admin.setUp();
    }

    @Test
    void addUser() throws InterruptedException {
        admin.addUser();
    }

    @Test
    void updateUser() throws InterruptedException {
        admin.updateUser();
    }

    @Test
    void deleteUser() throws InterruptedException {
//        AdminData adminData = new AdminData();
        admin.deleteUser();
    }

    @Test
    void cancelDeleteUser() throws InterruptedException {
        admin.cancelDeleteUser();
    }

    @Test
    void deleteSelectedUser() throws InterruptedException {
        admin.deleteSelectedUser();
    }
}

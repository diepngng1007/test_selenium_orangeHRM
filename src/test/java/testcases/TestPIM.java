package testcases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.PimPage;

public class TestPIM {
    private final PimPage pimPage;

    public TestPIM(){
        this.pimPage = new PimPage();
    }

    @BeforeEach
    void setup() throws InterruptedException {
        pimPage.setUp();
    }

    @Test
    void addEmployee() throws InterruptedException {
        pimPage.addEmployee();
    }

    @Test
    void saveChangeEmployee() throws InterruptedException {
        pimPage.addEmployee();
        Thread.sleep(5000);
        pimPage.saveChangeEmployee();
    }
}

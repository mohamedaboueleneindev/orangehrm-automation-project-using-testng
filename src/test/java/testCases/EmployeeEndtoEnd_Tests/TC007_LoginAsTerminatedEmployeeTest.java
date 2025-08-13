package testCases.EmployeeEndtoEnd_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC007_LoginAsTerminatedEmployeeTest extends BaseClass{
    
    @Test(groups = {"sanity"} ,dependsOnMethods = "testCases.EmployeeEndtoEnd_Tests.TC006_TerminateEmployeeContractTest.Verify_TerminateEmployeeContract")
    public void Verify_LoginWithNewEmployee() {

        logger.info("*** Starting TC007_LoginAsTerminatedEmployeeTest ***");
        LoginPage login_page = new LoginPage(driver);
        logger.info("Entering Login Credintials...");
        login_page.enterUsername(emp_gen.getUsername());
        login_page.enterPassword(emp_gen.getPassword());
        login_page.clickLogin();
        logger.info("Validating Dashboard...");

        if (login_page.isDashboardHeaderVisible()) {

            logger.error("*** TC007_LoginAsTerminatedEmployeeTest Failed ***");
            Assert.assertTrue(false);

        } else {

            logger.info("*** TC007_LoginAsTerminatedEmployeeTest Passed ***");
            Assert.assertTrue(true);
        }
    }
}

package testCases.EmployeeEndtoEnd_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC005_LoginNewEmployeeTest extends BaseClass {

    @Test(groups = {"sanity"} ,dependsOnMethods = "testCases.EmployeeEndtoEnd_Tests.TC003_AddEmployeeTest.Verify_AddEmployee")
    public void Verify_LoginWithNewEmployee() {

        logger.info("*** Starting TC005_LoginNewEmployeeTest ***");
        LoginPage login_page = new LoginPage(driver);
        logger.info("Entering Login Credintials...");
        login_page.enterUsername(emp_gen.getUsername());
        login_page.enterPassword(emp_gen.getPassword());
        login_page.clickLogin();
        logger.info("Validating Dashboard...");

        if (login_page.isDashboardHeaderVisible()) {

            logger.info("*** TC005_LoginNewEmployeeTest Passed ***");
            Assert.assertTrue(true);

        } else {

            logger.error("*** TC005_LoginNewEmployeeTest Failed ***");
            Assert.assertTrue(false);
        }
    }

}

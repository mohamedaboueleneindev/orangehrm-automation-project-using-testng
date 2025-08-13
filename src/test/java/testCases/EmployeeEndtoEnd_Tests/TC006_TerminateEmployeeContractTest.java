package testCases.EmployeeEndtoEnd_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.EmployeeListPage;
import pageObjects.LoginPage;
import pageObjects.PimPage;
import testBase.BaseClass;

public class TC006_TerminateEmployeeContractTest extends BaseClass {

    @Test(groups = {"sanity"} ,dependsOnMethods = "testCases.EmployeeEndtoEnd_Tests.TC003_AddEmployeeTest.Verify_AddEmployee")
    public void Verify_TerminateEmployeeContract() {

        logger.info("*** Starting TC006_TerminateEmployeeContractTest ***");
        LoginPage login_page = new LoginPage(driver);
        logger.info("Entering Login Credintials...");
        login_page.enterUsername(properties.getProperty("username"));
        login_page.enterPassword(properties.getProperty("password"));
        login_page.clickLogin();

        DashboardPage dash_Page = new DashboardPage(driver);
        dash_Page.clickPIM();
        PimPage pimPage = new PimPage(driver);
        pimPage.clickEmployeeList();

        EmployeeListPage employeeListPage = new EmployeeListPage(driver);
        logger.info("Searching for Employee...");
        employeeListPage.enterEmployeeName(
                emp_gen.getFirstname() + " " + emp_gen.getMiddlename() + " " + emp_gen.getLastname());
        employeeListPage.clickSearch();
        logger.info("Editing Employee details...");
        employeeListPage.clickSearchedEmployeeDetails();
        employeeListPage.clickJobDetails();

        logger.info("Terminating Employee contract...");
        employeeListPage.clickTerminateEmployment();
        employeeListPage.enterTerminationDate(emp_gen.getDate());
        employeeListPage.selectTerminationReason();
        employeeListPage.clickSaveTermination();
        logger.info("Validating Employee contract termination...");

        if (employeeListPage.isTerminationSuccessfull()) {

            logger.info("*** TC006_TerminateEmployeeContractTest Passed ***");
            Assert.assertTrue(true);

        } else {

            logger.error("*** TC006_TerminateEmployeeContractTest Failed ***");
            Assert.assertTrue(false);
        }
    }

}

package testCases.EmployeeEndtoEnd_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddEmployeePage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PimPage;
import testBase.BaseClass;

public class TC003_AddEmployeeTest extends BaseClass {

    @Test(groups = {"smoke"} ,dependsOnMethods = "testCases.login_Tests.TC001_LoginTest.Verify_Login")
    public void Verify_AddEmployee() {

        logger.info("*** Starting TC003_AddEmployeeTest ***");
        LoginPage login_page = new LoginPage(driver);
        logger.info("Entering Login Credintials...");
        login_page.enterUsername(properties.getProperty("username"));
        login_page.enterPassword(properties.getProperty("password"));
        login_page.clickLogin();

        DashboardPage dash_Page = new DashboardPage(driver);
        dash_Page.clickPIM();
        PimPage pimPage = new PimPage(driver);
        pimPage.clickAddEmployee();
        logger.info("Adding new Employee...");

        AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
        logger.info("Entering Employee data...");
        addEmployeePage.enterFirstname(emp_gen.getFirstname());
        addEmployeePage.enterMiddlename(emp_gen.getMiddlename());
        addEmployeePage.enterLastname(emp_gen.getLastname());

        addEmployeePage.enableLogin();
        logger.info("Entering Employee Login Credintials...");
        addEmployeePage.enterUsername(emp_gen.getUsername());
        addEmployeePage.enterPassword(emp_gen.getPassword());
        addEmployeePage.enterConfirmPassword(emp_gen.getPassword());
        addEmployeePage.clickSave();
        logger.info("Validating Success message...");

        if (addEmployeePage.isSuccessMsgAppeared()) {

            logger.info("*** TC003_AddEmployeeTest Passed ***");
            Assert.assertTrue(true);

        } else {

            logger.error("*** TC003_AddEmployeeTest Failed ***");
            Assert.assertTrue(false);
        }
    }
}

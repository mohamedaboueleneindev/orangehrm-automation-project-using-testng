package testCases.EmployeeEndtoEnd_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.DashboardPage;
import pageObjects.EmployeeListPage;
import pageObjects.LoginPage;
import pageObjects.PimPage;
import testBase.BaseClass;

public class TC004_SearchforEmployeeTest extends BaseClass{

    @Test(groups = {"sanity"} ,dependsOnMethods = "testCases.EmployeeEndtoEnd_Tests.TC003_AddEmployeeTest.Verify_AddEmployee")
    public void Verify_SearchEmployee() {

        logger.info("*** Starting TC004_SearchforEmployeeTest ***");
        LoginPage login_page = new LoginPage(driver);
        logger.info("Entering Login Credintials...");
        login_page.enterUsername(properties.getProperty("username"));
        login_page.enterPassword(properties.getProperty("password"));
        login_page.clickLogin();

        DashboardPage dash_Page = new DashboardPage(driver);
        dash_Page.clickPIM();
        PimPage pimPage = new PimPage(driver);
        pimPage.clickEmployeeList();
        logger.info("Searching for Employee...");

        EmployeeListPage employeeListPage = new EmployeeListPage(driver);
        employeeListPage.enterEmployeeName(emp_gen.getFirstname()+" "+emp_gen.getMiddlename()+" "+emp_gen.getLastname());
        employeeListPage.clickSearch();
        logger.info("Validating Employee search result...");

        if (employeeListPage.confirmNameSearch(emp_gen.getFirstname(),emp_gen.getMiddlename(),emp_gen.getLastname())) {
            
            logger.info("*** TC004_SearchforEmployeeTest Passed ***");
            Assert.assertTrue(true);

        } else {

            logger.error("*** TC004_SearchforEmployeeTest Failed ***");
            Assert.assertTrue(false);
        }
    }
}

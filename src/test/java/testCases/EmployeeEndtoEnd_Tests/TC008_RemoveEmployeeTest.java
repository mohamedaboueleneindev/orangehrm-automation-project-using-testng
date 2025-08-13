package testCases.EmployeeEndtoEnd_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.EmployeeListPage;
import pageObjects.LoginPage;
import pageObjects.PimPage;
import testBase.BaseClass;

public class TC008_RemoveEmployeeTest extends BaseClass{
     

    @Test(groups = {"functional"} ,dependsOnMethods = "testCases.EmployeeEndtoEnd_Tests.TC003_AddEmployeeTest.Verify_AddEmployee")
    public void Verify_AddEmployee(){

        logger.info("*** Starting TC008_RemoveEmployeeTest ***");
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
        employeeListPage.enterEmployeeName(emp_gen.getFirstname()+" "+emp_gen.getMiddlename()+" "+emp_gen.getLastname());
        logger.info("Enabling Past and current Employee option...");
        employeeListPage.clickIncludeCurrentAndPast();
        employeeListPage.clickSearch();
        logger.info("Deleting Empolyee...");
        employeeListPage.clickDeleteEmployee();
        logger.info("Validating Empolyee deletion...");

        if (employeeListPage.isDeletingSuccesful()) {
            
            logger.info("*** TC008_RemoveEmployeeTest Passed ***");
            Assert.assertTrue(true);

        } else {

            logger.error("*** TC008_RemoveEmployeeTest Failed ***");
            Assert.assertTrue(false);
        }
        
    }
}

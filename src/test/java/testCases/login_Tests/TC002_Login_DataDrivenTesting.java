package testCases.login_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC002_Login_DataDrivenTesting extends BaseClass {

    static int counter = 1;

    @Test(groups = {"functional"}, dataProvider = "loginData", dataProviderClass = DataProviders.class, 
    dependsOnMethods = "testCases.login_Tests.TC001_LoginTest.Verify_Login")
    public void Verify_Login_with_dataDrivenTesting(String username, String password, String expected) {

        logger.info("*** Starting TC002_Login_DataDrivenTesting [" + counter + "]***");
        logger.info(counter);
        LoginPage login_page = new LoginPage(driver);
        logger.info("Entering Login Credintials...");
        logger.info(username);
        logger.info(password);
        login_page.enterUsername(username);
        login_page.enterPassword(password);
        login_page.clickLogin();
        logger.info("Validating Dashboard...");
        counter++;

        if (expected.equalsIgnoreCase("pass")) {

            if (login_page.isDashboardHeaderVisible()) {

                logger.info("*** TC002_Login_DataDrivenTesting [" + counter + "] Passed ***");
                DashboardPage dash_page = new DashboardPage(driver);
                dash_page.clickProfileMenu();
                dash_page.clickLogout();
                Assert.assertTrue(true);

            } else {

                logger.error("*** TC002_Login_DataDrivenTesting [" + counter + "] Failed ***");
                Assert.assertTrue(false);
            }

        } else {
            
            if (!login_page.isDashboardHeaderVisible()) {
                logger.info("*** TC002_Login_DataDrivenTesting [" + counter + "] Passed ***");
                Assert.assertTrue(true);

            } else {

                logger.error("*** TC002_Login_DataDrivenTesting [" + counter + "] Failed ***");
                DashboardPage dash_page = new DashboardPage(driver);
                dash_page.clickProfileMenu();
                dash_page.clickLogout();
                Assert.assertTrue(false);
            }
        }
    }
}

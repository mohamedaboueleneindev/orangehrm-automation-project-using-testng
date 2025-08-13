package testCases.login_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001_LoginTest extends BaseClass{

    @Test(groups = {"smoke"})
    public void Verify_Login(){

        logger.info("*** Starting TC001_LoginTest ***");
        LoginPage login_page = new LoginPage(driver);
        logger.info("Entering Login Credintials...");
        login_page.enterUsername(properties.getProperty("username"));
        login_page.enterPassword(properties.getProperty("password"));
        login_page.clickLogin();
        logger.info("Validating Dashboard...");

        if (login_page.isDashboardHeaderVisible()) {

            logger.info("*** TC001_LoginTest Passed ***");
            Assert.assertTrue(true);
            
        } else {
            
            logger.error("*** TC001_LoginTest Failed ***");
            Assert.assertTrue(false);
        }
    } 
}

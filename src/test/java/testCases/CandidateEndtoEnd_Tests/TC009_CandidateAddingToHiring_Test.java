package testCases.CandidateEndtoEnd_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CandidatesPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.RecruitmentPage;
import pageObjects.VacanciesPage;
import testBase.BaseClass;

public class TC009_CandidateAddingToHiring_Test extends BaseClass {

    @Test(groups = {"smoke"} ,dependsOnMethods = "testCases.login_Tests.TC001_LoginTest.Verify_Login")
    public void Validate_AddingVacancy() {

        logger.info("*** Starting TC009_CandidateAddingToHiring_Test ***");
        logger.info("* Starting Validate_AddingVacancy test *");
        LoginPage login_page = new LoginPage(driver);
        logger.info("Entering Login Credintials...");
        login_page.enterUsername(properties.getProperty("username"));
        login_page.enterPassword(properties.getProperty("password"));
        login_page.clickLogin();

        DashboardPage dash_Page = new DashboardPage(driver);
        dash_Page.clickRecruitment();
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.clickVacancies();
        VacanciesPage vacanciesPage = new VacanciesPage(driver);

        logger.info("Adding new Vacancy...");
        vacanciesPage.clickAddVacancy();
        logger.info("Entering Vacancy data...");
        vacanciesPage.enterVacancyName(can_gen.getVacancy());
        vacanciesPage.selectJobTitle();
        vacanciesPage.selectFirstHiringManager();
        vacanciesPage.clickSave();
        logger.info("Validating added vacancy...");

        if (vacanciesPage.isSuccessMsgAppeared()) {

            logger.info("*  Validate_AddingVacancy test Passed  *");
            Assert.assertTrue(true);

        } else {

            logger.error("*  Validate_AddingVacancy test Failed  *");
            Assert.assertTrue(false);
        }
    }

    @Test(groups = {"smoke"}, dependsOnMethods = "Validate_AddingVacancy")
    public void Validate_AddingCandidate() throws InterruptedException {

        logger.info("* Starting Validate_AddingCandidate test *");
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.clickCandidates();
        CandidatesPage candidatesPage = new CandidatesPage(driver);

        logger.info("Adding new Candidate...");
        candidatesPage.clickAddCandidate();
        logger.info("Entering Candidate data...");
        candidatesPage.enterFirstname(can_gen.getFirstname());
        candidatesPage.enterMiddlename(can_gen.getMiddlename());
        candidatesPage.enterLastname(can_gen.getLastname());
        candidatesPage.enterVacancyName(can_gen.getVacancy());
        candidatesPage.enterEmail(can_gen.getEmail());
        candidatesPage.clickSave();
        logger.info("Validating added vacancy...");

        if (candidatesPage.isSuccessMsgAppeared()) {

            logger.info("*  Validate_AddingCandidate test Passed  *");
            Assert.assertTrue(true);

        } else {

            logger.error("*  Validate_AddingCandidate test Failed  *");
            Assert.assertTrue(false);
        }
    }

    @Test(groups = {"functional"},dependsOnMethods = "Validate_AddingCandidate")
    public void Validate_AddCandidateToShortList() {

        logger.info("* Starting Validate_AddCandidateToShortList test *");
        CandidatesPage candidatesPage = new CandidatesPage(driver);
        logger.info("Adding Candidate to the shortlist...");
        candidatesPage.clickShortlist();
        logger.info("Validating adding the Candidate to the shortlist...");

        if (candidatesPage.isSuccessMsgAppeared()) {

            logger.info("*  Validate_AddCandidateToShortList test Passed  *");
            Assert.assertTrue(true);

        } else {

            logger.error("*  Validate_AddCandidateToShortList test Failed  *");
            Assert.assertTrue(false);
        }

    }

    @Test(groups = {"functional"},dependsOnMethods = "Validate_AddCandidateToShortList")
    public void Validate_SchedulingInterview() throws InterruptedException {

        logger.info("* Starting Validate_SchedulingInterview test *");
        CandidatesPage candidatesPage = new CandidatesPage(driver);
        logger.info("Scheduling Interview for a candidate...");
        candidatesPage.clickScheduleInterview();

        logger.info("Entering Interview details...");
        candidatesPage.enterInterviewTitle(can_gen.getInterviewTitle());
        candidatesPage.selectInterviewer();
        candidatesPage.enterDate(can_gen.getDate());
        candidatesPage.clickSave();
        logger.info("Validating Scheduling the interview...");

        if (candidatesPage.isSuccessMsgAppeared()) {

            logger.info("*  Validate_SchedulingInterview test Passed  *");
            Assert.assertTrue(true);

        } else {

            logger.error("*  Validate_SchedulingInterview test Failed  *");
            Assert.assertTrue(false);
        }

    }

    @Test(groups = {"functional"},dependsOnMethods = "Validate_SchedulingInterview")
    public void Validate_PassingInterview() throws InterruptedException {

        logger.info("* Starting Validate_PassingInterview test *");
        CandidatesPage candidatesPage = new CandidatesPage(driver);
        candidatesPage.clickMarkInterviewPassed();
        logger.info("Validating marking the interview as passed...");

        if (candidatesPage.isSuccessMsgAppeared()) {

            logger.info("*  Validate_PassingInterview test Passed  *");
            Assert.assertTrue(true);

        } else {

            logger.error("*  Validate_PassingInterview test Failed  *");
            Assert.assertTrue(false);
        }

    }

    @Test(groups = {"functional"},dependsOnMethods = "Validate_PassingInterview")
    public void Validate_OfferJob(){

        logger.info("* Starting Validate_OfferJob test *");
        CandidatesPage candidatesPage = new CandidatesPage(driver);
        candidatesPage.clickOfferJob();
        logger.info("Validating offering job...");

        if (candidatesPage.isSuccessMsgAppeared()) {

            logger.info("*  Validate_OfferJob test Passed  *");
            Assert.assertTrue(true);

        } else {

            logger.error("*  Validate_OfferJob test Passed  *");
            Assert.assertTrue(false);
        }

    }

    @Test(groups = {"functional"},dependsOnMethods = "Validate_OfferJob")
    public void Validate_HiringCandidate(){

        logger.info("* Starting Validate_HiringCandidate test *");
        CandidatesPage candidatesPage = new CandidatesPage(driver);
        candidatesPage.clickHire();
        logger.info("Validating hiring a candidate...");

        if (candidatesPage.isSuccessMsgAppeared()) {

            logger.info("*  Validate_HiringCandidate test Passed  *");
            logger.info("*** Ending TC009_CandidateAddingToHiring_Test ***");
            Assert.assertTrue(true);

        } else {

            logger.error("*  Validate_HiringCandidate test Failed  *");
            logger.info("*** Ending TC009_CandidateAddingToHiring_Test ***");
            Assert.assertTrue(false);
        }
    }
}
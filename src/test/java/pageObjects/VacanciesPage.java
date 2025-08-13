package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VacanciesPage extends BasePage {

    public VacanciesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//button[normalize-space()='Add']")
    private WebElement buttonAddVacancies;

    @FindBy (xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement txtVacancyName;

    @FindBy (css = ".oxd-select-text--after")
    private WebElement selectJobTitle;

    @FindBy (xpath = "(//div[@role='option'])[2]")
    private WebElement selectFirstJobTitle;

    @FindBy (css = ".oxd-userdropdown-name")
    private WebElement txtAdminName;

    @FindBy (css = "input[placeholder='Type for hints...']")
    private WebElement txtHiringManager;


    @FindBy (xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/div[1]/div/div[2]/div/div[2]/div[2]")
    private WebElement selectFirstHiringManager;

    @FindBy (css = "button[type='submit']")
    private WebElement buttonSave;

    @FindBy (xpath  = "//h6[normalize-space()='Edit Vacancy']")
    private WebElement msgSuccess;


    public void clickAddVacancy() {
        waitForElementToBeClickable(buttonAddVacancies).click();;
    }

    public void enterVacancyName(String name) {
        waitForElementToBeClickable(txtVacancyName).sendKeys(name);
    }

    public void selectJobTitle(){
        waitForElementToBeClickable(selectJobTitle).click();
        waitForElementToBeClickable(selectFirstJobTitle).click();
    }

    public void selectFirstHiringManager () {
        String adminName = waitForElementVisibility(txtAdminName).getText();
        String firstChar = adminName.substring(0, 1);
        waitForElementToBeClickable(txtHiringManager).sendKeys(firstChar);
        waitForElementToBeClickable(selectFirstHiringManager).click();
    }

    public void clickSave(){
        waitForElementToBeClickable(buttonSave).click();
    }

    public boolean isSuccessMsgAppeared(){
        try {
            waitForElementToBeClickable(msgSuccess);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CandidatesPage extends BasePage{
    
    public CandidatesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//button[normalize-space()='Add']")
    private WebElement buttonAddCandidate;

    @FindBy (name = "firstName")
    private WebElement txtFirstName;

    @FindBy (name = "middleName")
    private WebElement txtmMidleName;

    @FindBy (css = "input[placeholder='Last Name']")
    private WebElement txtmLastName;

    @FindBy (css = ".oxd-icon.bi-caret-down-fill.oxd-select-text--arrow")
    private WebElement selectVacancy;

    private By allVacancies = By.xpath("//div[@role='option']/span");

    @FindBy (xpath = "(//input[@placeholder='Type here'])[1]")
    private WebElement txtEmail;

    @FindBy (css = "button[type='submit']")
    private WebElement buttonSave;

    @FindBy (xpath = "(//div[@class='oxd-toast-content oxd-toast-content--success'])[1]")
    private WebElement msgAddCandidateSuccess;

    @FindBy (xpath = "//button[normalize-space()='Shortlist']")
    private WebElement buttonShortlist;

    @FindBy (xpath = "//button[normalize-space()='Reject']")
    private WebElement buttonReject;

    @FindBy(xpath = "//button[normalize-space()='Schedule Interview']")
    private WebElement buttonInterviw;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[6]")
    private WebElement txtInterviewTitle;

    @FindBy (xpath = "//input[@placeholder='Type for hints...']")
    private WebElement txtInterviewer;

    @FindBy (xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/input[1]")
    private WebElement txtDate;

    @FindBy (xpath = "(//input[@class='oxd-input oxd-input--active'])[4]")
    private WebElement txtHiringManager;

    @FindBy (xpath  = "(//div[@role='option'])[2]")
    private WebElement selectInterviewer;

    @FindBy (css = "button[class='oxd-button oxd-button--medium oxd-button--success']")
    private WebElement buttonInterviewPass;

    @FindBy (xpath = "//button[normalize-space()='Mark Interview Failed']")
    private WebElement buttonInterviewFail;

    @FindBy (xpath = "//button[normalize-space()='Offer Job']")
    private WebElement buttonOfferJob;

    @FindBy (xpath = "//button[normalize-space()='Hire']")
    private WebElement buttonHire;

    @FindBy (xpath = "//button[normalize-space()='Offer Declined']")
    private WebElement buttonOfferDeclined;

    @FindBy (css = "textarea[placeholder='Type here']")
    private WebElement txtnotes;
    

    @FindBy (css = ".oxd-form-loader")
    private WebElement formloader;

    public void clickAddCandidate(){
        waitForElementToBeClickable(buttonAddCandidate).click();
    }

    public void enterFirstname(String name){

        waitForElementVisibility(txtFirstName).sendKeys(name);
    }

    public void enterMiddlename(String name){
        waitForElementVisibility(txtmMidleName).sendKeys(name);
    }

    public void enterLastname(String name){
        waitForElementVisibility(txtmLastName).sendKeys(name);
    }

    public void enterVacancyName (String name) {
        waitForElementToBeClickable(selectVacancy).click();
        List<WebElement> vacancies = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allVacancies));
       for (WebElement vacancy : vacancies) {
            if (vacancy.getText().equals(name)) {
                waitForElementToBeClickable(vacancy).click();
                break;
            }
       }
    }

    public void enterEmail(String Email){
        waitForElementToBeClickable(txtEmail).sendKeys(Email);
    }

    public void clickSave() {
        waitForElementToBeClickable(buttonSave).click();
    }

    public boolean isSuccessMsgAppeared(){
        return isElementVisible(msgAddCandidateSuccess);
    }

    public void clickShortlist (){
        waitForElementToBeClickable(buttonShortlist).click();
        wait.until(ExpectedConditions.invisibilityOf(formloader));
        waitForElementVisibility(txtnotes).sendKeys("shortlisted");
        wait.until(ExpectedConditions.invisibilityOf(formloader));
        waitForElementToBeClickable(buttonSave).click();
    }

    public void clickScheduleInterview (){
        waitForElementToBeClickable(buttonInterviw).click();
    }

    public void enterInterviewTitle(String title){
        waitForElementVisibility(txtInterviewTitle).sendKeys(title);
    }

    public void selectInterviewer(){
        waitForElementToBeClickable(txtInterviewer).sendKeys("a");
        waitForElementToBeClickable(selectInterviewer).click();
    }

    public void enterDate(String date){
        waitForElementVisibility(txtDate).sendKeys(date);
    }

    public void clickMarkInterviewPassed(){
        waitForElementToBeClickable(buttonInterviewPass).click();
        wait.until(ExpectedConditions.invisibilityOf(formloader));
        waitForElementVisibility(txtnotes).sendKeys("passed");
        wait.until(ExpectedConditions.invisibilityOf(formloader));
        waitForElementToBeClickable(buttonSave).click();
    }

    public void clickOfferJob(){
        waitForElementToBeClickable(buttonOfferJob).click();
        wait.until(ExpectedConditions.invisibilityOf(formloader));
        waitForElementVisibility(txtnotes).sendKeys("jop offer");
        wait.until(ExpectedConditions.invisibilityOf(formloader));
        waitForElementToBeClickable(buttonSave).click();
    }

    public void clickHire() {
        waitForElementToBeClickable(buttonHire).click();
        wait.until(ExpectedConditions.invisibilityOf(formloader));
        waitForElementVisibility(txtnotes).sendKeys("Hired");
        wait.until(ExpectedConditions.invisibilityOf(formloader));
        waitForElementToBeClickable(buttonSave).click();
    }
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeListPage extends BasePage {

    public EmployeeListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
    private WebElement txtEmployeeName;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement txtEmployeeId;

    @FindBy(xpath = "(//div[@class='oxd-table-card'])[1]")
    private WebElement rowSearchResult;

    @FindBy(xpath = "(//div[@role='cell'])[2]/div")
    private WebElement idSearchResult;

    @FindBy(xpath = "(//div[@role='cell'])[3]/div")
    private WebElement firstMiddleNameSearchResult;

    @FindBy(xpath = "(//div[@role='cell'])[4]/div")
    private WebElement LastNameSearchResult;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonSubmitSearch;

    @FindBy(xpath = "//a[normalize-space()='Job']")
    private WebElement menuJob;

    @FindBy(css = "button[title='Terminate Employment']")
    private WebElement buttonTerminate;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
    private WebElement buttonTerminateDate;

    @FindBy(xpath = "(//div[@class='oxd-select-text--after'])[6]")
    private WebElement buttonTerminateReason;

    @FindBy(xpath = "(//div[@role='option'])[8]")
    private WebElement buttonTerminateReason_resigned;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement buttonTerminateSave;

    @FindBy(xpath = "//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")
    private WebElement msgTerminateSuccess;

    @FindBy(xpath = "(//div[@class='oxd-select-text--after'])[2]")
    private WebElement buttonInclude;

    @FindBy(xpath = "(//div[@role='option'])[2]")
    private WebElement optionCurrentAndPast;

    @FindBy(xpath = "(//i[@class='oxd-icon bi-trash'])[1]")
    private WebElement buttonRemoveEmployee;

    @FindBy(xpath = "(//button[normalize-space()='Yes, Delete'])[1]")
    private WebElement buttonConfirmRemoveEmployee;

    @FindBy(xpath = "(//div[@class='oxd-toast-content oxd-toast-content--success'])[1]")
    private WebElement msgRemoveEmployeeSuccess;

    public void enterEmployeeName(String name) {
        waitForElementVisibility(txtEmployeeName).sendKeys(name);
    }

    public void clickSearch() {

        waitForElementToBeClickable(buttonSubmitSearch).click();
    }

    public boolean confirmNameSearch(String first, String middle, String last) {
        if (!isElementVisible(firstMiddleNameSearchResult)) {
            return false;
        }
        ;
        return firstMiddleNameSearchResult.getText().equals(first + " " + middle)
                && LastNameSearchResult.getText().contains(last);
    }

    public void clickSearchedEmployeeDetails() {
        waitForElementToBeClickable(rowSearchResult).click();
    }

    public void clickJobDetails() {
        waitForElementToBeClickable(menuJob).click();
    }

    public void clickTerminateEmployment() {
        waitForElementToBeClickable(buttonTerminate).click();
    }

    public void enterTerminationDate(String date) {
        waitForElementVisibility(buttonTerminateDate).sendKeys(date);
    }

    public void selectTerminationReason() {
        waitForElementToBeClickable(buttonTerminateReason).click();
        waitForElementToBeClickable(buttonTerminateReason_resigned).click();
    }

    public void clickSaveTermination() {
        waitForElementToBeClickable(buttonTerminateSave).click();
        ;
    }

    public void clickDeleteEmployee() {
        waitForElementToBeClickable(buttonRemoveEmployee).click();
        waitForElementToBeClickable(buttonConfirmRemoveEmployee).click();
    }

    public void clickIncludeCurrentAndPast() {
        waitForElementToBeClickable(buttonInclude).click();
        waitForElementToBeClickable(optionCurrentAndPast).click();
    }

    public boolean isTerminationSuccessfull() {
        return isElementVisible(msgTerminateSuccess);
    }

    public boolean isDeletingSuccesful() {
        return isElementVisible(msgRemoveEmployeeSuccess);
    }

}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddEmployeePage extends BasePage {

    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = ".oxd-form-loader")
    private WebElement formloader;

    @FindBy(name = "firstName")
    private WebElement txtFirstName;

    @FindBy(name = "middleName")
    private WebElement txtMiddleName;

    @FindBy(name = "lastName")
    private WebElement txtLastName;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement txtEmployeeID;

    @FindBy(css = ".oxd-switch-wrapper")
    private WebElement buttonEnableLogin;

    @FindBy(xpath  = "(//input[@autocomplete='off'])[1]")
    private WebElement txtUserName;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement txtPassword;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement txtConfirmPassword;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonSave;

    @FindBy(xpath  =  "(//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast'])[1]")
    private WebElement msgSuccess;


    public void enterFirstname(String name){
        waitForElementToBeClickable(txtFirstName).sendKeys(name);
    }

    public void enterMiddlename(String name){
        waitForElementToBeClickable(txtMiddleName).sendKeys(name);
    }

    public void enterLastname(String name){
        waitForElementToBeClickable(txtLastName).sendKeys(name);
    }
    

    public void enableLogin(){
        wait.until(ExpectedConditions.invisibilityOf(formloader));
        waitForElementToBeClickable(buttonEnableLogin).click();
    }

    public void enterUsername(String name){
        waitForElementVisibility(txtUserName).sendKeys(name);
    }

    public void enterPassword(String pass){
        waitForElementVisibility(txtPassword).sendKeys(pass);
    }

    public void enterConfirmPassword(String pass){
        waitForElementVisibility(txtConfirmPassword).sendKeys(pass);
    }

    public void clickSave(){
        waitForElementToBeClickable(buttonSave).click();;
    }

    public boolean isSuccessMsgAppeared(){
        return isElementVisible(msgSuccess);
    }


}

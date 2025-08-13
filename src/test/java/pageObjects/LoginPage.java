package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "username")
    private WebElement txtUsername;

    @FindBy(name = "password")
    private WebElement txtPassword;

    @FindBy(css = "button[type='submit']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//h6[normalize-space()='Dashboard']") 
    WebElement dashboardHeader;

    @FindBy(css = "div[role='alert']")
    private WebElement msgError;

    @FindBy(xpath  = "//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")
    private WebElement msgUsernameError;
    
    @FindBy(xpath  = "//div[@class='orangehrm-login-form']//div[2]//div[1]//span[1]")
    private WebElement msgPasswordError;

    
    public void enterUsername(String name) {
        waitForElementVisibility(txtUsername);
        txtUsername.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        txtUsername.sendKeys(Keys.DELETE) ;
        txtUsername.sendKeys(name);
    }

    public void enterPassword(String password) {
        waitForElementVisibility(txtPassword);
        txtPassword.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        txtPassword.sendKeys(Keys.DELETE) ;
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        waitForElementToBeClickable(buttonLogin);
        buttonLogin.click();
    }

    public Boolean isDashboardHeaderVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
            wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(dashboardHeader),
                ExpectedConditions.visibilityOf(msgError),
                ExpectedConditions.visibilityOf(msgUsernameError),
                ExpectedConditions.visibilityOf(msgPasswordError)
        ));

        try {
            dashboardHeader.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}

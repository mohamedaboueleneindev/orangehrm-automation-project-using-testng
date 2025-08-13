package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{
    
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".oxd-userdropdown-tab") 
    private WebElement buttonProfileMenu;

    @FindBy(xpath = "//a[normalize-space()='Logout']") 
    private WebElement buttonLogout;

    @FindBy(xpath = "//span[normalize-space()='PIM']") 
    private WebElement menuPIM;

    @FindBy(xpath = "//span[normalize-space()='Recruitment']") 
    private WebElement menuRecruitment;

    public void clickProfileMenu (){
        waitForElementToBeClickable(buttonProfileMenu).click();;
    }

    public void clickLogout (){
        waitForElementToBeClickable(buttonLogout).click();
    }

    public void clickPIM(){
        waitForElementToBeClickable(menuPIM).click();
    }

    public void clickRecruitment(){
        waitForElementToBeClickable(menuRecruitment).click();
    }

}

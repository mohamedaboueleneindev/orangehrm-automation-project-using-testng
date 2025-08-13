package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PimPage extends BasePage {

    public PimPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Employee List']")
    private WebElement menuEmployeeList;

    @FindBy(xpath = "//a[normalize-space()='Add Employee']")
    private WebElement menuAddEmployee;

    public void clickAddEmployee() {
        waitForElementToBeClickable(menuAddEmployee).click();
    }

    public void clickEmployeeList() {
        waitForElementToBeClickable(menuEmployeeList).click();
    }

}

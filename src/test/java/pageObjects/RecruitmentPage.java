package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruitmentPage extends BasePage {

    public RecruitmentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//nav[@aria-label='Topbar Menu']//ul/li[1]")
    private WebElement menuCandidates;

    @FindBy(xpath = "//nav[@aria-label='Topbar Menu']//ul/li[2]")
    private WebElement menuVacancies;

    public void clickCandidates() {
        waitForElementToBeClickable(menuCandidates).click();
    }

    public void clickVacancies() {
        waitForElementToBeClickable(menuVacancies).click();
    }
}
package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class GmailInBoxPage extends AbstractPageObject {

    public GmailInBoxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getUniqueElement() {
        return nextButtonLocator;
    }


    @FindBy(xpath="//a[contains(@href,'https://accounts.google.com/SignOutOptions') ]")
    WebElement LogoLocator;

    @FindBy(xpath="//input[@name='q']")
    WebElement searchInputLocator;

    @FindBy(id="gb_71")
    WebElement SignoutButtonLocator;

    @FindBy(xpath="//span[text()='Next']")
    WebElement nextButtonLocator;


    public Boolean isLogoDisplayed() {
        logger.info("Check if logo is present.");
        return LogoLocator.isDisplayed();
    }


    public void clickLogo() {
        logger.info("click logo.");
        waitForElementVisibleAndEnabled(LogoLocator);
        LogoLocator.click();
    }
    public void clickSignOut(){
        logger.info("click Sign out button.");
        waitForElementVisibleAndEnabled(SignoutButtonLocator);
        SignoutButtonLocator.click();
    }
}

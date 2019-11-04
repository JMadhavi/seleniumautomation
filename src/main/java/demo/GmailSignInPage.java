package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailSignInPage extends AbstractPageObject {

    public GmailSignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getUniqueElement() {
        return nextButtonLocator;
    }


    @FindBy(id="identifierId")
    WebElement LoginInputLocator ;

    @FindBy( xpath="//span[text()='Next']")
    WebElement NextButtonLocator;

    @FindBy(name= "password")
    WebElement PasswordInputLocator;

    @FindBy(xpath="//span[text()='Next']")
    WebElement nextButtonLocator;


    public void setLogin(String setLoginText) {
        logger.info("Set user name value.");
        waitForElementVisibleAndEnabled(LoginInputLocator);
        LoginInputLocator.sendKeys(setLoginText);

    }
    public void clickNextButton() {
        logger.info("Click Next button.");
        waitForElementVisibleAndEnabled(NextButtonLocator);
        NextButtonLocator.click();
    }
    public void setPassword(String setPasswordText) {
        logger.info("Set password.");
        waitForElementVisibleAndEnabled(PasswordInputLocator);
        PasswordInputLocator.sendKeys(setPasswordText);
    }





}





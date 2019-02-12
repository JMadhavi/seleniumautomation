package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailSignInPage extends AbstractPageObject {

    public GmailSignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getUniqueElement() {
        return By.xpath("//span[text()='Next']");
    }

    By LoginInputLocator = By.id("identifierId");

    By NextButtonLocator = By.xpath("//span[text()='Next']");

    By PasswordInputLocator = By.name("password");



    public void setLogin(String setLoginText) {
        logger.info("Set user name value.");
        waitForElementVisibleAndEnabled(LoginInputLocator);
        driver.findElement(LoginInputLocator).sendKeys(setLoginText);
    }


    public void clickNextButton() {
        logger.info("Click Next button.");
        waitForElementVisibleAndEnabled(NextButtonLocator);
        driver.findElement(NextButtonLocator).click();

    }

    public void setPassword(String setPasswordText) {
        logger.info("Set password.");
        waitForElementVisibleAndEnabled(PasswordInputLocator);
        driver.findElement(PasswordInputLocator).sendKeys(setPasswordText);
    }




}





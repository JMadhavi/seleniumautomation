package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GmailInBoxPage extends AbstractPageObject {

    public GmailInBoxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getUniqueElement() {
        return By.xpath("//span[text()='Next']");
    }


    By LogoLocator = By.xpath("//a[contains(@href,'https://accounts.google.com/SignOutOptions') ]");


    By searchInputLocator = By.xpath("//input[@name='q']");

    //By LogoLocator = By.xpath("//a[contains(@href,'https://accounts.google.com/SignOutOptions') ]");

    By SignoutButtonLocator= By.id("gb_71");


    public Boolean isLogoDisplayed() {
        logger.info("Check if logo is present.");
        List<WebElement> DeviceRow = driver.findElements(LogoLocator);
        return DeviceRow.size() > 0;
    }


    public void searchText(String SearchText) {
        logger.info("search email by entering text.");
        waitForElementVisibleAndEnabled(searchInputLocator);
        driver.findElement(searchInputLocator).sendKeys(SearchText);
    }


    public void clickEnterKey() {
        logger.info("Click Enter key.");
        waitForElementVisibleAndEnabled(searchInputLocator);
        driver.findElement(searchInputLocator).sendKeys(Keys.RETURN);

    }


    public void clickLogo() {
        logger.info("click logo.");
        waitForElementVisibleAndEnabled(LogoLocator);
        driver.findElement(LogoLocator).click();
    }
    public void clickSignOut(){
        logger.info("click Sign out button.");
        waitForElementVisibleAndEnabled(SignoutButtonLocator);
        driver.findElement(SignoutButtonLocator).click();
    }
}

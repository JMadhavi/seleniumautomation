package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPageObject {

    protected WebDriver driver;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    public AbstractPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        isLoaded();
    }

    protected abstract WebElement getUniqueElement();

    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(getUniqueElement()));
        wait.until(ExpectedConditions.elementToBeClickable(getUniqueElement()));

    }

    public void waitForElementVisibleAndEnabled(By by){
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementVisibleAndEnabled(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void pause(Integer milliseconds){
        try{
            TimeUnit.MICROSECONDS.sleep(milliseconds);

        }catch(InterruptedException e){
            e.printStackTrace();

        }

    }

}

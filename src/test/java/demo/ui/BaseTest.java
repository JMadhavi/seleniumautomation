package demo.ui;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected static final String WEB_SERVER = System.getProperty("url", "http://gmail.com");
    protected static final String BROWSER = System.getProperty("browser", "firefox");
    public static WebDriver driver;
    protected Logger logger = LoggerFactory.getLogger(getClass());


    @BeforeMethod(alwaysRun = true)
    public void setupWebDriver()  {
        setupLocalDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(WEB_SERVER);
    }

    private void setupLocalDriver() {
        if (BROWSER.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (BROWSER.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        } else if (BROWSER.equals("safari")) {
            driver = new SafariDriver();
            driver.manage().window().maximize();
        }
         else {
            throw new RuntimeException("Browser type unsupported");
        }
    }


    @AfterMethod(alwaysRun = true)
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File scrFile =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File( System.getProperty("user.dir") + "/build/screenshots/"+ testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) +  ".jpg"));
        }
        if (driver != null)
            driver.quit();

    }



}
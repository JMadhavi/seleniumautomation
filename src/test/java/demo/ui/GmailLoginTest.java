package demo.ui;
import demo.GmailInBoxPage;
import demo.GmailSignInPage;
import demo.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GmailLoginTest extends BaseTest {

    public GmailLoginTest() {
        super();
    }

    @Test(groups = {"mats"})

    public void SendEmailUsingGmailAccountTest() {
        logger.info("***Login gmail with user name and password provided in test.properties file.***");
        GmailSignInPage gmailSignInPage = new GmailSignInPage(driver);
        gmailSignInPage.setLogin(Utils.getPropertyValue("userName"));
        gmailSignInPage.clickNextButton();
        gmailSignInPage.setPassword(Utils.getPropertyValue("password"));
        gmailSignInPage.clickNextButton();
        GmailInBoxPage gmailInBoxPage = new GmailInBoxPage(driver);
        Assert.assertTrue(gmailInBoxPage.isLogoDisplayed());
        gmailInBoxPage.clickLogo();
        gmailInBoxPage.clickSignOut();

    }

}


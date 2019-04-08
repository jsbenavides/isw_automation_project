package pageTests;

import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.AfterTest;
import pages.GoogleMainPage;
import utilities.WebDriverInstance;

import org.testng.Reporter;

public class GoogleTitleTest extends WebDriverInstance {

    //Create Test Cases
    @Test
    public void verifyPageTitle(){
        GoogleMainPage testPage = new GoogleMainPage(driver);

        String pageTitle = testPage.getMainPageTitle();

        Assert.assertEquals("Google",pageTitle);
        Reporter.log("Page title is verified and proper page is open");
        driver.close();
    }

}

package pageTests;

import org.testng.annotations.Test;
import pages.GoogleMainPage;
import utilities.WebDriverInstance;
import org.testng.Assert;
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

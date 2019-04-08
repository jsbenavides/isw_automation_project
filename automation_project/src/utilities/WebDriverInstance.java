package utilities;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;


public class WebDriverInstance {

    public static WebDriver driver;

    @BeforeClass
    public static void setUpDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void verifyResults(ITestResult results){
        driver.close();
        //driver.quit();

        if (results.getStatus() == ITestResult.FAILURE){
            Reporter.log("Test Case is Fail" + results.getTestName());
        } else if (results.getStatus() == ITestResult.SKIP){
            Reporter.log("Test Case is Skipped" + results.getTestName());
        } else {
            Reporter.log("Test Case is Pass" + results.getTestName());
        }
    }
}

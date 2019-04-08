package pages;


import org.openqa.selenium.WebDriver;
import utilities.WebDriverInstance;

public class BasePage extends WebDriverInstance {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLoads(){

    }
}

package pages;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage extends BasePage {

    WebDriver driver;
    String baseURL;

    //elementos
    @FindBy(how=How.NAME,using = "q")
    WebElement searchBar;

    @FindBy(how=How.NAME,using = "btnK")
    WebElement searchButton;

    //constructor
    public GoogleMainPage(WebDriver driver){
        this.driver = driver;
        this.baseURL = "https://google.com";
    }

    public String getBaseURL(){
        return baseURL;
    }

    //acciones en la página
    public String getMainPageTitle(){
        openPage(driver,baseURL);
        return getTitle(driver);
    }

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    public void openPage(WebDriver driver, String url){
        driver.get(url);
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void sendKeys(WebElement element, String text){
        element.sendKeys(text);
    }

    public String getTitle(WebDriver driver){
        return driver.getTitle();
    }
}

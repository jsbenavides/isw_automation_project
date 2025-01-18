package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

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

    public String getCurrentURL(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public void waitClickBase(WebDriver driver, int time, String elementXpath){
        WebDriverWait wait1;
        wait1 = new WebDriverWait(driver, time);

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).click();
    }

    public String waitGetTextBase(WebDriver driver, int time, String elementXpath){
        WebDriverWait wait1;
        wait1 = new WebDriverWait(driver, time);

        return wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).getText();
    }

    public String waitGetAttributeBase(WebDriver driver, int timeout, String elementXpath, String Attribute){
        WebDriverWait wait1;
        wait1 = new WebDriverWait(driver, timeout);

        return wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).getAttribute(Attribute);
    }

    public String getElementAttribute(WebElement element, String attribute){

        return element.getAttribute(attribute);
    }

    public String getElementText(WebElement element){

        return element.getText();
    }

    public void switchToBrowserTabWithTimeout(WebDriver driver, int tabIndex, int timeout){
        //get window handlers as list
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());

        try {

            Thread.sleep(timeout);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        driver.switchTo().window(browserTabs.get(tabIndex));
    }
}

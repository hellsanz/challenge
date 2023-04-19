package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertManager {
    private WebDriver driver;
    private By triggerAlertButton = By.id("trigger-alert");
    private String alertText;

    public AlertManager(WebDriver driver) {
        this.driver = driver;
    }

    public void triggerAlert() {
        driver.findElement(triggerAlertButton).click();
    }
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }
    public String getAlertText() {
        return this.driver.switchTo().alert().getText();
    }
    public String getAlertText(WebDriver driver){
        return driver.switchTo().alert().getText();
    }

    public void sendKeysToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
    public void getAlertTextAndAccept() {
        alertText = getAlertText();
        acceptAlert();
    }
}

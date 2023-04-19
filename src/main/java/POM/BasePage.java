package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public void clickOnLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public void clickOnLink(By by) {
        driver.findElement(by).click();
    }
    public helpers.HoverManager clickHovers() {
        return new helpers.HoverManager(driver);
    }
}

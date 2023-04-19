package POM.product;

import POM.BasePage;
import helpers.AlertManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    private AlertManager alertManager = new AlertManager(driver);
    private WebElement WE_addToCartButton;
    private WebElement WE_cartButton;


    private By addToCartButton = By.linkText("Add to cart");
    private By cartButton = By.id("cartur");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.WE_addToCartButton = driver.findElement(addToCartButton);
        this.WE_cartButton = driver.findElement(cartButton);
    }

    public boolean clickOnAddToCartButton(){
        String confirm = "Product added";
        helpers.AlertManager manager = new AlertManager(driver);

        helpers.Timer.implicitSleeper(driver);
        if (WE_addToCartButton.isDisplayed()){
            WE_addToCartButton.click();
            helpers.Timer.sleeper(2);
            if (confirm.equals(manager.getAlertText(driver))){
                manager.acceptAlert();
                helpers.Timer.sleeper(2);
                if (WE_cartButton.isDisplayed()){
                    WE_cartButton.click();
                    helpers.Timer.sleeper(10);
                    return true;
                }
            }else{
                manager.acceptAlert();
                return false;
            }
        }
        return false;
    }
}

package Tests.ui.addToCart;

import POM.product.ProductPage;
import POM.home.HomePage;
import Tests.ui.BaseTest;

import org.junit.Test;

import static org.junit.Assert.*;


public class TestAddToCart extends BaseTest {

    @Test
    public void addToCartLaptop()
    {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnProduct();
        helpers.Timer.sleeper(2);

        ProductPage productPage = new ProductPage(driver);
        helpers.Timer.sleeper(2);

        assertTrue(productPage.clickOnAddToCartButton());
    }
}
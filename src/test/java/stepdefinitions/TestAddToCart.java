package stepdefinitions;

import POM.home.HomePage;
import POM.product.ProductPage;
import Tests.ui.BaseTest;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class TestAddToCart extends BaseTest {
    WebDriver driver;
    private static boolean control;

    @Given("que estoy en la página de inicio de la tienda en línea")
    public void inHomepageAddToCart() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--incognito");
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get(visit);
    }

    @When("hago clic sobre una laptop")
    public void clickToProductAddToCart() {
        // Código para hacer clic en el enlace de "Laptops"
        HomePage homePage = new HomePage(driver);
        homePage.clickOnProduct();
        helpers.Timer.sleeper(2);
    }
    @And("agrego la laptop al carrito")
    public void addingLaptopAddToCart() {
        // Código para agregar la laptop al carrito
        ProductPage productPage = new ProductPage(driver);
        helpers.Timer.sleeper(2);
        control = productPage.clickOnAddToCartButton();
    }

    @Then("veo que la laptop está en el carrito de compras")
    public void checkingAndCloseAddToCart() {
        assertTrue(control);
        driver.quit();
    }
}

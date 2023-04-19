package stepdefinitions;

import POM.home.HomePage;
import Tests.ui.BaseTest;
import helpers.AccountGenerator;
import io.cucumber.java.en.*;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.UITest;

import static org.junit.Assert.assertEquals;

public class TestSingUp extends BaseTest implements UITest {
    WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger("MyClass");
    private static String username;
    private static String password;
    private static String tempValue;
    @Given("que estoy en la página principal")
    @Category(UITest.class)
    public void inHomepageSingUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(visit);
    }

    @When("se genera el nombre y usuario")
    @Category(UITest.class)
    public void generatingAccountSingUp() {
        // generacion de usuario y contraseña aleatorios de prueba
        username = AccountGenerator.staticUser();
        password = AccountGenerator.staticPass();
    }

    @And("hago clic en el botón de registro")
    @Category(UITest.class)
    public void clickingRegisterSingUp() {
        HomePage homePage = new HomePage(driver);
        tempValue = homePage.SignUpMethod(username, password);
    }

    @Then("la cuenta es creada exitosamente")
    @Category(UITest.class)
    public void accountCreatedSingUp() {
        // Código de notificacion de creacion de cuenta exitosa
        logger.debug("creating account test passed");
        assertEquals("Sign up successful.", tempValue);
        driver.quit();
    }
}

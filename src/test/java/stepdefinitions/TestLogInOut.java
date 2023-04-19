package stepdefinitions;

import Tests.ui.BaseTest;
import helpers.AccountGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import POM.home.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.*;

public class TestLogInOut extends BaseTest{
    private WebDriver driver;
    private static String username;
    private static String password;
    private static String control;


    @Given("estando en la pagina principal")
    public void inHomepageLoginOut() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(visit);
    }

    @When("ingresando user y pass desde el popup login haciendo click en login")
    public void userPassLoginOut() {
        HomePage homePage = new HomePage(driver);
        control = homePage.logInOut(username,password);
    }

    @Then("se abre y cierra la sesión")
    public void openAndCloseAccountLoginOut() {
        assertEquals("true", control);
        driver.quit();
    }
}

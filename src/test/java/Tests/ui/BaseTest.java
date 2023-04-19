package Tests.ui;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import junit.framework.TestListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public abstract class BaseTest
{
    //? This class is a super class for all the tests. It contains the driver and the visit variable.
    protected WebDriver driver;
    protected String visit = "https://www.demoblaze.com/index.html";
    @Before
    public void setUp()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(visit);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
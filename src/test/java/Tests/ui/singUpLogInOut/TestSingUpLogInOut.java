package Tests.ui.singUpLogInOut;

import Tests.ui.BaseTest;
import helpers.AccountGenerator;
import org.junit.Test;
import POM.home.HomePage;
import static org.junit.Assert.*;


public class TestSingUpLogInOut extends BaseTest
{
    private static String username;
    private static String password;

    @Test
    public void registerAnUser()
    {
        //? in this test we are going to test the register functionality on the home page
        username = AccountGenerator.staticUser();
        password = AccountGenerator.staticPass();
        HomePage homePage = new HomePage(driver);
        assertEquals("Sign up successful.", homePage.SignUpMethod(username, password));
    }

    @Test
    public void login()
    {
        //? in this test we are going to test the register functionality on the home page
        HomePage homePage = new HomePage(driver);
        assertEquals("true", homePage.logInOut(username,password));
    }
}

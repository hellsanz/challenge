package POM.home;

import POM.BasePage;
import helpers.AlertManager;
import org.openqa.selenium.*;

public class HomePage extends BasePage {

    private WebDriver driver;

    private String message;// message to be returned by a method


    //Popup Sing Up
    private WebElement WE_buttonSignUp;
    private WebElement WE_textBoxUserSingUp;
    private WebElement WE_textBoxPasswordSingUp;
    private WebElement WE_buttonConfirmSignUp;

    //Popup Login
    private  WebElement WE_buttonLoggin;
    private WebElement WE_textBoxUserLogin;
    private WebElement WE_textBoxPassLogin;
    private WebElement WE_buttonConfirmLogin;

    //Menu
    private WebElement WE_buttonLogout;

    // Locators
    private By singUpHomePageButton = By.id("signin2");//*** First button on the home page for signing up
    private By textBoxUserSingUp= By.id("sign-username");//*** Text box for username
    private By textBoxPasswordSingUp= By.id("sign-password");//*** Text box for password
    private By singUpButtonFinish = By.xpath("/html/body/div[2]/div/div/div[3]/button[2]");//*** sing up button to finish the process
    private By loginButton = By.xpath("/html/body/nav/div[1]/ul/li[5]/a");
    private By textBoxUserLogin = By.xpath("/html/body/div[3]/div/div/div[2]/form/div[1]/input");
    private By textBoxPasswordLogin = By.xpath("/html/body/div[3]/div/div/div[2]/form/div[2]/input");
    private By loginButtonFinish = By.xpath("/html/body/div[3]/div/div/div[3]/button[2]");
    private By logoutButton = By.xpath("/html/body/nav/div[1]/ul/li[6]/a");




    // AlertManager
    private AlertManager alertManager;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;

        this.WE_buttonSignUp = driver.findElement(singUpHomePageButton);
        this.WE_textBoxUserSingUp = driver.findElement(textBoxUserSingUp);
        this.WE_textBoxPasswordSingUp = driver.findElement(textBoxPasswordSingUp);
        this.WE_buttonConfirmSignUp = driver.findElement(singUpButtonFinish);

        this.WE_buttonLoggin = driver.findElement(loginButton);
        this.WE_textBoxUserLogin = driver.findElement(textBoxUserLogin);
        this.WE_textBoxPassLogin = driver.findElement(textBoxPasswordLogin);
        this.WE_buttonConfirmLogin = driver.findElement(loginButtonFinish);

        this.WE_buttonLogout = driver.findElement(logoutButton);

    }
//helpers.Timer.implicitSleeper(driver);
    // Methods
    public String SignUpMethod(String user, String pass) {
        helpers.Timer.sleeper(1);
        if (WE_buttonSignUp.isDisplayed()) {
            WE_buttonSignUp.click();
            helpers.Timer.sleeper(2);
            if (WE_textBoxUserSingUp.isDisplayed() && WE_textBoxPasswordSingUp.isDisplayed()) {
                alertManager = new AlertManager(driver);
                WE_textBoxUserSingUp.sendKeys(user);
                WE_textBoxPasswordSingUp.sendKeys(pass);
                WE_buttonConfirmSignUp.click();
                helpers.Timer.sleeper(1);
                if (singUpCheck(alertManager.getAlertText())) {
                    return this.message;
                } else {
                    return this.message;
                }
            }else {
                System.out.println("Text boxes from PopUp-SingUp are not displayed");
                return this.message;
            }
        }else {
            System.out.println("Button SingUp from PopUp-SingUp is not displayed");
            return this.message;
        }
    }


    public String logInOut(String user, String pass){
        helpers.Timer.sleeper(2);
        if (WE_buttonLoggin.isDisplayed()){
            WE_buttonLoggin.click();
            helpers.Timer.sleeper(2);
            if (WE_textBoxUserLogin.isDisplayed() && WE_textBoxPassLogin.isDisplayed()){
                WE_textBoxUserLogin.sendKeys(user);
                WE_textBoxPassLogin.sendKeys(pass);
                if (WE_buttonConfirmLogin.isDisplayed()){
                    //LOGUEADO
                    WE_buttonConfirmLogin.click();
                    helpers.Timer.sleeper(5);
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("logOut();");
                    return "true";
                }else{
                    System.out.println("button login from PopUp-login are not displayed");
                    return this.message;
                }
            }else{
                System.out.println("Text boxes from PopUp-login are not displayed");
                return this.message;
            }
        }else {
            System.out.println("Button Login is not displayed");
            return this.message;
        }
    }

    public boolean singUpCheck(String msg) {
        this.message = msg;
        if (msg.equals("Sign up successful.")) {
            return true;
        }
        if (msg.equals("This user already exist.")) {
            //send a message
        }
        alertManager.acceptAlert();
        return false;
    }

    public void clickOnProduct(){
        helpers.Timer.implicitSleeper(driver);
        WebElement link = driver.findElement(By.linkText("Sony vaio i5"));
        link.click();
    }
}

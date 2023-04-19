package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenShot {
    private static int screenShotNumber = 0;
    public static void takingScreenShot(WebDriver driver, String name) {
        screenShotNumber++;
        File myScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(myScreenShot,new File("src/test/resources/screenshots/"+"ScrShot_"+screenShotNumber+"_"+name+"_"+System.currentTimeMillis()+".png"));
        } catch (Exception e) {
            System.out.println("Error taking screenshot: " + e.getMessage());
        }
    }
}


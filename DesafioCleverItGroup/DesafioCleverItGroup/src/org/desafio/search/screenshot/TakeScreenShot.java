package org.desafio.search.screenshot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class TakeScreenShot {
    WebDriver driver;
    String file = System.getProperty("user.dir") + "\\screenshot " + new Random().nextInt()+".png";

    public TakeScreenShot(WebDriver driver){
        this.driver = driver;
    }

    public void getScreenShot() throws IOException {
        TakesScreenshot srcShot = (TakesScreenshot) driver;
        File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
        File desFile = new File(file);
        FileHandler.copy(srcFile, desFile);
    }
}

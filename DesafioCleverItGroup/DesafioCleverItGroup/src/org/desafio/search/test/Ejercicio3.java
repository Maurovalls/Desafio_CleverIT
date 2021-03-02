package org.desafio.search.test;

import org.desafio.search.page.GoogleMainPage;
import org.desafio.search.report.RealTimeReport;
import org.desafio.search.screenshot.TakeScreenShot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/*
 Se automatizo las 3 funcionalidades:
 1)Input buscar con google
 2)Input me siento con suerte y el link Imagenes
 3)Link Imagenes
 */
@Listeners(RealTimeReport.class)
public class Ejercicio3 {
    WebDriver driver;
    String baseUrl = "https://www.google.com/";
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    String actualResult = "";
    String expectedResult = "";
    TakeScreenShot shot;
    GoogleMainPage googleMainPage;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterMethod
    public void afterMethod() throws IOException {
        googleMainPage.goBack();
        //En el caso de que el resultado de un test no sea el esperado se saca captura de pantalla
        if(!actualResult.equals(expectedResult)){
            shot = new TakeScreenShot(driver);
            shot.getScreenShot();
        }
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    //Comprobamos que funciona el input buscar con google y que el titulo de la pagina siguiente sea "Clever IT - Buscar con Google"
    @Test(priority = 1)
    public void buttonSearch(){
        googleMainPage = new GoogleMainPage(driver);
        googleMainPage.writeSearch("Clever IT");
        googleMainPage.clickSearchButton();
        actualResult = googleMainPage.titlePage();
        expectedResult = "Clever IT - Buscar con Google";
        Assert.assertEquals(actualResult,expectedResult,"No es igual al resultado esperado");
    }

    //Comprobamos que funciona el link imagenes
    @Test(priority = 2)
    public void linkImagenes(){
        googleMainPage = new GoogleMainPage(driver);
        googleMainPage.clickLinkImages();
        actualResult = googleMainPage.titlePage();
        expectedResult = "Imágenes de Google";
        Assert.assertEquals(actualResult,expectedResult,"No es igual al resultado esperado");
    }

    //Comprobamos que funciona el input me siento con suerte y nos lleva a la pagina oficial de River Plate
    @Test(priority = 3)
    public void botonLucky(){
        googleMainPage = new GoogleMainPage(driver);
        googleMainPage.clearField();
        googleMainPage.writeSearch("River Plate");
        googleMainPage.clickLuckyButton();
        actualResult = googleMainPage.titlePage();
        expectedResult = "River Plate - Sitio Oficial";
        Assert.assertEquals(actualResult,expectedResult,"No es igual al resultado esperado");
    }

}

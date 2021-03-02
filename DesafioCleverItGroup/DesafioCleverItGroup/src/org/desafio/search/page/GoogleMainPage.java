package org.desafio.search.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleMainPage {
    WebDriver driver;
    By searchField = By.cssSelector("input[name ='q']");
    By inputSearch = By.cssSelector("input[name ='btnK']");
    By inputLucky = By.cssSelector("input[name='btnI']");
    By linkImages = By.linkText("Imágenes");

    public GoogleMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void writeSearch(String busqueda){
        driver.findElement(searchField).sendKeys(busqueda);
    }

    public void clickSearchButton(){
        driver.findElement(inputSearch).click();
    }

    public void clickLuckyButton(){
        driver.findElement(inputLucky).click();
    }

    public void clickLinkImages(){
        driver.findElement(linkImages).click();
    }

    public void clearField(){
        driver.findElement(searchField).clear();
    }

    public String titlePage(){
        return driver.getTitle();
    }

    public void goBack(){
        driver.navigate().back();
    }

}

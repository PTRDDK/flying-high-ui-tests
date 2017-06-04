package edu.iis.mto.bdd.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Piotrek on 04.06.2017.
 */
public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWelcomeMessage(){
        return driver.findElement(By.id("welcome-message")).getText();
    }
}

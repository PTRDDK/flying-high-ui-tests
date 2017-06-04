package edu.iis.mto.bdd.cucumber.pages;

import edu.iis.mto.bdd.model.FrequentFlyerMember;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Piotrek on 04.06.2017.
 */
public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setup(){
        driver.get("http://localhost:8080/#/welcome");
    }

    public void logIn(FrequentFlyerMember user){
        driver.findElement(By.name("email")).sendKeys(user.getEmail());
        driver.findElement(By.name("password")).sendKeys(user.getPassword());
        driver.findElement(By.name("signin")).click();
    }
}

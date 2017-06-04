package edu.iis.mto.bdd.cucumber.workflowsteps;

import edu.iis.mto.bdd.cucumber.pages.HomePage;
import edu.iis.mto.bdd.cucumber.pages.LoginPage;
import edu.iis.mto.bdd.model.FrequentFlyerMember;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Piotrek on 04.06.2017.
 */
public class AuthenticationWorkFlowSteps {

    private LoginPage loginPage;
    private HomePage homePage;

    public AuthenticationWorkFlowSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    public void authenticationWithValidEmailAndPassword(FrequentFlyerMember user){
        loginPage.setup();
        loginPage.logIn(user);
    }

    public void checkWelcomeMessage(FrequentFlyerMember user){
        assertThat(homePage.getWelcomeMessage(), equalTo("Witaj " + user.getFirstName()));
    }
}

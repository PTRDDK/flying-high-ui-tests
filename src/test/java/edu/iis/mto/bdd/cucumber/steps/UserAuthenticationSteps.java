package edu.iis.mto.bdd.cucumber.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import edu.iis.mto.bdd.cucumber.pages.HomePage;
import edu.iis.mto.bdd.cucumber.pages.LoginPage;
import edu.iis.mto.bdd.cucumber.workflowsteps.AuthenticationWorkFlowSteps;
import edu.iis.mto.bdd.model.FrequentFlyerMember;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserAuthenticationSteps {

    private WebDriver driver;
    private AuthenticationWorkFlowSteps authenticationWorkFlowSteps;

    @Before
    public void init() {
        driver = new FirefoxDriver();
        authenticationWorkFlowSteps = new AuthenticationWorkFlowSteps(driver);
    }

    @Given("^(.*) is a registered Frequent Flyer$")
    public void givenARegisteredFrequentFlyer(String userEmail) {}

    @When("^(.*) authenticates with a valid email address and password$")
    public void whenJaneAuthenticatesWithAValidEmailAddressAndPassword(FrequentFlyerMember user) {
        authenticationWorkFlowSteps.authenticationWithValidEmailAndPassword(user);
    }

    @Then("^(.*) should be given access to (?:her|his) account$")
    public void thenTheUserShouldBeGivenAccessToAccount(FrequentFlyerMember user) {
        authenticationWorkFlowSteps.checkWelcomeMessage(user);
    }

    @Given("^(.*) has logged on$")
    public void aUserHasLoggedOnAs(FrequentFlyerMember user) {
        authenticationWorkFlowSteps.authenticationWithValidEmailAndPassword(user);
    }

    @When("^(?:.*) views the home page$")
    public void whenAUserViewsTheHomePage() {}

    @After
    public void close() {
        driver.close();
    }

}

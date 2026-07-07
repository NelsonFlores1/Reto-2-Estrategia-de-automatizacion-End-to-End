package com.saucedemo.stepdefinitions;

import com.saucedemo.questions.InventoryTitle;
import com.saucedemo.questions.LoginErrorMessage;
import com.saucedemo.tasks.Login;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinitions {

    @Before // todo  use the @Before in "CucumberHooks.jsvs"
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user accesses the SauceDemo login page")
    public void userIsOnLoginPage() {
        theActorCalled("user").attemptsTo(
                Open.browserOn().thePageNamed("webdriver.base.url")
        );
    }

    @When("the user with the username {string} and the password {string} logs in")
    public void heLogsInWithCredentials(String username, String password) {
        theActorInTheSpotlight().attemptsTo( // theActorInTheSpotlight() re-use the active actor in following steps
                Login.withCredentials(username, password)
        );
    }

    @Then("the user should see products dashboard with the title {string}")
    public void heShouldSeeTheDashboard(String expectedTitle) { // todo improve the methdo name
        theActorInTheSpotlight().should(
                seeThat("Inventory title", InventoryTitle.displayed(), equalTo(expectedTitle))
        );
    }

    @Then("the user should see login error message {string}")
    public void theUserShouldSeeLoginErrorMessage(String expectedErrorMessage) {
        theActorInTheSpotlight().should(
                seeThat("Login error message", LoginErrorMessage.displayed(), equalTo(expectedErrorMessage))
        );
    }
}

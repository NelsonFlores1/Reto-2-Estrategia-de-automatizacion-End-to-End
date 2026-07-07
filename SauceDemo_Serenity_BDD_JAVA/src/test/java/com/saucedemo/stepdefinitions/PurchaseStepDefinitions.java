package com.saucedemo.stepdefinitions;

import com.saucedemo.questions.OrderConfirmationMessage;
import com.saucedemo.questions.ProductPriceInCart;
import com.saucedemo.tasks.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class PurchaseStepDefinitions {

    @And("the user adds the first product {string} to the cart")
    public void heAddsFirstProductToTheCart(String productName) {
        theActorInTheSpotlight().attemptsTo(
                AddProductToCart.called(productName)
        );
    }

    @And("the user adds the second product {string} to the cart")
    public void heAddsSecondProductToTheCart(String productName) {
        theActorInTheSpotlight().attemptsTo(
                AddProductToCart.called(productName)
        );
    }

    @And("the user goes to the shopping cart")
    public void heGoesToTheShippingCart() {
        theActorInTheSpotlight().attemptsTo(
                GoToCart.now()
        );
    }

    @Then("the user validates that the product {string} has the price {string}")
    public void heValidatesTheProductPrice(String productName, String expectedProductPrice) {
        Double priceAsNumber = Double.parseDouble(expectedProductPrice.replace("$", "").trim()); // convert the price from String to Double

        theActorInTheSpotlight().should(seeThat("The price of " + productName,
                ProductPriceInCart.forItem(productName), equalTo(priceAsNumber))
        );
    }

    @And("the user starts the checkout")
    public void heStartsTheCheckout() {
        theActorInTheSpotlight().attemptsTo(
                GoToCheckout.now()
        );
    }

    @And("the user fills checkout information with the First Name {string} Last Name {string} and postalcode {string}")
    public void heFillsCheckoutInformation(String firstName, String lastName, String postalCode) {
        theActorInTheSpotlight().attemptsTo(
                FillCheckoutInformation.withData(firstName, lastName, postalCode)
        );
    }

    @And("the user continues the checkout")
    public void heContinuesTheCheckout() {
        theActorInTheSpotlight().attemptsTo(
                ContinueCheckout.now()
        );
    }

    @And("the user finishes the order")
    public void heFinishesTheOrder() {
        theActorInTheSpotlight().attemptsTo(
                FinishCheckout.noe()
        );
    }

    @Then("the user should see the order confirmation message {string}")
    public void heShouldSeeOrderConfirmation(String expectedConfirmationMessage) {
        theActorInTheSpotlight().should(
                seeThat("Confirmation message", OrderConfirmationMessage.displayed(), equalTo(expectedConfirmationMessage))
        );
    }
}

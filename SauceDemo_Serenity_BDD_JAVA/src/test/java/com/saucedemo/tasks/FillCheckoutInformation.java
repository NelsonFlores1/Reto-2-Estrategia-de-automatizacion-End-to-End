package com.saucedemo.tasks;

import com.saucedemo.ui.CheckoutYourInformationPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class FillCheckoutInformation implements Task {

    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public FillCheckoutInformation(String firstName, String lastName, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = zipCode;
    }

    @Override
    @Step("{0} Fill the checkout information")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstName).into(CheckoutYourInformationPage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(CheckoutYourInformationPage.LAST_NAME_FIELD),
                Enter.theValue(postalCode).into(CheckoutYourInformationPage.POSTAL_CODE_FIELD)
        );
    }

    public static FillCheckoutInformation withData(String firstName, String lastName, String postalCode) {
        return new FillCheckoutInformation(firstName, lastName, postalCode);
    }

}

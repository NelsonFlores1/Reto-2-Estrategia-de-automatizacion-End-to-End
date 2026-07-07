package com.saucedemo.tasks;

import com.saucedemo.ui.CheckoutYourInformationPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ContinueCheckout implements Task {

    @Override
    @Step("{0} login with the user")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CheckoutYourInformationPage.CONTINUE_BUTTON)
        );
    }

    public static ContinueCheckout now() {
        return  new ContinueCheckout();
    }
}

package com.saucedemo.tasks;

import com.saucedemo.ui.CheckoutOverviewPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class FinishCheckout implements Task {

    @Override
    @Step("{0} login with the user")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CheckoutOverviewPage.FINISH_BUTTON)
        );
    }

    public static FinishCheckout noe() {
        return new FinishCheckout();
    }

}

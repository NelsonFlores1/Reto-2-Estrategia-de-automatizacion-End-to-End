package com.saucedemo.tasks;

import com.saucedemo.ui.LoginPage;
import com.saucedemo.ui.YourCartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToCheckout implements Task {

    @Override
    @Step("{0} go to Checkout page from Your Cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(YourCartPage.CHECKOUT_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(YourCartPage.CHECKOUT_BUTTON)
        );
    }

    public static GoToCheckout now() {
        return new GoToCheckout();
    }

}

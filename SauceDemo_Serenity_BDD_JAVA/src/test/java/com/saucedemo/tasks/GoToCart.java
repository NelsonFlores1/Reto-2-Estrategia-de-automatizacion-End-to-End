package com.saucedemo.tasks;

import com.saucedemo.ui.Header;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToCart implements Task {

    @Step("Go to shopping cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(Header.SHOPPING_CART_LINK, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(Header.SHOPPING_CART_LINK)
        );
    }

    public static GoToCart now() {
        return new GoToCart();
    }
}

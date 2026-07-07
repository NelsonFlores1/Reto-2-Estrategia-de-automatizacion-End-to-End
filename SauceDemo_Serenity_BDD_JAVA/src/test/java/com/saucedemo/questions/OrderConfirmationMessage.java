package com.saucedemo.questions;

import com.saucedemo.ui.CheckoutCompletePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class OrderConfirmationMessage implements Question<String> {

    public String answeredBy(Actor actor) {
        return Text.of(CheckoutCompletePage.CONFIRMATION_MESSAGE).answeredBy(actor);
    }

    public static OrderConfirmationMessage displayed() {
        return new OrderConfirmationMessage();
    }
}

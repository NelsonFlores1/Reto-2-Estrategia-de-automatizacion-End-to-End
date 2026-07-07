package com.saucedemo.tasks;

import com.saucedemo.ui.ProductsPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class AddProductToCart implements Task {
    private final String productName;

    public AddProductToCart(String productName) {
        this.productName = productName;
    }

    @Override
    @Step("{0} Add a product to the cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductsPage.addToCartButtonFor(productName))
        );
    }

    public static AddProductToCart called(String productName) {
        return new AddProductToCart(productName);
    }
}

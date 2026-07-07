package com.saucedemo.questions;

import com.saucedemo.ui.YourCartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ProductPriceInCart implements Question<Double> {

    private final String productName;

    public ProductPriceInCart(String productName) {
        this.productName = productName;
    }

    @Override
    public Double answeredBy(Actor actor) {
        String priceText = Text.of(YourCartPage.PRODUCT_PRICE.of(productName)).answeredBy(actor);
        return Double.parseDouble(priceText.replace("$", "").trim());
    }

    public static ProductPriceInCart forItem(String productName) {
        return new ProductPriceInCart(productName);
    }
}
package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPage {
    public static final Target TITLE = Target.the("Products title").located(By.cssSelector(".title"));
    public static final Target ADD_TO_CART_SAUCE_LABS_BACKPACK = Target.the("Add to cart Sauce Labs Backpack product").located(By.id("add-to-cart-sauce-labs-backpack"));
    public static final Target ADD_TO_CART_SAUCE_LABS_ONESIE = Target.the("Add to cart Sauce Labs Onesie product").located(By.id("add-to-cart-sauce-labs-onesie"));

    public static Target addToCartButtonFor(String productName) {
        String productId = productName.toLowerCase().replace(" ", "-");
        return Target.the("add to cart button for " + productName)
                .located(By.id("add-to-cart-" + productId));
    }
}

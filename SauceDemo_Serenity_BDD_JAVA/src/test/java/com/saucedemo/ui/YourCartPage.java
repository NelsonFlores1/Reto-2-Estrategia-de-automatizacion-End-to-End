package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class YourCartPage {
    public static final Target TITLE = Target.the("Your Cart title").located(By.cssSelector(".title"));
    public static final Target SAUCE_LABS_BACKPACK_PRODUCT_DESCRIPTION = Target.the("Sauce Labs Backpack product added to cart").located(By.id("item_4_title_link"));
    public static final Target SAUCE_LABS_ONESIE_PRODUCT_DESCRIPTION = Target.the("Sauce Labs Onesie product added to cart").located(By.id("item_2_title_link"));
    public static final Target CHECKOUT_BUTTON = Target.the("Checkout products").located(By.id("checkout"));

    // Mapeo dinámico basado en el nombre del producto
    public static final Target PRODUCT_PRICE = Target.the("precio del producto {0}").locatedBy("//div[@class='inventory_item_name' and text()='{0}']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']");
}

package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutOverviewPage {
    public static final Target TITLE = Target.the("Checkout: Your Information").located(By.cssSelector(".title"));
    public static final Target SAUCE_LABS_BACKPACK_PRODUCT_OVERVIEW = Target.the("Sauce Labs Backpack product displayed in the checkout overview").located(By.id("item_4_title_link"));
    public static final Target SAUCE_LABS_ONESIE_PRODUCT_OVERVIEW = Target.the("Sauce Labs Onesie product displayed in the checkout overview").located(By.id("item_2_title_link"));
    public static final Target FINISH_BUTTON = Target.the("Finish button").located(By.id("finish"));
}

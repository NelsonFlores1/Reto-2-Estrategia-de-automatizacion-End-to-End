package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutCompletePage {
    public static final Target TITLE = Target.the("Checkout: Your Information").located(By.cssSelector(".title"));
    public static final Target CONFIRMATION_MESSAGE = Target.the("Confirmation message").located(By.cssSelector(".complete-header")); // expected: Thank you for your order!
}

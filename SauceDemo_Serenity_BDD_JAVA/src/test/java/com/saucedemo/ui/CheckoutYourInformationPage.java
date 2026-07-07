package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutYourInformationPage {
    public static final Target TITLE = Target.the("Checkout: Your Information").located(By.cssSelector(".title"));
    public static final Target FIRST_NAME_FIELD = Target.the("First Name field").located(By.id("first-name"));
    public static final Target LAST_NAME_FIELD = Target.the("Last Name field").located(By.id("last-name"));
    public static final Target POSTAL_CODE_FIELD = Target.the("Zip/Postal Code field").located(By.id("postal-code"));
    public static final Target CONTINUE_BUTTON = Target.the("Continue button").located(By.id("continue"));
}

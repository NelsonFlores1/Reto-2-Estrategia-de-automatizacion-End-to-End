package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Header {
    public static final Target SHOPPING_CART_LINK = Target.the("Shopping cart link").located(By.cssSelector(".shopping_cart_link"));
    public static final Target HAMBURGER_MENU_BUTTON = Target.the("Hamburger menu button").located(By.id("react-burger-menu-btn"));
    public static final Target SWAG_LABS_TITLE = Target.the("Header title").located(By.cssSelector(".app_logo"));

}

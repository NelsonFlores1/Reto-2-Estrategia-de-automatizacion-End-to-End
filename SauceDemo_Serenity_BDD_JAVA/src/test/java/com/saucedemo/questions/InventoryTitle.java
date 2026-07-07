package com.saucedemo.questions;


import com.saucedemo.ui.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class InventoryTitle implements Question<String> {

    // using Class-based style
    public String answeredBy(Actor actor) {
        return Text.of(ProductsPage.TITLE).answeredBy(actor);
    }

    public static InventoryTitle displayed() {
        return new InventoryTitle();
    }


    // using 'Lambda' style
    /*public static Question<String> inventoryTitle() {
        return actor -> Text.of(ProductsPage.TITLE).answeredBy(actor);
    }*/
}

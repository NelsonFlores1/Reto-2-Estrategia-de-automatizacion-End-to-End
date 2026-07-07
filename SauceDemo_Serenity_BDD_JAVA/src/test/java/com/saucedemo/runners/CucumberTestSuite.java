package com.saucedemo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "com.saucedemo.stepdefinitions",
        tags = "not @ignore"
)

public class CucumberTestSuite {
}
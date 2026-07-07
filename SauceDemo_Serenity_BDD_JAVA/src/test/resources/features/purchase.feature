@Purchase
Feature: Product Checkout
  As a SauceDemo customer
  I want to buy products from the catalog
  So that I can complete my purchase successfully

  Scenario: Customer completes a purchase with two products
    Given the user accesses the SauceDemo login page
    When the user with the username "standard_user" and the password "secret_sauce" logs in
    And the user adds the first product "Sauce Labs Backpack" to the cart
    And the user adds the second product "Sauce Labs Onesie" to the cart
    And the user goes to the shopping cart

    Then the user validates that the product "Sauce Labs Backpack" has the price "$29.99"
    Then the user validates that the product "Sauce Labs Onesie" has the price "$7.99"

    And the user starts the checkout
    And the user fills checkout information with the First Name "Nelson" Last Name "QA" and postalcode "0000"
    And the user continues the checkout
    And the user finishes the order
    Then the user should see the order confirmation message "Thank you for your order!"
@Login
Feature: User authentication
  As a SauceDemo user
  I want to authenticate with my credentials
  So that I can access the application only when my credentials are valid

  @ValidLogin
  Scenario: Valid user accesses the products page
    Given the user accesses the SauceDemo login page
    When the user with the username "standard_user" and the password "secret_sauce" logs in
    Then the user should see products dashboard with the title "Products"


  @InvalidLogin
  Scenario: Invalid user sees an authentication error
    Given the user accesses the SauceDemo login page
    When the user with the username "invalid_user" and the password "testuser" logs in
    Then the user should see login error message "Epic sadface: Username and password do not match any user in this service"
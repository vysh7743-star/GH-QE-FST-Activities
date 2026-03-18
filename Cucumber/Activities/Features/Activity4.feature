@Activity4
Feature: Data-driven login test without Examples

  Scenario: Login with valid credentials
    Given the user navigates to the login page for Activity4
    When the user enters username "admin" and password "password" for Activity4
    And clicks the submit button for Activity4
    Then the user should see the message "Hey, Admin!" for Activity4
@Activity5
Feature: Data-driven login test with Examples

  Scenario Outline: Login attempts with invalid credentials
    Given the user navigates to the login page for Activity5
    When the user enters username "<Usernames>" and password "<Passwords>" for Activity5
    And clicks the submit button for Activity5
    Then the user should see the message "Invalid credentials" for Activity5

    Examples: 
      | Usernames | Passwords      |
      | admin     | password123    |
      | admin     | wrongPassword  |
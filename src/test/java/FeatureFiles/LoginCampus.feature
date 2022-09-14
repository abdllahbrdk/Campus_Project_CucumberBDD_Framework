Feature: Login Campus Functionality

  Scenario: Login Admin Positive Account
    Given Admin User is on login page
    When Admin User enters valid admin credentials
    Then Admin User should login successfully

  Scenario: Login Admin Account Negative Test1
    Given Admin User is on login page
    When Admin User enters invalid username and valid password
    Then Admin User should not be able to login successfully

  Scenario: Login Admin Account Negative Test2
    Given Admin User is on login page
    When Admin User enters valid username and invalid password
    Then Admin User should not be able to login successfully

  Scenario: Login Admin Account Negative Test3
    Given Admin User is on login page
    When Admin User enters invalid username and invalid password
    Then Admin User should not be able to login successfully
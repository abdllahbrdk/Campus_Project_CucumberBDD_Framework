Feature:Subject Categories Functionality

  Background:
    Given Admin User navigates to login page
    When Admin User enters valid credentials from excel sheet name "Login" and row number "1"
    And Admin User clicks on login button
    Then Admin User should login successfully
    Then Admin User navigates to Subject Categories under Education Setup

  Scenario: Admin User Add Subject Categories Positive Test
    Given Admin User add Subject Category name as "Computer" and code as "cmp"
    Then Success message should be displayed

  Scenario: Admin User Add Subject Categories Negative Test
    Given Admin User add Subject Category name as "Computer" and code as "cmp"
    Then Already exists message should be displayed

  Scenario: Admin User Edit Subject Category
    Given Admin User edit Subject Category name as "ComputerEdited" and short name as "cmpEdited" and switch active button
    Then Success message should be displayed

  Scenario: Admin User Delete Subject Category
    Given Admin User Delete Subject Category
    Then Success message should be displayed

Feature:School Locations Functionality

  Background:
    Given Admin User navigates to login page
    When Admin User enters valid credentials from excel sheet name "Login" and row number "1"
    And Admin User clicks on login button
    Then Admin User should login successfully
    Then Admin User navigates to School Locations under School Setup

  Scenario: Admin User Add School Location Positive Test
    Given Admin User add School Location name as "Main" and short name "main" and Capacity "250"
    Then Success message should be displayed

  Scenario: Admin User Add School Location Negative Test
    Given Admin User add School Location name as "Main" and short name "main" and Capacity "250"
    Then Already exists message should be displayed

  Scenario: Admin User Edit School Location
    Given Admin User edit School Location name as "MainEdited" and short name as "mainEdited" and deactive the switch
    Then Success message should be displayed

  Scenario: Admin User Delete School Location Test
    Given Admin User delete School Location
    Then Success message should be displayed

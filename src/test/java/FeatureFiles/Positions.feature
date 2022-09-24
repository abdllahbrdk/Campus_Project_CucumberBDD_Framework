Feature: Positions Functionality

  Background:
    Given Admin User navigates to login page
    When Admin User enters valid credentials from excel sheet name "Login" and row number "1"
    And Admin User clicks on login button
    Then Admin User should login successfully
    When Navigate to Positions page
    Then Admin User should have search function for this page
    And Admin User should have activate and deactivate function

  Scenario: Create Positions Positive Test
    And Admin User create Employee Positions name as "Mentors" and short name as "MTR"
    Then Success message should be displayed

  Scenario: Create Position Negative Test
    And Admin User create again Employee Positions name as "Mentors" and short name as "MTR"
    Then Already exists message should be displayed

  Scenario: Edit Positions Positive Test
    And Admin User edit Employee Positions existName as "Mentors" to newName as "Instructors" and short name as "INSTR"
    Then Success message should be displayed

  Scenario: Delete Positions Positive Test
    And Admin User delete Employee Positions name as "Instructors"
    Then Success message should be displayed

  Scenario: Delete Position Categories Negative Test
    And Admin User delete again Employee Positions name as "Instructors"
    Then There is no data to display message should be displayed





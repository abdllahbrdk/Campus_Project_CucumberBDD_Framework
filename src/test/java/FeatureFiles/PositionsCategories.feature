Feature: Positions Functionality

  Background:
    Given Admin User navigates to login page
    When Admin User enters valid credentials from excel sheet name "Login" and row number "1"
    And Admin User clicks on login button
    Then Admin User should login successfully
    When Navigate to Position Categories page
    Then Admin User should have search function for this page

  Scenario: Create Position Categories Positive Test
    And Admin User create Position Categories name as "Mentors"
    Then Success message should be displayed

  Scenario: Create Position Categories Negative Test
    And Admin User create again Position Categories name as "Mentors"
    Then Already exists message should be displayed

  Scenario: Edit Position Categories Positive Test
    And Admin User edit Position Categories existName as "Mentors" to newName as "Instructors"
    Then Success message should be displayed

  Scenario: Delete Position Categories Positive Test
    And Admin User delete Position Categories name as "Instructors"
    Then Success message should be displayed

  Scenario: Delete Position Categories Negative Test
    And Admin User delete again Position Categories name as "Instructors"
    Then There is no data message should be displayed
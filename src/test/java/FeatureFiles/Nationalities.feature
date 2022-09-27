Feature: Admin User should be able to add, edit and delete Nationalities


  Background:
    Given Admin User navigates to login page
    When Admin User enters valid credentials from excel sheet name "Login" and row number "1"
    And Admin User clicks on login button
    Then Admin User should login successfully
    Then Admin User navigates to Nationalities page
    And Admin User should have search function in Nationalities page

    Scenario: Add Nationalities Positive Test
      When Admin User add Nationality name as "BCFNation"
      Then Success message should be displayed

    Scenario: Add Nationalities Negative Test
      When Admin User add again Nationality name as "BCFNation"
      Then Already exists message should be displayed

    Scenario: Edit Nationalities Test
      When Admin User edit Nationality name "BCFNation" to newName as "BCF22Nation"
      Then Success message should be displayed

    Scenario: Delete Nationalities Positive Test
      When Admin User delete Nationality newName as "BCF22Nation"
      Then Success message should be displayed

    Scenario: Delete Nationalities Negative Test
      When Admin User delete again Nationality newName as "BCF22Nation"
      Then There is no data to display message should be displayed

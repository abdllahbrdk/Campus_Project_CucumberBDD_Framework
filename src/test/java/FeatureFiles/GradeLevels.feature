Feature: Grade Levels Functionality

  Background:
    Given Admin User navigates to login page
    When Admin User enters valid credentials from excel sheet name "Login" and row number "1"
    And Admin User clicks on login button
    Then Successfully message should be displayed


  Scenario:Add Grade Levels Positive Test
    When Admin User navigates to Grade Levels Bar
    And Admin User can switch active on and off
    Then Admin User add grade levels for students and employees name as "Kenny" shortname as "Ken" and order as "1"
    Then Success message should be displayed

   Scenario: Add Grade Levels Negative Test
     When Admin user add grade levels with same data name as "Kenny" shortname as "Ken" and order as "1"
     Then Already exist message should be displayed

     Scenario: Edit Grade Levels
       When Admin user edit grade levels name as "Kevin" shortname as "Kev" and order as "2"
       Then Success message should be displayed

       Scenario: Delete Grade Levels
         When Admin user delete grade levels
         Then Success message should be displayed


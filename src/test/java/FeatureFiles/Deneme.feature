Feature: Deneme Functionality

  Scenario: Admin User Login Campus Account Positive Test
    Given Admin User navigates to login page
    When Admin User enters valid credentials from excel sheet name "Login" and row number "1"
    And Admin User clicks on login button
    Then Successfully message should be displayed
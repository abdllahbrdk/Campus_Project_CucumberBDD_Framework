Feature: Admin User should be able to add, edit and delete Bank Accounts


  Background:
    Given Admin User navigates to login page
    When Admin User enters valid credentials from excel sheet name "Login" and row number "1"
    And Admin User clicks on login button
    Then Successfully message should be displayed
    Then Admin User navigates to Bank Accounts page
    And Admin User should have search function in Bank Accounts page

    Scenario: Add Bank Accounts Positive Test
      When Admin User add Bank Accounts name as "ADKBank" and iban "DB04838753875" and intCode "ADK007"
      Then Success message should be displayed

    Scenario: Add Bank Accounts Negative Test
      When Admin User add Bank Accounts same name as "ADKBank" and iban "DB04838753875" and intCode "ADK007"
      Then Already exists message should be displayed

    Scenario: Edit Bank Accounts
      When Admin User edit Bank Accounts name "ADKBank" to newName "BCFBank"
      Then Success message should be displayed

    Scenario: Delete Bank Accounts Positive Test
      When Admin User delete Bank Accounts newName as "BCFBank"
      Then Success message should be displayed

    Scenario: Delete Bank Accounts Negative Test
      When Admin User delete again Bank Accounts name as "BCFBank"
      Then There is no data to display message should be displayed

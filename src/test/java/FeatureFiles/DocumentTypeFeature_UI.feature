Feature: Admin User should be able to Add, Edit and Delete Document Types

  Background: Admin User Login Campus Account Positive Test
    Given Admin User navigates to login page
    When Admin User enters valid credentials from excel sheet name "Login" and row number "1"
    And Admin User clicks on login button
    Then Admin User should login successfully

    Scenario: Admin User should be able to Add Document Types
      When Admin User Add Document Type with a Name as "Alex" and Select Stage "Certificate"
      Then Success message should be displayed

    Scenario: Admin User should be able to Edit Document Types
      When Admin User Edit Document Type "Alex" to update "ALEX De Souza" and Select Stage "Contract"
      Then Success message should be displayed

    Scenario: Admin User should be able to Delete Document Types
      When Admin User Click Delete Document Type "ALEX De Souza"
      Then Success message should be displayed

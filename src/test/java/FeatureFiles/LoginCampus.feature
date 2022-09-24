Feature: Login Campus Functionality

  Scenario: Admin User Login Campus Account Positive Test
    Given Admin User navigates to login page
    When Admin User enters valid credentials from excel sheet name "Login" and row number "1"
    And Admin User clicks on login button
    Then Admin User should login successfully


  Scenario Outline: Admin User Login Campus Account Negative Test
    Given Admin User navigates to login page
    When Admin User enters invalid credentials from excel "<SheetName>" and <RowNumber>
    And Admin User clicks on login button
    Then Admin User should not be able to login successfully
    Examples:
       | SheetName | RowNumber |
       | Login     | 2         |
       | Login     | 3         |
       | Login     | 4         |

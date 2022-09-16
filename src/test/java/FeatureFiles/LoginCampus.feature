Feature: Login Campus Functionality

  Scenario Outline: Admin User Login Campus Account Positive Scenario with set of data
    Given Admin User navigates to login page
    When Admin User enters valid credentials from given sheet name "<SheetName>" and row number <RowNumber>
    And Admin User clicks on login button
    Then Successfully message should be displayed
    Examples:
      | SheetName | RowNumber |
      | Login     | 0         |





  Scenario Outline: Admin User Login Campus Account Negative Scenario with  set of data
    Given Admin User navigates to login page
    When Admin User enters invalid username and valid password credentials from given sheet name "<SheetName>" and row number <RowNumber>
    And Admin User clicks on login button
    Then Admin User should not be able to login successfully
    Examples:
       | SheetName | RowNumber |
       | Login     | 1         |
#

  Scenario Outline: Admin User Login Campus Account Negative Scenario with set of data
    Given Admin User navigates to login page
    When Admin User enters valid username and invalid password credentials from given sheet name "<SheetName>" and row number <RowNumber>
    And Admin User clicks on login button
    Then Admin User should not be able to login successfully
    Examples:
     | SheetName | RowNumber |
     | Login     | 2         |

  Scenario Outline: Admin User Login Campus Account Negative Scenario with set of data
    Given Admin User navigates to login page
    When Admin User enters invalid username and invalid password credentials from given sheet name "<SheetName>" and row number <RowNumber>
    And Admin User clicks on login button
    Then Admin User should not be able to login successfully
    Examples:
      | SheetName | RowNumber |
      | Login     | 3         |
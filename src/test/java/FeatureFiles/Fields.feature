Feature: Fields Functionality

  Background:
    Given Admin User navigates to login page
    When Admin User enters valid credentials from excel sheet name "Login" and row number "1"
    And Admin User clicks on login button
    Then Successfully message should be displayed
    Then Admin User Navigates to Fields Bar

    Scenario: Admin User Add Fields Positive Test
      When Admin User add fields as "Math" when clicks on add button
      Then Success message should be displayed

      Scenario: Admin User Add Fields Negative Test
        When Admin User add same fields as "Math"
        Then Already exist message should be displayed

        Scenario: Admin User Edit Fields Test
          When Admin User Edit "Math "Fields as "Chemistry"
          Then Success message should be displayed

          Scenario: Admin User Delete Fields Positive Test
            When Admin User Delete Fields as "Chemistry"
            Then Success message should be displayed

            Scenario: Admin User Delete Fields Negative Test
              When Admin User Delete Fields as "Chemistry" again
              Then There is no Data Display message should be displayed


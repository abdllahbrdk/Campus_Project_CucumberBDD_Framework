Feature: Departments Functionality

  Background:
    Given Admin User navigates to login page
    When Admin User enters valid credentials from excel sheet name "Login" and row number "1"
    And Admin User clicks on login button
    Then Admin User should login successfully
    Then Admin User navigates to School Setup under Departments

    Scenario: Admin User Add School Departments Positive Test
      When Admin User add School Department as "Social" and code "SC101"
      Then Success message should be displayed

      Scenario: Admin User Add School Departments Negative Test
        When Admin User add School Department as "Social" and code "SC101"
        Then Already Department message should be displayed

        Scenario: Admin User Edit School Departments
          When Admin User edit School Department newName "SocialActivity"
          Then Success message should be displayed

          Scenario: Admin User delete School Departments Positive Test
            When Admin User Delete Department name
            Then Success message should be displayed

            Scenario: Admin User delete School Departments Negative Test
              When Admin User Delete again Department name
              Then There is no data to display message should be displayed
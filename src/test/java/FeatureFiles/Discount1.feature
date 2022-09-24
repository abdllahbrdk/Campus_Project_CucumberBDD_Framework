Feature: Discount Feature

  Background:
    Given Admin User navigates to login page
    When Admin User enters valid credentials from excel sheet name "Login" and row number "1"
    And Admin User clicks on login button
    Then Admin User should login successfully
    Given Admin User navigates to discounts
    Then Search Functionality should be present

  Scenario: Add,Edit,Delete Discount Positive and Negative Tests
    And Admin user should be able to add a discount with "Description","IntegrationCode" and "190417"
    Then Success message should be displayed


    And Admin user should not be able to add a discount with "Description","IntegrationCode" and "190417"
    Then Already exists message should be displayed

    And Admin user should be able to edit a discount named with "Description"
    Then Success message should be displayed

    And Admin user should be able to delete a discount named with "Description"
    Then Success message should be displayed

    And Admin user should not be able to delete a discount named with "Description"








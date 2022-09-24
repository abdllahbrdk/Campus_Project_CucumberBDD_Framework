Feature: Attestations Functionality

  Background:
    Given Admin User navigates to login page
    When Admin User enters valid credentials from excel sheet name "Login" and row number "1"
    And Admin User clicks on login button
    Then Admin User should login successfully
    Then Admin User Navigates to Attestations Bar

  Scenario: Admin User Add Attestations Positive Test
    When Admin User add Attestation as "John" when clicks on add button
    Then Success message should be displayed

  Scenario: Admin User Add Attestations Negative Test
    When Admin User add same Attestation as "John"
    Then Already exist message should be displayed

  Scenario: Admin User Edit Attestations  Test
    When Admin User Edit "John" Attestation  as "Johny"
    Then Success message should be displayed

  Scenario: Admin User Delete Attestations Positive Test
    When Admin User Delete Attestation  as "Johny"
    Then Success message should be displayed

  Scenario: Admin User Delete Attestations  Negative Test
    When Admin User Delete Attestation  as "Johny" again
    Then There is no data to display message should be displayed
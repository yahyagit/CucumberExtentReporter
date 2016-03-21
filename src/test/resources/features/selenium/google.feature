@google
Feature: Google

  Scenario: Open google and check title
    Given I am on Google home page
    Then I verify the title is "Google"
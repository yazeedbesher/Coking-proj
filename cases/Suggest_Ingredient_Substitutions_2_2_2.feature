Feature: Alert chef when ingredient substitution is applied

  Scenario: Alert chef when substitution is suggested due to dietary restriction
    Given the customer is allergic to nuts
    And selects Pesto Sauce which contains nuts
    And the system substitutes it with Sunflower Seed Pesto
    When the substitution is applied
    Then the system alerts the chef for approval

  Scenario: Alert chef when substitution is due to unavailability
    Given Miso Paste is out of stock
    And the system substitutes it with Soy Sauce
    When the substitution is applied
    Then the chef should be notified to review and approve the change

  Scenario: No alert when no substitution is applied
    Given the customer selects all available and compatible ingredients
    When the system processes the request
    Then the chef should not receive any substitution alert

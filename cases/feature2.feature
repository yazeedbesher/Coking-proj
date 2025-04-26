Feature: Allow customers to create custom meal request

  Scenario: Create a custom meal with available ingredients
    Given the customer is on the custom meal selection page
    When the customer selects ingredients from the available list
    Then the system should validate the ingredient combinations
    And the system should allow the customer to proceed with the order

  Scenario: Attempt to select unavailable or incompatible ingredients
    Given the customer is on the custom meal selection page
    When the customer selects unavailable or incompatible ingredients
    Then the system should display an error message
    And the system should not allow the customer to proceed

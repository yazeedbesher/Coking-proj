Feature: Customer wants to view their past meal orders

  Scenario: No past meal orders available
    Given the customer is logged into the system
    When the customer navigates to the "Past Orders" page
    Then the system should return an empty list
    And the system should display the message "You have no past meal orders."
    And the page should invite the customer to place their first order

  Scenario: Past meal orders are available
    Given the customer is logged into the system
    When the customer navigates to the "Past Orders" page
    Then the system should return a list of past meal orders
    And the system should display the list of past meal orders
    And the page should invite the customer to place another order

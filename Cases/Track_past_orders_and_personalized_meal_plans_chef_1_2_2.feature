Feature: chef want to access customers’ order history and suggest personalized meal plans

  Scenario: no customers’ order history
    When the chef navigates to the customers’ order history page without any previous orders
    Then the system will return an empty customers’ order history list
    And the system will display the message: there is no customers’ order history

  Scenario: customers’ order history is available
    When the chef navigates to the customers’ order history page with existing orders
    Then the system will return a list of customers’ order history
    And the system will display the list of customers’ order history

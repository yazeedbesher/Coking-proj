#Feature: Customer wants to view their past meal orders
#
#  Scenario: no past meal orders available
#    When the customer navigates to the Past Orders page without any previous orders
#    Then the system will return an empty list
#    And the system will display the message: You have no past meal orders
#    And the page will invite the customer to place their first order
#
#  Scenario: past meal orders are available
#    When the customer navigates to the Past Orders page with existing orders
#    Then the system will return a list of past meal orders
#    And the system will display the list of past meal orders
#    And the page will invite the customer to place another order
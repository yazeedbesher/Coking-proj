Feature: the system administrator want to store and retrieve customer order history


  Scenario: the administrator doesn't entered any order in  customer order history
    When the administrator doesn't entered any orders to customer order history
    Then the system will display an error message : no customer order history entered
    And the system will return false


  Scenario:  the administrator entered orders in  customer order history
    When the administrator entered orders to customer order history
    Then the system will display a success message : Successfully added the order to customer order history
    And the system will return true



  Scenario: There is no history of customer orders to show to the administrator
    When The administrator navigates to the customer order history page, where the orders do not exist
  Then the system will return an empty customer order history list for administrator
    And the system will display the message: there is no customer order history

    Scenario: There is history of customer orders to show to the administrator
      When The administrator navigates to the customers’ order history page, where the orders are exist
      Then the system will return a list of customer order history for  administrator
      And the system will display the list of customer order history

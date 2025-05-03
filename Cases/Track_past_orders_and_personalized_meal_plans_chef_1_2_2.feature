Feature: chef want to access customers’ order history and suggest personalized meal plans

  Scenario: no customers’ order history
    When the chef navigates to the customers’ order history page without any previous orders
    Then the system will return an empty customers’ order history list
    And the system will display the message: there is no customers’ order history

  Scenario: customers’ order history is available
    When the chef navigates to the customers’ order history page with existing orders
    Then the system will return a list of customers’ order history
    And the system will display the list of customers’ order history


  Scenario: no suggested personalized meal plans
    When the chef doesnot enter any suggested personalized meal plans
    Then the system will display an error masage : no personalized meal plans entered
    And the system will return false

  Scenario: entered  suggested personalized meal plans
    When the chef enter suggested personalized meal plans
    Then the system will display a success message : Successfully added personalized meal plans
    And the system will return true

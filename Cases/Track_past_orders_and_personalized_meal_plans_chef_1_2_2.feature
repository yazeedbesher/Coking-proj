Feature: chef want to access customers’ order history and suggest personalized meal plans

  Scenario: no customers’ order history
    When the chef navigates to the customers’ order history page without any previous orders
    Then the system will return an empty customers’ order history list
    And the system will display the message: there is no customers’ order history

  Scenario: customers’ order history is available
    When the chef navigates to the customers’ order history page with existing orders
    Then the system will return a list of customers’ order history
    And the system will display the list of customers’ order history


  Scenario: no suggested personalized meal plan
    When the chef doesn't enter any suggested personalized meal plan
    Then the system will display an error message : no personalized meal plan entered
    And the system will return false

  Scenario: the entered suggested personalized meal plan already exist
    When the chef enter suggested personalized meal plan already exist
    Then the system will display an error message : personalized meal plan you entered is already exist
    And the system will return false

  Scenario: entered  suggested personalized meal plan
    When the chef enter suggested personalized meal plan
    Then the system will display a success message : Successfully added personalized meal plan

  Feature: Track available ingredients

    Scenario: View current stock level of an ingredient
      Given the system has 20 units of Tomatoes in stock
      When the kitchen manager checks the inventory for Tomatoes
      Then the system should display 20 units available

    Scenario: Update stock level after usage
      Given there are 15 units of Onions in stock
      When 5 units are used for meal preparation
      Then the system should update the stock to 10 units

    Scenario: Alert when stock is depleted
      Given Tomatoes has 0 units remaining
      When the kitchen manager views the ingredient list
      Then the system should flag Tomatoes as out of stock
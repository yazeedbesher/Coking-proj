Feature: Suggest restocking when ingredients are low

  Scenario: Suggest restocking for ingredient below threshold
    Given Garlic has 2 units in stock
    And the minimum threshold is 5 units
    When the system checks inventory levels
    Then it should suggest restocking Garlic

  Scenario: Do not suggest restocking for ingredient above threshold
    Given Salt has 10 units in stock
    And the minimum threshold is 5 units
    When the system checks inventory levels
    Then it should not suggest restocking Salt

  Scenario: Suggest restocking multiple low-stock ingredients
    Given Oil has 3 units and Pepper has 1 unit
    And the threshold for each is 5 units
    When the system performs a restock check
    Then it should suggest restocking both Oil and Pepper
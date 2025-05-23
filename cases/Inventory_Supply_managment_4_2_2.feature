#Feature: Automatically generate purchase orders when stock levels are critically low
#
#  Scenario: Auto-generate purchase order for a single low-stock item
#    Given Eggs has only 1 unit left
#    And the critical threshold is 3 units
#    When the system checks inventory
#    Then it should generate a purchase order for Eggs
#
#  Scenario: Auto-generate orders for multiple critical items
#    Given Milk has 0 units and Yeast has 1 unit
#    And both are below critical thresholds
#    When the system performs inventory scan
#    Then it should generate purchase orders for both items
#
#  Scenario: Do not generate purchase order for sufficient stock
#    Given Cheese has 10 units in stock
#    And the critical threshold is 3 units
#    When the system checks stock levels
#    Then it should not generate a purchase order for Cheese
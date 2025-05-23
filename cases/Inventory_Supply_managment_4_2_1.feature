#Feature: Integrate with suppliers for real-time pricing and ordering
#
#  Scenario: Fetch price for a single ingredient
#    Given the kitchen manager selects Olive Oil for price check
#    When the system contacts the supplier API
#    Then it should display the current price for Olive Oil
#
#  Scenario: Compare prices from multiple suppliers
#    Given Flour is needed for a new order
#    When the system retrieves prices from Supplier A and Supplier B
#    Then it should display both prices for comparison
#
#  Scenario: Alert manager when a better deal is available
#    Given Supplier X offers Butter at $5 and Supplier Y offers it at $3.50
#    When the kitchen manager checks prices
#    Then the system should highlight Supplier Y as the most cost-effective option
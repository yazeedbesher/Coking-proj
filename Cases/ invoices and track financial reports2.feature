Feature: Report generation from a list of orders

  Scenario: Admin sends an empty list of orders
    When the admin sends an empty list to the report generator
    Then the system shows: No orders to include in the report
    And the system returns true

  Scenario: An error happens while generating the report
    When the admin sends a valid list of orders
    And something goes wrong during report creation
    Then the system shows: Failed to generate report
    And the system returns false

  Scenario: Admin sends a valid list of orders
    When the admin sends a non-empty list to the report generator
    Then the system creates a report from the orders
    And the system shows: Report generated successfully
    And the system returns true

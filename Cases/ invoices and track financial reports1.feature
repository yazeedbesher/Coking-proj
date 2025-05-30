Feature: the system automatically creates an invoice when the customer confirms an order

  Scenario: the customer confirms an order with no products
    When the customer confirms an order that contains no products
    Then the system will display an error message: Cannot create invoice, no products found in the order
    And the system will return false



  Scenario: the customer confirms an order with complete information
    When the customer confirms an order that contains valid customer and product information
    Then the system will generate an invoice automatically
    And the system will display a success message: Invoice created successfully
    And the system will return true
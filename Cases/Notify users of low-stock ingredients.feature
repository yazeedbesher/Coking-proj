Feature: Kitchen manager receives low-stock alerts
  Scenario: ingredient falls below minimum stock level
    When the quantity of tomatoes drops below the threshold
    Then the system will send a low-stock alert to the kitchen manager

  Scenario: stock alert not triggered due to misconfigured threshold
    When the ingredient stock is critically low
    And the minimum threshold is incorrectly set to zero
    Then the system will not send a low-stock alert
    And the manager will be unaware of the shortage

  Scenario: duplicate low-stock alert sent repeatedly
    When a low-stock alert has already been acknowledged
    And the system fails to detect the acknowledgment
    Then the system will keep sending duplicate alerts unnecessarily

Feature: Suggest ingredient substituions based on dietary resrictions
  Scenario: Suggest a Substitution when an ingredient is unvailable
    Given the customer selects an ingredients that unavailable
    When the system deteccts the unvailable ingredient
    Then the sysytem suggest an alternative ingredient
    And the system alerts the chef for approval

    Scenario: Suggest a Substitution based on dietary restrictions
      Given the customer selects an ingredients that does not fit their dietary restrictions
      When the system detects the dietary restriction conflict
      Then the system suggest a suitable alternative ingredient
      And the system alerts the chef for approval
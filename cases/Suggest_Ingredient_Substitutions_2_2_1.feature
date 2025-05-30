#Feature: Suggest ingredient substitutions based on dietary restrictions
#
#  Scenario: Suggest a substitutions when an ingredient is unavailable
#    Given the customer selects an ingredients that unavailable
#    When the system detects the unavailable ingredient
#    Then the system suggest an alternative ingredient
#    And the system alerts the chef for approval
#
#  Scenario: Suggest a substitutions based on dietary restrictions
#    Given the customer selects an ingredients  that does not fit their dietary restrictions
#    When the system detects the dietary restriction conflict
#    Then the system suggest a suitable alternative ingredient
#    And the system should suggest an alternative
#
#  Scenario: No substitutions needed for valid selection
#    Given the customer selects Grilled Salmon and steamed vegetables
#    And there are no dietary conflicts or availability issues
#    When the system processes the request
#    Then the system should proceed without suggesting substitutions
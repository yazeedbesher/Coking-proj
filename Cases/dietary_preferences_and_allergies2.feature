#Feature: Recall dietary preferences and allergies
#
#  Scenario: There are no preferences to display
#    When the chef wants to view empty customer dietary preferences list
#    Then the system will pop up an error message
#    And the system will return empty lists
#
#  Scenario: There are no allergies to display
#    When the chef wants to view empty customer dietary allergies list
#    Then the system will pop up an error message
#    And the system will return empty lists
#
#
#  Scenario: There are preferences to display
#    When the chef wants to view customer dietary preferences
#    Then the system will pop up a success message
#    And the system will return the preferences and allergies lists
#
#  Scenario: There are allergies to display
#    When the chef wants to view customer dietary allergies
#    Then the system will pop up a success message
#    And the system will return the preferences and allergies lists
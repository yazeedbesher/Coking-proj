Feature: Store dietary preferences and allergies

  Scenario: no dietary preferences entered
    When the customer leave the preferences field empty
    Then the system will pop up an error massage
    And the system return false



  Scenario: enter dietary preferences
    When the customer enter dietary preferences
    Then the system will pop up a success message
    And the system return true




  Scenario: no dietary allergies entered
    When the customer leave the allergies field empty
    Then the system will pop up an error massage
    And the system return false



  Scenario: enter dietary allergies
    When the customer enter dietary allergies
    Then the system will pop up a success message
    And the system return true


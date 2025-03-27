Feature : Recall dietary preferences and allergies

  Scenario : there is no data to display
    When : the chef want to view customer dietary preferences
    Then : the system will pop up warning message
    And : the system will display an empty lists

    Scenario : there is data to display
      When :the chef want to view customer dietary preferences
      Then : the system will display dietary preferences lists
      And : the system will display allergies list
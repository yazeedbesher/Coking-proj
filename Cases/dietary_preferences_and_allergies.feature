Feature : dietary preferences and allergies

  Scenario : no dietary preferences and allergies
    When : the customer leave the fields empty
    Then : masssage error will pop up
    And : give the user another chance

    Scenario: enter dietary preferences only
     When : the customer enter dietary preferences
      And : leave the allergies empty
      Then : the system by default consider there is no allergies
      And : the system allows the user to proceed without errors
      And : the system save the data in user information

      Scenario : dietary preferences and allergies
        When the customer enter dietary preferences and allergies
        Then : the system allows the user to proceed without errors
        And : the system save the data in user information



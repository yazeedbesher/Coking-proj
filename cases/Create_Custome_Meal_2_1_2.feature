Feature: Validate ingredient combinations

    Scenario: Prevent incompatible ingredient selection
        Given the customer is on the custom meal selection page
        And the customer selects Shrimp and Peanut Butter for a meal
        When the system checks for ingredient compatibility
        Then the system should display an error message

    Scenario: Prevent unavailable ingredient selection
        Given the customer selects Truffle Oil
        And Truffle Oil is currently out of stock
        When the customer tries to submit the request
        Then the system should display an error message

    Scenario:  Allow valid and available ingredient
        Given the customer selects Chicken,Brown Rice, and Spinach
        And all ingredients are available and compatible
        When the customer submits the meal request
        And the system should allow the customer to proceed with the order
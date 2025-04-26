Feature: Scheduling and Task Management

  Scenario: Assign tasks to chefs and kitchen staff
    Given the Kitchen manager assign task for chefs
    When the chefs are available and not overloaded
    Then the manager assigns tasks based on their workloads and expertise
    And the chefs start preparing meals on time

  Scenario: receive notifications about assigned cooking tasks

    Given the chef receives notifications about assigned tasks
    When the chefs are available and not overloaded
    Then the chefs start preparing meals on time
    And the customers receive their meals
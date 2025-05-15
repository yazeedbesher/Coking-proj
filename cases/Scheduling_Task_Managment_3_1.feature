Feature: Scheduling and Task Management

  Scenario: Assign tasks to chefs and kitchen staff
    Given the Kitchen manager assign task for chefs
    When the chefs are available and not overloaded
    Then the manager assigns tasks based on their workloads and expertise
    And the chefs start preparing meals on time

  Scenario: Avoid assigning tasks to overburdened chef
    Given first chef already has 5 active tasks
    And second chef has 2 active tasks
    When a new task is created
    Then the system should assign the task for second chef

  Scenario: Assign prep work to available kitchen staff
    Given Kitchen Staff Member Sam is available
    And a vegetable chopping task needs to be done
    When the task is assigned
    Then it should be assigned to Sam
Feature: Notify chefs of assigned cooking tasks


Scenario: receive notifications about assigned cooking tasks

Given the chef receives notifications about assigned tasks
When the chefs are available and not overloaded
Then the chefs start preparing meals on time
And the customers receive their meals

  Scenario: Notify chef of task deadline
    Given Chef Alex receives a new cooking task
    When the task is due in 2 hours
    Then the notification should include the task deadline

  Scenario: Do not send duplicate notifications
    Given Chef Jordan has already been notified about a task
    When the same task is reassigned without change
    Then the system should not send another notification
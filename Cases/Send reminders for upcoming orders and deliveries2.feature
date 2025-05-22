  Feature: Chef gets notified of scheduled cooking tasks

    Scenario: chef has tasks today
      When the chef is scheduled to prepare meals today
      Then the system will send a task notification
      And the notification will include meal types and preparation times

    Scenario: chef receives a notification for an outdated task
      When the system sends a cooking task notification
      And the task was already canceled or completed
      Then the chef will receive an invalid notification
      And the system should discard outdated tasks

    Scenario: chef notification not sent due to invalid contact info
      When the system attempts to notify the chef
      And the chef's contact information is missing or invalid
      Then the system will fail to send the notification


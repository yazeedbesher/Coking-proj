Feature: Customer receives reminders for upcoming meal deliveries
Scenario: delivery scheduled for today
When the customer has a meal scheduled for delivery
Then the system will send a reminder notification
And the reminder will include the delivery time and meal details

Scenario: last-minute reminder before delivery
When the delivery time is less than one hour away
Then the system will send a final reminder to the customer

Scenario: reminder sent to wrong customer
When the system sends a reminder for a meal delivery
And the customer ID is incorrectly matched
Then the wrong customer will receive the reminder
And the system will log a delivery mismatch error

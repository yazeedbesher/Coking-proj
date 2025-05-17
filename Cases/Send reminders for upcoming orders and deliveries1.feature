Feature: Customer receives reminders for upcoming meal deliveries
Scenario: delivery scheduled for today
When the customer has a meal scheduled for delivery
Then the system will send a reminder notification
And the reminder will include the delivery time and meal details

Scenario: last-minute reminder before delivery
When the delivery time is less than one hour away
Then the system will send a final reminder to the customer

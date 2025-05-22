package org.example.ahmad_project;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.cooking_proj.NotificationsAndAlerts;
import com.example.cooking_proj.Order;
import org.junit.Assert;

import java.time.LocalDateTime;

public class SendRemindersForUpcomingOrdersAndDeliveries1 {

    boolean result;
    NotificationsAndAlerts notificationSystem = new NotificationsAndAlerts();
    Order order;

    @When("the customer has a meal scheduled for delivery")
    public void theCustomerHasAMealScheduledForDelivery() {
        order = new Order(1, 1, "Ahmad", "Chef Ahmad", "Rice", LocalDateTime.now().plusHours(3));
        result = notificationSystem.UpcomingOrdersReminder(1, order, 1);
    }

    @Then("the system will send a reminder notification")
    public void theSystemWillSendAReminderNotification() {
        Assert.assertTrue(result);
    }

    @Then("the reminder will include the delivery time and meal details")
    public void theReminderWillIncludeTheDeliveryTimeAndMealDetails() {
        Assert.assertTrue(result);
    }

    @When("the delivery time is less than one hour away")
    public void theDeliveryTimeIsLessThanOneHourAway() {
        order = new Order(2, 1, "Ahmad", "Chef Ahmad", "Burger", LocalDateTime.now().plusMinutes(30));
        result = notificationSystem.UpcomingOrdersReminder(2, order, 1);
    }

    @Then("the system will send a final reminder to the customer")
    public void theSystemWillSendAFinalReminderToTheCustomer() {
        Assert.assertTrue(result);
    }

    @When("the delivery time is already passed")
    public void theDeliveryTimeIsAlreadyPassed() {
        order = new Order(3, 1, "Ahmad", "Chef Ahmad", "Rice", LocalDateTime.now().minusHours(1));
        result = notificationSystem.UpcomingOrdersReminder(3, order, 1);
    }

    @Then("the system should not send a reminder")
    public void theSystemShouldNotSendAReminder() {
        Assert.assertFalse(result);
    }

    @When("the customer name is missing")
    public void theCustomerNameIsMissing() {
        order = new Order(4, 1, "", "Chef Ahmad", "Rice", LocalDateTime.now().plusHours(2));
        result = notificationSystem.UpcomingOrdersReminder(4, order, 1);
    }

    @Then("the system should fail due to invalid customer data")
    public void theSystemShouldFailDueToInvalidCustomerData() {
        Assert.assertFalse(result);
    }

    @When("the chef name is missing")
    public void theChefNameIsMissing() {
        order = new Order(5, 1, "Ahmad", "", "Rice", LocalDateTime.now().plusHours(2));
        result = notificationSystem.UpcomingOrdersReminder(5, order, 2);
    }

    @Then("the system should fail due to invalid chef data")
    public void theSystemShouldFailDueToInvalidChefData() {
        Assert.assertFalse(result);
    }

    @When("an invalid reminder type is given")
    public void anInvalidReminderTypeIsGiven() {
        order = new Order(6, 1, "Ahmad", "Chef Ahmad", "Rice", LocalDateTime.now().plusHours(2));
        result = notificationSystem.UpcomingOrdersReminder(6, order, 99);
    }

    @Then("the system should reject the reminder type")
    public void theSystemShouldRejectTheReminderType() {
        Assert.assertFalse(result);
    }

    @When("a reminder is for the chef")
    public void aReminderIsForTheChef() {
        order = new Order(7, 1, "Ahmad", "Chef Ahmad", "Kebab", LocalDateTime.now().plusHours(2));
        result = notificationSystem.UpcomingOrdersReminder(7, order, 2);
    }

    @Then("the system should send a reminder to the chef")
    public void theSystemShouldSendAReminderToTheChef() {
        Assert.assertTrue(result);
    }

    // Additional chef scenarios

    @When("the chef is scheduled to prepare meals today")
    public void theChefIsScheduledToPrepareMealsToday() {
        order = new Order(8, 2, "Client", "Chef John", "Steak", LocalDateTime.now().plusHours(4));
        result = notificationSystem.UpcomingOrdersReminder(8, order, 2);
    }

    @Then("the system will send a task notification")
    public void theSystemWillSendATaskNotification() {
        Assert.assertTrue(result);
    }

    @Then("the notification will include meal types and preparation times")
    public void theNotificationWillIncludeMealTypesAndPreparationTimes() {
        Assert.assertTrue(result);
    }

    @When("the system sends a cooking task notification")
    public void theSystemSendsACookingTaskNotification() {
        order = new Order(9, 3, "Client", "Chef Mike", "Pizza", LocalDateTime.now().minusHours(3));
        result = notificationSystem.UpcomingOrdersReminder(9, order, 2);
    }

    @When("the task was already canceled or completed")
    public void theTaskWasAlreadyCanceledOrCompleted() {
        // simulate cancelled/completed logic by providing past time
        Assert.assertFalse(result);
    }

    @Then("the chef will receive an invalid notification")
    public void theChefWillReceiveAnInvalidNotification() {
        Assert.assertFalse(result);
    }

    @Then("the system should discard outdated tasks")
    public void theSystemShouldDiscardOutdatedTasks() {
        Assert.assertFalse(result);
    }

    @When("the system attempts to notify the chef")
    public void theSystemAttemptsToNotifyTheChef() {
        order = new Order(10, 4, "Client", "", "Soup", LocalDateTime.now().plusHours(1));
        result = notificationSystem.UpcomingOrdersReminder(10, order, 2);
    }

    @When("the chef's contact information is missing or invalid")
    public void theChefContactInfoIsMissing() {
        Assert.assertFalse(result);
    }

    @Then("the system will fail to send the notification")
    public void theSystemWillFailToSendTheNotification() {
        Assert.assertFalse(result);
    }
}

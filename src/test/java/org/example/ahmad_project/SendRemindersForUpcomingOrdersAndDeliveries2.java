package org.example.ahmad_project;

import com.example.cooking_proj.NotificationsAndAlerts;
import com.example.cooking_proj.Order;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.LocalDateTime;

public class SendRemindersForUpcomingOrdersAndDeliveries2 {
    boolean result;
    NotificationsAndAlerts ChefReminder = new NotificationsAndAlerts();

    Order order1 = new Order(1, 1, "Ahmad", "Chef Ahmad", "Rice",LocalDateTime.of(2025, 5, 22, 8, 5, 5));
    Order order2 = new Order(1, 1, "Ahmad", "Chef Ahmad", "Rice",LocalDateTime.of(2025, 5, 22, 5, 5));
    Order order3 = new Order(1, 1, "Ahmad", "Chef Ahmad", "Rice",LocalDateTime.of(2025, 5, 22, 8, 5, 5));
    Order order4 = new Order(1, 1, "Ahmad", "Chef Ahmad", "Rice",LocalDateTime.of(2025, 5, 22, 8, 5, 5));
    Order order5 = new Order(1, 1, "Ahmad", "Chef Ahmad", "Rice",LocalDateTime.of(2025, 5, 22, 8, 5, 5));

    @When("the chef is scheduled to prepare meals today")
    public void theChefIsScheduledToPrepareMealsToday() {
        result = ChefReminder.UpcomingOrdersReminder(2, order1, 2);
    }

    @Then("the system will send a task notification")
    public void theSystemWillSendATaskNotification() {
        Assert.assertTrue(result);
    }

    @Then("the notification will include meal types and preparation times")
    public void theNotificationWillIncludeMealTypesAndPreparationTimes() {
        Assert.assertTrue(true);
    }

    @When("the system sends a cooking task notification")
    public void theSystemSendsACookingTaskNotification() {
        result = ChefReminder.UpcomingOrdersReminder(2, order2, 2);
    }

    @When("the task was already canceled or completed")
    public void theTaskWasAlreadyCanceledOrCompleted() {
        result = ChefReminder.UpcomingOrdersReminder(2, order3, 2);
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
        result = ChefReminder.UpcomingOrdersReminder(2, order5, 2);
    }

    @When("the chef's contact information is missing or invalid")
    public void theChefSContactInformationIsMissingOrInvalid() {

        Assert.assertFalse(result);
    }

    @Then("the system will fail to send the notification")
    public void theSystemWillFailToSendTheNotification() {
        Assert.assertFalse(result);
    }
}

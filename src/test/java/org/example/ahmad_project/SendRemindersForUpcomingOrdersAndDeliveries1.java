package org.example.ahmad_project;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.cooking_proj.NotificationsAndAlerts;
import com.example.cooking_proj.Order;
import org.junit.Assert;

import java.time.LocalDateTime;

public class SendRemindersForUpcomingOrdersAndDeliveries1 {

    boolean result;
    NotificationsAndAlerts CustomerReminder = new NotificationsAndAlerts();
    Order order;


    @When("the customer has a meal scheduled for delivery")
    public void theCustomerHasAMealScheduledForDelivery() {
        order = new Order(1, 1, "Ahmad", "Chef Ahmad", "Rice", LocalDateTime.now().plusHours(3));
        result = CustomerReminder.UpcomingOrdersReminder(1, order, 1);
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
        order = new Order(1, 1, "Ahmad", "Chef Ahmad", "Burger", LocalDateTime.now().plusMinutes(30));
        result = CustomerReminder.UpcomingOrdersReminder(1, order, 1);
    }

    @Then("the system will send a final reminder to the customer")
    public void theSystemWillSendAFinalReminderToTheCustomer() {
        Assert.assertTrue(result);
    }

    @When("the delivery time is already passed")
    public void theDeliveryTimeIsAlreadyPassed() {
        order = new Order(1, 1, "Ahmad", "Chef Ahmad", "Rice", LocalDateTime.now().minusHours(1));
        result = CustomerReminder.UpcomingOrdersReminder(1, order, 1);
    }

    @Then("the system should not send a reminder")
    public void theSystemShouldNotSendAReminder() {
        Assert.assertFalse(result);
    }


    @When("the customer name is missing")
    public void theCustomerNameIsMissing() {
        order = new Order(1, 1, "", "Chef Ahmad", "Rice", LocalDateTime.now().plusHours(2));
        result = CustomerReminder.UpcomingOrdersReminder(1, order, 1);
    }

    @Then("the system should fail due to invalid customer data")
    public void theSystemShouldFailDueToInvalidCustomerData() {
        Assert.assertFalse(result);
    }


    @When("the chef name is missing")
    public void theChefNameIsMissing() {
        order = new Order(1, 1, "Ahmad", "", "Rice", LocalDateTime.now().plusHours(2));
        result = CustomerReminder.UpcomingOrdersReminder(1, order, 2);
    }

    @Then("the system should fail due to invalid chef data")
    public void theSystemShouldFailDueToInvalidChefData() {
        Assert.assertFalse(result);
    }


    @When("an invalid reminder type is given")
    public void anInvalidReminderTypeIsGiven() {
        order = new Order(1, 1, "Ahmad", "Chef Ahmad", "Rice", LocalDateTime.now().plusHours(2));
        result = CustomerReminder.UpcomingOrdersReminder(1, order, 99); // invalid type
    }

    @Then("the system should reject the reminder type")
    public void theSystemShouldRejectTheReminderType() {
        Assert.assertFalse(result);
    }


    @When("a reminder is for the chef")
    public void aReminderIsForTheChef() {
        order = new Order(1, 1, "Ahmad", "Chef Ahmad", "Kebab", LocalDateTime.now().plusHours(2));
        result = CustomerReminder.UpcomingOrdersReminder(1, order, 2);
    }

    @Then("the system should send a reminder to the chef")
    public void theSystemShouldSendAReminderToTheChef() {
        Assert.assertTrue(result);
    }
}

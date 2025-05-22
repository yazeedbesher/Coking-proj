package org.example.ahmad_project;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.cooking_proj.NotificationsAndAlerts;
import com.example.cooking_proj.Order;
import org.junit.Assert;

import javax.swing.*;
import java.time.LocalDateTime;

public class SendRemindersForUpcomingOrdersAndDeliveries1 {
    boolean result;
    NotificationsAndAlerts CustomerReminder=new NotificationsAndAlerts() ;
    Order order1 = new Order(1, 1, "Ahmad", "Chef Ahmad", "Ahmad Meal");
    Order order2 = new Order(1, 1, "Ahmad", "Chef Ahmad",  "Ahmad Meal");
//Order order3 = new Order(1, 1, LocalDateTime.now(), "Ahmad", "Snack", LocalDateTime.now().plusMinutes(30));


   @When("the customer has a meal scheduled for delivery")
    public void theCustomerHasAMealScheduledForDelivery() {
        result=CustomerReminder.UpcomingOrdersReminder(1,order1,1);
    }
    @Then("the system will send a reminder notification")
    public void theSystemWillSendAReminderNotification() {
        Assert.assertTrue(result);

    }
    @Then("the reminder will include the delivery time and meal details")
    public void theReminderWillIncludeTheDeliveryTimeAndMealDetails() {

    }



    @When("the delivery time is less than one hour away")
    public void theDeliveryTimeIsLessThanOneHourAway() {
       result=CustomerReminder.UpcomingOrdersReminder(1,order2,1);
    }
    @Then("the system will send a final reminder to the customer")
    public void theSystemWillSendAFinalReminderToTheCustomer() {

       Assert.assertTrue(result);

    }



}

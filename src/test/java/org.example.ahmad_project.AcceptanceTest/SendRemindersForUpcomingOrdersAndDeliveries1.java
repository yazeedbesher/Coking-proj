package org.example.ahmad_project.AcceptanceTest;

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
    Order order1=new Order(1,1, LocalDateTime.now(),"Ahmad","My favorite snack",LocalDateTime.now().plusSeconds(30));
    Order order2=new Order(1,1, LocalDateTime.now(),"Ahmad","My favorite snack",LocalDateTime.now().plusHours(2));
    Order order3 = new Order(1, 1, LocalDateTime.now(), "Ahmad", "Snack", LocalDateTime.now().plusMinutes(30));


   @When("the customer has a meal scheduled for delivery")
    public void theCustomerHasAMealScheduledForDelivery() {
        //JOptionPane.showMessageDialog(null,"The customer has a meal scheduled for delivery");
        result=CustomerReminder.UpcomingOrdersReminder(1,order1);
    }
    @Then("the system will send a reminder notification")
    public void theSystemWillSendAReminderNotification() {
        Assert.assertTrue(result);
       // JOptionPane.showMessageDialog(null," The system will send a reminder notification");
    }
    @Then("the reminder will include the delivery time and meal details")
    public void theReminderWillIncludeTheDeliveryTimeAndMealDetails() {

    }



    @When("the delivery time is less than one hour away")
    public void theDeliveryTimeIsLessThanOneHourAway() {
       //JOptionPane.showMessageDialog(null,"The customer has a meal scheduled for delivery");
       result=CustomerReminder.UpcomingOrdersReminder(1,order2);
    }
    @Then("the system will send a final reminder to the customer")
    public void theSystemWillSendAFinalReminderToTheCustomer() {

       Assert.assertTrue(result);
       //JOptionPane.showMessageDialog(null," The system send a reminder notification");
    }

    @When("the system tries to send a reminder")
    public void theSystemTriesToSendAReminder() {
       CustomerReminder.makeRunTimeError();
        result=CustomerReminder.UpcomingOrdersReminder(1,order3);
    }
    @When("an error happens")
    public void anErrorHappens() {
        Assert.assertFalse(result);

    }
    @Then("the system will not send the reminder")
    public void theSystemWillNotSendTheReminder() {
    //JOptionPane.showMessageDialog(null, "system will not send the reminder");
    }


}

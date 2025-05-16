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
 NotificationsAndAlerts Customer=new NotificationsAndAlerts() ;
    //LocalDateTime time1=LocalDateTime.now();
    //LocalDateTime Time22=LocalDateTime.now();
    //Time22 = Time22.plusSeconds(10);
   Order order1=new Order(1,1, LocalDateTime.now(),"Ahmad","My favorite snack",LocalDateTime.now().plusSeconds(30));
   Order order2=new Order(1,1, LocalDateTime.now(),"Ahmad","My favorite snack",LocalDateTime.now());


   @When("the customer has a meal scheduled for delivery")
    public void theCustomerHasAMealScheduledForDelivery() {
        //JOptionPane.showMessageDialog(null,"The customer has a meal scheduled for delivery");
        result=Customer.UpcomingOrdersReminder(1,order1);
    }
    @Then("the system will send a reminder notification")
    public void theSystemWillSendAReminderNotification() {
        Assert.assertTrue(result);
        //JOptionPane.showMessageDialog(null," The system will send a reminder notification");
    }
    @Then("the reminder will include the delivery time and meal details")
    public void theReminderWillIncludeTheDeliveryTimeAndMealDetails() {

    }



    @When("the delivery time is less than one hour away")
    public void theDeliveryTimeIsLessThanOneHourAway() {
       //JOptionPane.showMessageDialog(null,"The customer has a meal scheduled for delivery");
       //result=Customer.UpcomingOrdersReminder(60,order);
    }
    @Then("the system will send a final reminder to the customer")
    public void theSystemWillSendAFinalReminderToTheCustomer() {

    //   Assert.assertTrue(result);
       //JOptionPane.showMessageDialog(null," The system send a reminder notification");
    }


    @When("the system sends a reminder for a meal delivery")
    public void theSystemSendsAReminderForAMealDelivery() {

    }
    @When("the customer ID is incorrectly matched")
    public void theCustomerIDIsIncorrectlyMatched() {

    }
    @Then("the wrong customer will receive the reminder")
    public void theWrongCustomerWillReceiveTheReminder() {

    }
    @Then("the system will log a delivery mismatch error")
    public void theSystemWillLogADeliveryMismatchError() {

    }

}

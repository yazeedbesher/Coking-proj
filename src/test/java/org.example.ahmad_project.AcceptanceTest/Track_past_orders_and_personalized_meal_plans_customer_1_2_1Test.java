package org.example.ahmad_project.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ahmad_project.Track_past_orders_and_personalized_meal_plans;
import org.example.ahmad_project.Track_past_orders_and_personalized_meal_plans.*;
import org.junit.Assert;

import javax.swing.*;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class Track_past_orders_and_personalized_meal_plans_customer_1_2_1Test {
    Track_past_orders_and_personalized_meal_plans past_orders=new Track_past_orders_and_personalized_meal_plans();
    ArrayList<String> result ;

    @When("the customer navigates to the Past Orders page without any previous orders")
    public void theCustomerNavigatesToThePastOrdersPageWithoutAnyPreviousOrders() {
    //JOptionPane.showMessageDialog(null,"The past Orders page has opened without any previous orders");
    }
    @Then("the system will return an empty list")
    public void theSystemWillReturnAnEmptyList() {

        result = past_orders.getPastOrder();
    }
    @Then("the system will display the message: You have no past meal orders")
    public void theSystemWillDisplayTheMessageYouHaveNoPastMealOrders() {
    Assert.assertEquals(new ArrayList<>(), result);
    //JOptionPane.showMessageDialog(null,"You have no past meal orders.");
    }
    @Then("the page will invite the customer to place their first order")
    public void thePageWillInviteTheCustomerToPlaceTheirFirstOrder() {
    //JOptionPane.showMessageDialog(null,"you can place your first order");
    }





    @When("the customer navigates to the Past Orders page with existing orders")
    public void theCustomerNavigatesToThePastOrdersPageWithExistingOrders() {
    //JOptionPane.showMessageDialog(null,"the past Orders page has opened with existing orders");
    }
    @Then("the system will return a list of past meal orders")
    public void theSystemWillReturnAListOfPastMealOrders() {
    past_orders.addPastOrder(List("Past Order 1", "Past Order 2", "Past Order 3"));
    result = past_orders.getPastOrder();
    }
    @Then("the system will display the list of past meal orders")
    public void theSystemWillDisplayTheListOfPastMealOrders() {
    Assert.assertEquals(List("Past Order 1","Past Order 2","Past Order 3"), result);
        String string = "";
        for(String s:result) {
            string+="\n"+s;

        }
       // JOptionPane.showMessageDialog(null,string);
    }
    @Then("the page will invite the customer to place another order")
    public void thePageWillInviteTheCustomerToPlaceAnotherOrder() {
       // JOptionPane.showMessageDialog(null, "you can place your another order");
    }









    private ArrayList<String> List(String ... strings) {
        ArrayList<String>list =new ArrayList<>();
        for(String s: strings){
            list.add(s);
        }
        return list;

    }



}

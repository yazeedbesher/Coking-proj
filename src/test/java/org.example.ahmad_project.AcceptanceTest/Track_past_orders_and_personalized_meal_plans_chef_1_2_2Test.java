package org.example.ahmad_project.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ahmad_project.Track_past_orders_and_personalized_meal_plans;
import org.junit.Assert;

import javax.swing.*;
import java.util.ArrayList;

public class Track_past_orders_and_personalized_meal_plans_chef_1_2_2Test {

    Track_past_orders_and_personalized_meal_plans past_orders=new Track_past_orders_and_personalized_meal_plans();
    ArrayList<String> result ;

    @When("the chef navigates to the customers’ order history page without any previous orders")
    public void theChefNavigatesToTheCustomersOrderHistoryPageWithoutAnyPreviousOrders() {
    JOptionPane.showMessageDialog(null ,"The customers’ order history page opened without any previous orders");
    }
    @Then("the system will return an empty customers’ order history list")
    public void theSystemWillReturnAnEmptyCustomersOrderHistoryList() {
    result =past_orders.getPastOrder();
    }
    @Then("the system will display the message: there is no customers’ order history")
    public void theSystemWillDisplayTheMessageThereIsNoCustomersOrderHistory() {
        Assert.assertEquals(new ArrayList<>(), result);
        JOptionPane.showMessageDialog(null,"there is no customers’ order history.");
    }




    @When("the chef navigates to the customers’ order history page with existing orders")
    public void theChefNavigatesToTheCustomersOrderHistoryPageWithExistingOrders() {
    JOptionPane.showMessageDialog(null,"The customers’ order history page opened with existing orders");
    }
    @Then("the system will return a list of customers’ order history")
    public void theSystemWillReturnAListOfCustomersOrderHistory() {
        past_orders.addPastOrder("Order 1");
        past_orders.addPastOrder("Order 2");
    result = past_orders.getPastOrder();
    }
    @Then("the system will display the list of customers’ order history")
    public void theSystemWillDisplayTheListOfCustomersOrderHistory() {
        Assert.assertEquals(List("Order 1","Order 2"), result);
        String string = "";
        for(String s:result) {
            string+="\n"+s;

        }
         JOptionPane.showMessageDialog(null,string);
    }







    @When("the chef doesnot enter any suggested personalized meal plans")
    public void theChefDoesnotEnterAnySuggestedPersonalizedMealPlans() {

    }
    @Then("the system will display an error masage : no personalized meal plans entered")
    public void theSystemWillDisplayAnErrorMasageNoPersonalizedMealPlansEntered() {

    }

    @When("the chef enter suggested personalized meal plans")
    public void theChefEnterSuggestedPersonalizedMealPlans() {

    }
    @Then("the system will display a success message : Successfully added personalized meal plans")
    public void theSystemWillDisplayASuccessMessageSuccessfullyAddedPersonalizedMealPlans() {

    }



    private ArrayList<String> List(String ... strings) {
        ArrayList<String>list =new ArrayList<>();
        for(String s: strings){
            list.add(s);
        }
        return list;

    }
}

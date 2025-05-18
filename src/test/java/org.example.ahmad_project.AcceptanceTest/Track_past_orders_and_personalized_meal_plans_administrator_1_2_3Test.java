package org.example.ahmad_project.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.cooking_proj.Track_past_orders_and_personalized_meal_plans;
import org.junit.Assert;

import java.util.ArrayList;

public class Track_past_orders_and_personalized_meal_plans_administrator_1_2_3Test {

    Track_past_orders_and_personalized_meal_plans past_orders_and_personalized_meal_plans=new Track_past_orders_and_personalized_meal_plans();
    boolean result ;
    ArrayList<String> result2;

    @When("the administrator doesn't entered any orders to customer order history")
    public void theAdministratorDoesnTEnteredAnyOrdersToCustomerOrderHistory() {
       // JOptionPane.showMessageDialog(null, "The administrator doesn't enter any orders to the customer order history");
        result=past_orders_and_personalized_meal_plans.addPastOrder(null);
    }

    @Then("the system will display an error message : no customer order history entered")
    public void theSystemWillDisplayAnErrorMessageNoCustomerOrderHistoryEntered() {
        Assert.assertFalse(result);
       // JOptionPane.showMessageDialog(null, "no customer order history entered");
    }


    @When("the administrator entered orders to customer order history")
    public void theAdministratorEnteredOrdersToCustomerOrderHistory() {
    //JOptionPane.showMessageDialog(null,"the administrator entered orders to customer order history");
    //result=past_orders_and_personalized_meal_plans.addPastOrder(List("Order 1","Order 2"));
    }

    @Then("the system will display a success message : Successfully added the order to customer order history")
    public void theSystemWillDisplayASuccessMessageSuccessfullyAddedTheOrderToCustomerOrderHistory() {
        Assert.assertTrue(result);
       // JOptionPane.showMessageDialog(null, "Successfully added the order to customer order history");
    }



    @When("The administrator navigates to the customer order history page, where the orders do not exist")
    public void theAdministratorNavigatesToTheCustomerOrderHistoryPageWhereTheOrdersDoNotExist() {
    //JOptionPane.showMessageDialog(null,"The customer order history page has opened without any customer order");
    //result2=past_orders_and_personalized_meal_plans.getPastOrder();
    }
    @Then("the system will return an empty customer order history list for administrator")
    public void theSystemWillReturnAnEmptyCustomerOrderHistoryListForAdministrator() {
    Assert.assertEquals(new ArrayList<>(),result2);
        //JOptionPane.showMessageDialog(null,"customer order history page empty");
    }
    @Then("the system will display the message: there is no customer order history")
    public void theSystemWillDisplayTheMessageThereIsNoCustomerOrderHistory() {
    //JOptionPane.showMessageDialog(null," there is no customer order history");
    }




    @When("The administrator navigates to the customers’ order history page, where the orders are exist")
    public void theAdministratorNavigatesToTheCustomersOrderHistoryPageWhereTheOrdersAreExist() {
       // JOptionPane.showMessageDialog(null,"The customer order history page has opened with customer orders");
    }
    @Then("the system will return a list of customer order history for  administrator")
    public void theSystemWillReturnAListOfCustomerOrderHistoryForAdministrator() {
    //past_orders_and_personalized_meal_plans.addPastOrder(List("Order 1","Order 2"));
    //result2=past_orders_and_personalized_meal_plans.getPastOrder();

    }
    @Then("the system will display the list of customer order history")
    public void theSystemWillDisplayTheListOfCustomerOrderHistory() {
    Assert.assertEquals(List("Order 1","Order 2"),result2);
    String Orders="";
    for (String order : result2) {
        Orders+="\n"+order;
    }
    //JOptionPane.showMessageDialog(null,Orders);
    }

    private ArrayList<String> List(String ... strings) {
        ArrayList<String>list =new ArrayList<>();
        for(String s: strings){
            list.add(s);
        }
        return list;

    }
}

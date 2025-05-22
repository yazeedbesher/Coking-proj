package org.example.ahmad_project;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.cooking_proj.Track_past_orders_and_personalized_meal_plans;
import org.junit.Assert;

import java.util.ArrayList;

public class Track_past_orders_and_personalized_meal_plans_chef_1_2_2Test {

    Track_past_orders_and_personalized_meal_plans past_orders_and_personalized_meal_plan=new Track_past_orders_and_personalized_meal_plans();
    ArrayList<String> result ;
    boolean result_flag;

    @When("the chef navigates to the customers’ order history page without any previous orders")
    public void theChefNavigatesToTheCustomersOrderHistoryPageWithoutAnyPreviousOrders() {
    //JOptionPane.showMessageDialog(null ,"The customers’ order history page opened without any previous orders");
    }
    @Then("the system will return an empty customers’ order history list")
    public void theSystemWillReturnAnEmptyCustomersOrderHistoryList() {
    //result =past_orders_and_personalized_meal_plan.getPastOrder();
    }
    @Then("the system will display the message: there is no customers’ order history")
    public void theSystemWillDisplayTheMessageThereIsNoCustomersOrderHistory() {
        Assert.assertEquals(new ArrayList<>(), result);
        //JOptionPane.showMessageDialog(null,"there is no customers’ order history.");
    }




    @When("the chef navigates to the customers’ order history page with existing orders")
    public void theChefNavigatesToTheCustomersOrderHistoryPageWithExistingOrders() {
    //JOptionPane.showMessageDialog(null,"The customers’ order history page opened with existing orders");
    }
    @Then("the system will return a list of customers’ order history")
    public void theSystemWillReturnAListOfCustomersOrderHistory() {
//        past_orders_and_personalized_meal_plan.addPastOrder(List("Order 1","Order 2","Order 3"));
//    result = past_orders_and_personalized_meal_plan.getPastOrder();
    }
    @Then("the system will display the list of customers’ order history")
    public void theSystemWillDisplayTheListOfCustomersOrderHistory() {
        Assert.assertEquals(List("Order 1","Order 2","Order 3"), result);
        String string = "";
        for(String s:result) {
            string+="\n"+s;

        }
         //JOptionPane.showMessageDialog(null,string);
    }



//ahmad



    @When("the chef doesn't enter any suggested personalized meal plan")
    public void theChefDoesnTEnterAnySuggestedPersonalizedMealPlan() {
    //JOptionPane.showMessageDialog(null,"the chef leave the personalized meal plan field empty");
    result_flag=past_orders_and_personalized_meal_plan.addPersonalizedMealPlan(null);

    }
    @Then("the system will display an error message : no personalized meal plan entered")
    public void theSystemWillDisplayAnErrorMessageNoPersonalizedMealPlanEntered() {
        Assert.assertFalse(result_flag);
        //JOptionPane.showMessageDialog(null,"no personalized meal plan entered");
    }





    @When("the chef enter suggested personalized meal plan already exist")
    public void theChefEnterSuggestedPersonalizedMealPlanAlreadyExist() {
        //JOptionPane.showMessageDialog(null,"the chef enter personalized meal plan already exist");
        past_orders_and_personalized_meal_plan.addPersonalizedMealPlan("Plane 1");
        result_flag=past_orders_and_personalized_meal_plan.addPersonalizedMealPlan("Plane 1");
    }
    @Then("the system will display an error message : personalized meal plan you entered is already exist")
    public void theSystemWillDisplayAnErrorMessagePersonalizedMealPlanYouEnteredIsAlreadyExist() {
        Assert.assertFalse(result_flag);
        //JOptionPane.showMessageDialog(null,"the personalized meal plan you entered is already exist");
    }







    @When("the chef enter suggested personalized meal plan")
    public void theChefEnterSuggestedPersonalizedMealPlan() {
        //JOptionPane.showMessageDialog(null,"the chef enter personalized meal plan");
        result_flag=past_orders_and_personalized_meal_plan.addPersonalizedMealPlan("Plane 1");
    }
    @Then("the system will display a success message : Successfully added personalized meal plan")
    public void theSystemWillDisplayASuccessMessageSuccessfullyAddedPersonalizedMealPlan() {
    Assert.assertTrue(result_flag);
        //JOptionPane.showMessageDialog(null,"personalized meal plan saved successfully");
    }



    private ArrayList<String> List(String ... strings) {
        ArrayList<String>list =new ArrayList<>();
        for(String s: strings){
            list.add(s);
        }
        return list;

    }
}

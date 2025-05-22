package org.example.ahmad_project;

import com.example.cooking_proj.Track_past_orders_and_personalized_meal_plans;
import org.junit.Assert;

import io.cucumber.java.en.*;
import java.time.LocalDateTime;
import java.util.List;

public class TrackOrdersTest {

    private Track_past_orders_and_personalized_meal_plans tracker;
    private List<com.example.cooking_proj.Order> pastOrders;
    private boolean result;
    private String message;
    private com.example.cooking_proj.Order testOrder;

    @Given("the system is initialized")
    public void theSystemIsInitialized() {
        tracker = new Track_past_orders_and_personalized_meal_plans();
    }

    @When("the customer navigates to the Past Orders page without any previous orders")
    public void customerNavigatesToPastOrdersPageWithoutOrders() {
        pastOrders = tracker.getPastOrders();
    }

    @Then("the system will return an empty list")
    public void systemReturnsEmptyList() {
        Assert.assertNull(pastOrders);
    }

    @And("the system will display the message: You have no past meal orders")
    public void displayNoOrdersMessage() {
        message = (pastOrders == null) ? "You have no past meal orders" : "";
        Assert.assertEquals("You have no past meal orders", message);
    }

    @And("the page will invite the customer to place their first order")
    public void inviteToPlaceFirstOrder() {
        System.out.println("Place your first order!");
    }

    @When("the customer navigates to the Past Orders page with existing orders")
    public void customerNavigatesWithOrders() {
        testOrder = new com.example.cooking_proj.Order(1, 101, "Ali", "Chef Ahmad", LocalDateTime.now(), "Drink", "Kabsa", LocalDateTime.now());
        tracker.addPastOrder(testOrder);
        pastOrders = tracker.getPastOrders();
    }

    @Then("the system will return a list of past meal orders")
    public void systemReturnsOrderList() {
        Assert.assertNotNull(pastOrders);
        Assert.assertTrue(pastOrders.contains(testOrder));
    }

    @And("the system will display the list of past meal orders")
    public void displayOrderList() {
        System.out.println("Past orders: " + pastOrders);
    }

    @And("the page will invite the customer to place another order")
    public void inviteToPlaceAnotherOrder() {
        System.out.println("Want to order again?");
    }

    @When("the chef navigates to the customers’ order history page without any previous orders")
    public void chefViewsEmptyOrderHistory() {
        pastOrders = tracker.getPastOrders();
    }

    @Then("the system will return an empty customers’ order history list")
    public void systemReturnsEmptyHistoryForChef() {
        Assert.assertNull(pastOrders);
    }

    @And("the system will display the message: there is no customers’ order history")
    public void messageNoCustomerHistory() {
        message = (pastOrders == null) ? "there is no customers’ order history" : "";
        Assert.assertEquals("there is no customers’ order history", message);
    }

    @When("the chef navigates to the customers’ order history page with existing orders")
    public void chefViewsOrderHistoryWithData() {
        testOrder = new com.example.cooking_proj.Order(2, 102, "Sara", "Chef Layla", LocalDateTime.now(), "Juice", "Pizza", LocalDateTime.now());
        tracker.addPastOrder(testOrder);
        pastOrders = tracker.getPastOrders();
    }

    @Then("the system will return a list of customers’ order history")
    public void systemReturnsCustomerHistory() {
        Assert.assertNotNull(pastOrders);
    }

    @And("the system will display the list of customers’ order history")
    public void displayCustomerHistory() {
        System.out.println("Customer order history: " + pastOrders);
    }

    @When("the chef doesn't enter any suggested personalized meal plan")
    public void chefEntersNoPersonalizedPlan() {
        result = tracker.addPersonalizedMealPlan("");
    }

    @Then("the system will display an error message : no personalized meal plan entered")
    public void errorNoPersonalizedMeal() {
        message = (!result) ? "no personalized meal plan entered" : "";
        Assert.assertEquals("no personalized meal plan entered", message);
    }

    @And("the system will return false")
    public void returnFalseForEmptyPlan() {
        Assert.assertFalse(result);
    }

    @When("the chef enter suggested personalized meal plan already exist")
    public void chefEntersDuplicateMeal() {
        tracker.addPersonalizedMealPlan("Vegan Rice");
        result = tracker.addPersonalizedMealPlan("Vegan Rice");
    }

    @Then("the system will display an error message : personalized meal plan you entered is already exist")
    public void duplicateMealErrorMessage() {
        message = (!result) ? "personalized meal plan you entered is already exist" : "";
        Assert.assertEquals("personalized meal plan you entered is already exist", message);
    }

    @When("the chef enter suggested personalized meal plan")
    public void chefAddsNewPersonalizedPlan() {
        result = tracker.addPersonalizedMealPlan("Chicken Caesar Salad");
    }

    @Then("the system will display a success message : Successfully added personalized meal plan")
    public void successPersonalizedMealAdded() {
        message = (result) ? "Successfully added personalized meal plan" : "";
        Assert.assertEquals("Successfully added personalized meal plan", message);
    }

    @When("the administrator doesn't entered any orders to customer order history")
    public void adminAddsNoOrders() {
        result = tracker.addPastOrder(null);
    }

    @Then("the system will display an error message : no customer order history entered")
    public void adminErrorMessage() {
        message = (!result) ? "no customer order history entered" : "";
        Assert.assertEquals("no customer order history entered", message);
    }

    @When("the administrator entered orders to customer order history")
    public void adminAddsOrderToHistory() {
        testOrder = new com.example.cooking_proj.Order(3, 103, "Mohammed", "Chef Sami", LocalDateTime.now(), "Yogurt", "Mansaf", LocalDateTime.now());
        result = tracker.addPastOrder(testOrder);
    }

    @Then("the system will display a success message : Successfully added the order to customer order history")
    public void successMessageAdmin() {
        message = (result) ? "Successfully added the order to customer order history" : "";
        Assert.assertEquals("Successfully added the order to customer order history", message);
    }

    @When("The administrator navigates to the customer order history page, where the orders do not exist")
    public void adminViewsEmptyHistory() {
        pastOrders = tracker.getPastOrders();
    }

    @Then("the system will return an empty customer order history list for administrator")
    public void emptyAdminHistoryList() {
        Assert.assertNull(pastOrders);
    }

    @And("the system will display the message: there is no customer order history")
    public void adminNoHistoryMessage() {
        message = (pastOrders == null) ? "there is no customer order history" : "";
        Assert.assertEquals("there is no customer order history", message);
    }

    @When("The administrator navigates to the customers’ order history page, where the orders are exist")
    public void adminViewsHistoryWithData() {
        testOrder = new com.example.cooking_proj.Order(4, 104, "Lina", "Chef Amani", LocalDateTime.now(), "Soup", "Biryani", LocalDateTime.now());
        tracker.addPastOrder(testOrder);
        pastOrders = tracker.getPastOrders();
    }

    @Then("the system will return a list of customer order history for  administrator")
    public void adminOrderHistoryExists() {
        Assert.assertNotNull(pastOrders);
    }

    @And("the system will display the list of customer order history")
    public void displayAdminOrderHistory() {
        System.out.println("Admin view: " + pastOrders);
    }
}

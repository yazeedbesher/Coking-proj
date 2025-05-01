package com.example.temp.AcceptanceTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

public class Create_Custome_Meal_2_1 {
 // Assume this is the data
  private List<String> availableIngredients = Arrays.asList("Chicken","milk","pasta", "Tomato", "Lettuce", "Cheese", "Beef", "Fish");
  private Map<String, String> incompatiblePairs = new HashMap<>();
  private List<String> selectedIngredients = new ArrayList<>();
  private boolean validationPassed = false;

    public Create_Custome_Meal_2_1() {
        // Setup incompatible ingredient example
        incompatiblePairs.put("Fish", "Cheese");
    }

  @Given("the customer is on the custom meal selection page")
  public void theCustomerIsOnTheCustomMealSelectionPage() {

    selectedIngredients.clear(); // Start fresh
    System.out.println("Customer is on the custom meal page.");

  }

  @When("the customer selects ingredients from the available list")
    public void theCustomerSelectsIngredientsFromTheAvailableList() {

        selectedIngredients.add("Chicken");
        selectedIngredients.add("Tomato");
        System.out.println("Customer selected: " + selectedIngredients);

    }

    @Then("the system should validate the ingredient combinations")
    public void theSystemShouldValidateTheIngredientCombinations() {

        validationPassed = true; // Assume valid at first

        for (String ingredient1 : selectedIngredients) {
            for (String ingredient2 : selectedIngredients) {
                if (incompatiblePairs.containsKey(ingredient1) && incompatiblePairs.get(ingredient1).equals(ingredient2)) {
                    validationPassed = false;
                    break;
                }
            }
        }
        if (validationPassed) {
            System.out.println("Ingredients are valid!");
        } else {
            System.out.println("Invalid ingredient combination detected!");
        }

    }

    @Then("the system should allow the customer to proceed with the order")
    public void theSystemShouldAllowTheCustomerToProceedWithTheOrder() {


    }

    @When("the customer selects unavailable or incompatible ingredients")
    public void theCustomerSelectsUnvailableOrIncompativleIngredient() {
// Simulate selecting an unavailable or incompatible ingredient
        selectedIngredients.add("Fish");
        selectedIngredients.add("Cheese");
        System.out.println("Customer selected: " + selectedIngredients);
    }

    @Then("the system should display an error message")
    public void theSystemShouldDisplayAnErrorMessage() {
        if (!validationPassed) {
            System.out.println("Error: Ingredients are not compatible or unavailable.");
        } else {
            System.out.println("No error, ingredients are fine.");
        }
    }

    @Then("the system should not allow the customer to proceed")
    public void theSystemShouldNotAllowTheCustomerrToProcced() {

        if (!validationPassed) {
            System.out.println("Blocking customer from proceeding.");
        } else {
            System.out.println("Allowing customer (should not happen here).");
            throw new RuntimeException("Invalid logic: Customer proceeded with bad ingredients!");
        }
    }
    @When("the customer does not select any ingredients")
    public void theCustomerDoesNotSelectAnyIngredients() {

}

    @And("Submit the request")
     public void submitTheRequest() {

}

@And("prompt the customer to select at least one ingredient")
    public void promptTheCustomerToSelectAtLeastOneIngredient() {

}
@And("the customer selects Shrimp and Peanut Butter for a meal")
    public void theCustomerSelectsShrimpAndPeanutButterForAMeal() {}

@When("the system checks for ingredient compatibility")
    public void theSystemChecksForIngredientCompatibility() {

}
@Given("the customer selects Truffle Oil")
    public void theCustomerSelectsTruffleOil() {}

    @When("the customer tries to submit the request")
    public void theCustomerTriesToSubmitTheRequest() {}

    @And("Truffle Oil is currently out of stock")
    public void TruffleOilIsCurrentlyOutOfStock() {}

@Given("the customer selects Chicken,Brown Rice, and Spinach")
public void theCustomerSelectsChickenAndBrownRiceAndSpinach() {}

@When("the customer submits the meal request")
public void theCustomerSubmitsTheMealRequest() {}

@And("all ingredients are available and compatible")
    public void allIngredientsAreAvailableAndCompatible() {}




}

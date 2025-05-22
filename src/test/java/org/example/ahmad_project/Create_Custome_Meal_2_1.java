package org.example.ahmad_project;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
if(validationPassed) {
    System.out.println("Customer is on the custom meal selection page.");
}else {
    throw new RuntimeException("validation failed : the customer should not be allowed to proceed");
}

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
if(selectedIngredients.isEmpty()){
    validationPassed = false;
    System.out.println("Cannot submit : no ingredient selected");
}
else {
    System.out.println("Submitting request with ingredients:" + selectedIngredients);
}
}

@And("prompt the customer to select at least one ingredient")
    public void promptTheCustomerToSelectAtLeastOneIngredient() {
if(selectedIngredients.isEmpty()){
    System.out.println("Cannot select at least one ingredient");
}else {
    throw new RuntimeException("Expected no ingredients, but some were selected.");
}
}
@And("the customer selects Shrimp and Peanut Butter for a meal")
    public void theCustomerSelectsShrimpAndPeanutButterForAMeal() {
        selectedIngredients.clear();
        selectedIngredients.add("Shrimp");
        selectedIngredients.add("Peanut");
        incompatiblePairs.put("Shrimp", "Peanut Butter");
        System.out.println("Customer selected: " + selectedIngredients);
}

@When("the system checks for ingredient compatibility")
    public void theSystemChecksForIngredientCompatibility() {
        validationPassed = true;
        for (String ingredient1 : selectedIngredients) {
            for (String ingredient2 : incompatiblePairs.keySet()) {
                if(incompatiblePairs.containsKey(ingredient1) && incompatiblePairs.get(ingredient1).equals(ingredient2)) {
                    validationPassed = false;
                    break;
                }
            }
        }

}
@Given("the customer selects Truffle Oil")
    public void theCustomerSelectsTruffleOil() {
        selectedIngredients.clear();
        selectedIngredients.add("Oil");
        System.out.println("Customer selected: " + selectedIngredients);
}

    @When("the customer tries to submit the request")
    public void theCustomerTriesToSubmitTheRequest() {
       validationPassed =selectedIngredients.stream().allMatch(availableIngredients::contains);
    }

    @And("Truffle Oil is currently out of stock")
    public void TruffleOilIsCurrentlyOutOfStock() {
        availableIngredients = new ArrayList<>(availableIngredients); // Ensure it's mutable
        availableIngredients.remove("Truffle Oil");
        System.out.println("Truffle Oil marked as out of stock.");
    }

@Given("the customer selects Chicken,Brown Rice, and Spinach")
public void theCustomerSelectsChickenAndBrownRiceAndSpinach() {
        selectedIngredients.clear();
        selectedIngredients.addAll(Arrays.asList("Chicken", "Brown Rice", "Spinach"));
        System.out.println("Customer selected: " + selectedIngredients);
}

@When("the customer submits the meal request")
public void theCustomerSubmitsTheMealRequest() {
        validationPassed = true;

        // check if available
        for (String ingredient1 : selectedIngredients) {
            if(!availableIngredients.contains(ingredient1)) {
                validationPassed = false;
                return;
            }
        }
        // check if compatibile
    for(String ingredient1 : selectedIngredients) {
        for(String ingredient2 : selectedIngredients) {
            if(incompatiblePairs.containsKey(ingredient1) && incompatiblePairs.get(ingredient1).equals(ingredient2)) {
                validationPassed = false;
                return;
            }
        }
    }
}

@And("all ingredients are available and compatible")
    public void allIngredientsAreAvailableAndCompatible() {
    availableIngredients = Arrays.asList("Chicken", "Brown Rice", "Spinach", "Tomato");
    incompatiblePairs.clear();
}




}

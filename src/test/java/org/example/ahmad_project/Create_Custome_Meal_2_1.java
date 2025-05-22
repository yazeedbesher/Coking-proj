package org.example.ahmad_project;

import com.example.cooking_proj.Create_Custome_Meal_2;
import io.cucumber.java.en.*;

import java.util.*;

import static org.junit.Assert.*;

public class Create_Custome_Meal_2_1{
//
//    private Create_Custome_Meal_2 mealSystem;
//    private List<String> preference;
//    private List<String> allergies;
//    private List<List> resultMeal;
//    private String lastSuggestedAlternative = "";
//
//    @Given("the customer is on the custom meal selection page")
//    public void theCustomerIsOnTheCustomMealSelectionPage() {
//        mealSystem = new Create_Custome_Meal_2();
//        preference = new ArrayList<>();
//        allergies = new ArrayList<>();
//        System.out.println("Customer is on the custom meal page.");
//    }
//
//    @When("the customer selects ingredients from the available list")
//    public void theCustomerSelectsIngredientsFromTheAvailableList() {
//        preference.addAll(Arrays.asList("Chicken", "Tomato"));
//        System.out.println("Selected ingredients: " + preference);
//    }
//
//    @Then("the system should validate the ingredient combinations")
//    public void theSystemShouldValidateTheIngredientCombinations() {
//        resultMeal = mealSystem.create_meal(preference, allergies);
//        assertNotNull(resultMeal);
//        assertTrue(resultMeal.get(0).size() > 0);
//    }
//
//    @Then("the system should allow the customer to proceed with the order")
//    public void theSystemShouldAllowTheCustomerToProceedWithTheOrder() {
//        assertNotNull(resultMeal);
//        assertTrue(resultMeal.get(0).size() > 0);
//        System.out.println("Meal created successfully: " + resultMeal);
//    }
//
//    @When("the customer selects unavailable or incompatible ingredients")
//    public void theCustomerSelectsUnvailableOrIncompatibleIngredient() {
//        preference.clear();
//        preference.add("Fish");
//        preference.add("Cheese"); // This pair is incompatible
//    }
//
//    @Then("the system should display an error message")
//    public void theSystemShouldDisplayAnErrorMessage() {
//        resultMeal = mealSystem.create_meal(preference, allergies);
//        assertNotNull(resultMeal);
//        System.out.println("Result: " + resultMeal);
//    }
//
//    @Then("the system should not allow the customer to proceed")
//    public void theSystemShouldNotAllowTheCustomerToProceed() {
//        assertNotNull(resultMeal);
//        List<String> ingredientsAfter = resultMeal.get(0);
//        assertFalse(ingredientsAfter.contains("Fish") && ingredientsAfter.contains("Cheese"));
//    }
//
//    @When("the customer does not select any ingredients")
//    public void theCustomerDoesNotSelectAnyIngredients() {
//        preference.clear();
//    }
//
//    @And("Submit the request")
//    public void submitTheRequest() {
//        resultMeal = mealSystem.create_meal(preference, allergies);
//    }
//
//    @Then("the system should display an error message for empty selection")
//    public void systemDisplaysErrorForEmpty() {
//        assertTrue(resultMeal.get(0).isEmpty());
//    }
//
//    @And("prompt the customer to select at least one ingredient")
//    public void promptTheCustomerToSelectAtLeastOneIngredient() {
//        if (resultMeal.get(0).isEmpty()) {
//            System.out.println("Prompting user to select at least one ingredient.");
//        } else {
//            fail("Ingredients should be empty but are not.");
//        }
//    }
//
//    @And("the customer selects Shrimp and Peanut Butter for a meal")
//    public void theCustomerSelectsShrimpAndPeanutButterForAMeal() {
//        preference.clear();
//        preference.add("Shrimp");
//        preference.add("Peanut Butter");
//        mealSystem.incompatiblePairs.put("Shrimp", "Peanut Butter");
//    }
//
//    @When("the system checks for ingredient compatibility")
//    public void theSystemChecksForIngredientCompatibility() {
//        resultMeal = mealSystem.create_meal(preference, allergies);
//    }
//
//    @Then("the system should detect incompatible ingredients")
//    public void theSystemShouldDetectIncompatibility() {
//        List<String> ingredients = resultMeal.get(0);
//        assertFalse(ingredients.contains("Shrimp") && ingredients.contains("Peanut Butter"));
//    }
//
//    @Given("the customer selects Truffle Oil")
//    public void theCustomerSelectsTruffleOil() {
//        preference.clear();
//        preference.add("Truffle Oil");
//    }
//
//    @And("Truffle Oil is currently out of stock")
//    public void TruffleOilIsCurrentlyOutOfStock() {
//        // nothing to do here, handled via system logic
//        allergies.clear(); // no allergies in this test
//    }
//
//    @When("the customer tries to submit the request")
//    public void theCustomerTriesToSubmitTheRequest() {
//        resultMeal = mealSystem.create_meal(preference, allergies);
//    }
//
//    @Then("the system should suggest an alternative for Truffle Oil")
//    public void theSystemShouldSuggestAlternativeForUnavailableIngredient() {
//        List<String> ingredients = resultMeal.get(0);
//        assertFalse(ingredients.contains("Truffle Oil"));
//        System.out.println("Final ingredients used: " + ingredients);
//    }
//
//    @Given("the customer selects Chicken,Brown Rice, and Spinach")
//    public void theCustomerSelectsChickenAndBrownRiceAndSpinach() {
//        preference.clear();
//        preference.addAll(Arrays.asList("Chicken", "Brown Rice", "Spinach"));
//    }
//
//    @And("all ingredients are available and compatible")
//    public void allIngredientsAreAvailableAndCompatible() {
//        // handled via default system setup
//    }
//
//    @When("the customer submits the meal request")
//    public void theCustomerSubmitsTheMealRequest() {
//        resultMeal = mealSystem.create_meal(preference, allergies);
//    }
//
//    @Then("the system should allow the customer to proceed with the order successfully")
//    public void theSystemShouldAllowValidOrder() {
//        assertNotNull(resultMeal);
//        assertTrue(resultMeal.get(0).containsAll(Arrays.asList("Chicken", "Brown Rice", "Spinach")));
//        System.out.println("Valid meal created successfully.");
//    }
//
//    @Given("the customer is allergic to {string}")
//    public void theCustomerIsAllergicTo(String allergen) {
//        allergies.clear();
//        allergies.add(allergen);
//    }
//
//    @When("the customer selects {string} which is an allergen")
//    public void theCustomerSelectsAnAllergen(String ingredient) {
//        preference.clear();
//        preference.add(ingredient);
//    }
//
//    @Then("the system should replace it with a suggested alternative")
//    public void theSystemShouldReplaceWithSuggestedAlternative() {
//        resultMeal = mealSystem.create_meal(preference, allergies);
//        List<String> ingredients = resultMeal.get(0);
//        assertFalse(ingredients.containsAll(allergies));
//        System.out.println("Ingredients after allergy handling: " + ingredients);
//    }
//
//
//@Given("the customer selects ingredients with allergy, incompatibility, and unavailability combined")
//public void theCustomerSelectsAllProblematicIngredients() {
//    preference.clear();
//    preference.addAll(Arrays.asList("Cheese", "Tomato", "Truffle Oil")); // Cheese & Tomato = incompatible, Truffle Oil unavailable
//    allergies.clear();
//    allergies.add("Tomato"); // Tomato is allergen
//}
//
//@Then("the system should replace or remove all problematic ingredients")
//public void theSystemShouldReplaceAllProblematicIngredients() {
//    resultMeal = mealSystem.create_meal(preference, allergies);
//    List<String> ingredients = resultMeal.get(0);
//    assertFalse("Should not contain allergic ingredient", ingredients.contains("Tomato"));
//    assertFalse("Should not contain unavailable ingredient", ingredients.contains("Truffle Oil"));
//    assertFalse("Should not contain both incompatible pair", ingredients.contains("Cheese") && ingredients.contains("Tomato"));
//    System.out.println("Processed ingredients: " + ingredients);
//}
//
//@Given("the customer selects the same ingredient multiple times")
//public void theCustomerSelectsDuplicateIngredients() {
//    preference.clear();
//    preference.addAll(Arrays.asList("Fish", "Fish", "Lettuce", "Cheese"));
//    allergies.clear();
//}
//
//@Then("the system should handle duplicates correctly")
//public void theSystemShouldHandleDuplicates() {
//    resultMeal = mealSystem.create_meal(preference, allergies);
//    Set<String> uniqueIngredients = new HashSet<>(resultMeal.get(0));
//    assertTrue("Duplicates handled", uniqueIngredients.size() <= resultMeal.get(0).size());
//    System.out.println("Meal with duplicates processed: " + resultMeal.get(0));
//}
//
//@Given("the substitute is also in the allergy list")
//public void theSubstituteIsAlsoInTheAllergyList() {
//    preference.clear();
//    preference.add("Cheese"); // Will be replaced with Milk
//    allergies.clear();
//    allergies.add("Milk");
//}
//
//@Then("the system should avoid allergic substitutes")
//public void theSystemShouldAvoidAllergicSubstitutes() {
//    resultMeal = mealSystem.create_meal(preference, allergies);
//    List<String> ingredients = resultMeal.get(0);
//    assertFalse("Should not contain Cheese", ingredients.contains("Cheese"));
//    assertFalse("Should not contain Milk", ingredients.contains("Milk")); // substitution avoided
//    System.out.println("Substitution with allergen avoided: " + ingredients);
//}
//
//@Given("the customer selects an ingredient with no substitution")
//public void theCustomerSelectsNoSubstitutionIngredient() {
//    preference.clear();
//    preference.add("Dragon Fruit"); // Not in substitution map
//    allergies.clear();
//    allergies.add("Dragon Fruit");
//}
//
//@Then("the system should handle missing substitution gracefully")
//public void theSystemShouldHandleMissingSubstitution() {
//    resultMeal = mealSystem.create_meal(preference, allergies);
//    List<String> ingredients = resultMeal.get(0);
//    assertFalse(ingredients.contains("Dragon Fruit"));
//    System.out.println("Missing substitution handled: " + ingredients);
//}
}
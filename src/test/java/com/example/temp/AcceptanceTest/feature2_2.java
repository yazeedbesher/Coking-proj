package com.example.temp.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;


public class feature2_2 {

    private List<String> availableIngredients = Arrays.asList("Chicken","Botato","milk","pasta", "Tomato", "Lettuce", "Cheese", "Beef", "Fish");
    private Map<String, String> substitutionSuggestions = new HashMap<>();
    private String selectedIngredient = "";
    private String suggestedAlternative = "";
    private boolean chefAlerted = false;

    public feature2_2() {
        // alternatives unavailable or restricted ingredients
        substitutionSuggestions.put("Beef", "Tofu");         //  بدل الbeef في Tofu
        substitutionSuggestions.put("Cheese", "Vegan Cheese");
        substitutionSuggestions.put("Fish", "Mushroom");
    }

    @Given("the customer selects an ingredients that unavailable")
    public void theCustomerSelectsAnIngredientsThatUnavailable() {

        selectedIngredient = "Fish";
        System.out.println("Customer selected (unavailable): " + selectedIngredient);

    }

    @When("the system detects the unavailable ingredient")
    public void theSystemDetectsTheUnvailableIngredient() {

        if (!availableIngredients.contains(selectedIngredient)) {
            suggestedAlternative = substitutionSuggestions.getOrDefault(selectedIngredient, "No suggestion available");
            chefAlerted = true;
        }

    }

    @Then("the system suggest an alternative ingredient")
    public void theSysytemSuggestAnAlternativeIngredient() {

        if (!suggestedAlternative.isEmpty()) {
            System.out.println("Suggested alternative: " + suggestedAlternative);
        } else {
            System.out.println("No alternative suggestion available.");
        }
    }

    @Then("the system alerts the chef for approval")
    public void theSystemAlertsTheChefForApproval() {
        if (chefAlerted) {
            System.out.println("Alert sent to chef: Ingredient substitution detected!");
        } else {
            System.out.println("No alert necessary.");
        }

    }

    @Given("the customer selects an ingredients  that does not fit their dietary restrictions")
    public void theCustomerSelectsAnIngredientsThatDoesNotFitTheirDietaryRestrictions() {

        selectedIngredient = "Cheese";
        System.out.println("Customer selected (restricted): " + selectedIngredient);
    }

    @When("the system detects the dietary restriction conflict")
    public void theSystemDetectsTheDietaryRestrictionConflict() {
        if (substitutionSuggestions.containsKey(selectedIngredient)) {
            suggestedAlternative = substitutionSuggestions.get(selectedIngredient);
            chefAlerted = true;
        }

    }

    @Then("the system suggest a suitable alternative ingredient")
    public void theSystemSuggestASuitableAlternativeIngredient() {

        if (!suggestedAlternative.isEmpty()) {
            System.out.println("Suggested alternative (dietary): " + suggestedAlternative);
        } else {
            System.out.println("No alternative suggestion available for dietary restriction.");
        }
    }

}




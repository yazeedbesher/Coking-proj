package org.example.ahmad_project.AcceptanceTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;


public class Suggest_Ingredient_Substitutions_2_2 {

    private List<String> availableIngredients = Arrays.asList("Chicken","Botato","milk","pasta", "Tomato", "Lettuce", "Cheese", "Beef", "Fish");
    private Map<String, String> substitutionSuggestions = new HashMap<>();
    private String selectedIngredient = "";
    private String suggestedAlternative = "";
    private boolean chefAlerted = false;
    private boolean validationPassed = false;

    public Suggest_Ingredient_Substitutions_2_2() {
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
    @Given("the customer selects Grilled Salmon and steamed vegetables")
    public void thecustomerselectsGrilledSalmonAndSteamedVegetables() {
        selectedIngredient = "Grilled Salmon";
        suggestedAlternative = "";
        chefAlerted = false;
        System.out.println("Customer selected (steamed): " + selectedIngredient);
    }

    @And("the system should suggest an alternative")
    public void theSystemShouldSuggestAnAlternative() {
        if (substitutionSuggestions.containsKey(selectedIngredient)) {
            suggestedAlternative = substitutionSuggestions.get(selectedIngredient);
            System.out.println("Suggested alternative: " + suggestedAlternative);
        } else {
            System.out.println("No substitution needed for: " + selectedIngredient);
        }
    }

    @When("the system processes the request")
    public void theSystemProcessesTheRequest() {
        if (!substitutionSuggestions.containsKey(selectedIngredient)) {
            validationPassed = true;
        }
    }

    @Then("the system should proceed without suggesting substitutions")
    public void theSystemShouldProceedWithoutSuggestingSubstitutions() {
        if (suggestedAlternative.isEmpty()) {
            System.out.println("Proceeding without substitution.");
        } else {
            throw new RuntimeException("Unexpected substitution suggested for acceptable ingredients.");
        }
    }

    @And("there are no dietary conflicts or availability issues")
    public void thereAreNoDietaryConflictsAndAvailabilityIssues() {
        System.out.println("No conflicts found. Ingredients are available and suitable.");
    }

@Given("the customer is allergic to nuts")
    public void theCustomerIsAllergicToNuts() {  System.out.println("Customer allergy registered: Nuts");}

    @And("selects Pesto Sauce which contains nuts")
    public void selectsPestoSauceThatContainsNuts() {
        selectedIngredient = "Pesto Sauce";
        substitutionSuggestions.put("Pesto Sauce", "Sunflower Seed Pesto");
        System.out.println("Customer selected: " + selectedIngredient + " (contains nuts)");}

    @And("the system substitutes it with Sunflower Seed Pesto")
    public void theSystemSubstitutesItWithSunflowerSeedPesto() {
        suggestedAlternative = substitutionSuggestions.get(selectedIngredient);
        if (suggestedAlternative != null) {
            System.out.println("Substituted with: " + suggestedAlternative);
        } else {
            System.out.println("No substitution available.");
        }
    }

    @When("the substitution is applied")
    public void theSubstitutionIsApplied() {
        if (!suggestedAlternative.isEmpty()) {
            System.out.println("Substitution applied: " + selectedIngredient + " -> " + suggestedAlternative);
            chefAlerted = true;
        }
    }

    @Given("Miso Paste is out of stock")
    public void misoPasteIsOutOfStock() {
        selectedIngredient = "Miso Paste";
        availableIngredients = new java.util.ArrayList<>(availableIngredients);
        availableIngredients.remove("Miso Paste");
        substitutionSuggestions.put("Miso Paste", "Soy Sauce");
        System.out.println("Miso Paste marked as out of stock.");
    }

    @And("the system substitutes it with Soy Sauce")
    public void theSystemSubstitutesItWithSoySauce() {
        suggestedAlternative = substitutionSuggestions.get(selectedIngredient);
        System.out.println("Substitution suggested: " + suggestedAlternative);
    }

    @Then("the chef should be notified to review and approve the change")
    public void theChefShouldBeNotifiedToReviewAndApproveTheChange() {
        if (suggestedAlternative != null && !suggestedAlternative.isEmpty()) {
            chefAlerted = true;
        }
        if (chefAlerted) {
            System.out.println("Chef has been notified for substitution approval.");
        } else {
            throw new RuntimeException("Chef was not notified when they should have been.");
        }
    }

    @Given("the customer selects all available and compatible ingredients")
    public void theCustomerSelectsAllAvailableAndCompatibleIngredients() {
        selectedIngredient = "Tomato"; // Pick something safe
        suggestedAlternative = "";
        chefAlerted = false;
        System.out.println("Customer selected safe and available ingredients.");
    }

    @Then("the chef should not receive any substitution alert")
    public void theChefShouldNotReceiveAnySubstitutionAlert() {
        if (!chefAlerted) {
            System.out.println("No chef alert necessary.");
        } else {
            throw new RuntimeException("Unexpected chef alert for valid ingredients.");
        }
    }

}




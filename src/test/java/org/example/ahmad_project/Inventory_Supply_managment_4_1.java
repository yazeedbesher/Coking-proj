package org.example.ahmad_project;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Inventory_Supply_managment_4_1 {

    Map<String,Integer>inventory=new HashMap<>();
    Map<String,Integer>thresholds=new HashMap<>();
    String lastCheckedItem = " " ;
    int lastUsedUnits = 0;
    List<String> restockSuggestions= new ArrayList<>();

    @Given("the system has 20 units of Tomatoes in stock")
    public void theSystemHas20UnitsOfTomatoesInStock() {
        inventory.put("Tomatoes",20);
    }

    @When("the kitchen manager checks the inventory for Tomatoes")
    public void theKitchenManagerChecksTheInventoryForTomatoes() {
        lastCheckedItem = "Tomatoes " ;
    }

    @Then("the system should display 20 units available")
    public void theSystemShouldDisplay20UnitsAvailable() {
        assertEquals(20, (int) inventory.get("Tomatoes"));
        System.out.println("Inventory for Tomatoes: " + inventory.get("Tomatoes") + " units.");
    }

    @Given("there are 15 units of Onions in stock")
    public void thereAre15UnitsOfOnionsInStock() {
        inventory.put("Onions",15);
    }

    @When("5 units are used for meal preparation")
    public void theUnitsAreUsedForMealPreparation() {
        lastCheckedItem = "Onions";
        lastUsedUnits = 5;
        inventory.put(lastCheckedItem, inventory.getOrDefault(lastCheckedItem, 0) - lastUsedUnits);
    }

    @Then("the system should update the stock to 10 units")
    public void theSystemShouldUpdateTheStockTo10Units() {
        assertEquals(10, (int) inventory.get("Onions"));
        System.out.println("Updated inventory for Onions: " + inventory.get("Onions") + " units.");
    }

    @Given("Tomatoes has 0 units remaining")
    public void TomatoesHas0UnitsRemaining() {
        inventory.put("Tomatoes", 0);
    }

    @When("the kitchen manager views the ingredient list")
    public void theKitchenManagerViewsTheIngredientList() {
        lastCheckedItem = "Tomatoes";
    }

    @Then("the system should flag Tomatoes as out of stock")
    public void theSystemShouldFlagTomatoesAsOutOfStock() {
        assertEquals(0, (int) inventory.get("Tomatoes"));
        System.out.println("Tomatoes are OUT OF STOCK.");
    }

    @Given("Garlic has 2 units in stock")
    public void GarlicHas2UnitsInStock() {
        inventory.put("Garlic",2);
    }

    @And("the minimum threshold is 5 units")
    public void theMinimumThresholdIs5Units() {
        thresholds.put("Garlic",5);
    }

    @When("the system checks inventory levels")
    public void theSystemChecksInventoryLevels() {
        for (String item : inventory.keySet()) {
            int stock = inventory.get(item);
            int threshold = thresholds.getOrDefault(item, 0);
            if (stock < threshold) {
                restockSuggestions.add(item);
            }
        }
    }

    @Then("it should suggest restocking Garlic")
    public void itShouldSuggestRestockingGarlic() {
        assertTrue(restockSuggestions.contains("Garlic"));
        System.out.println("Suggested to restock: Garlic");
    }

    @Given("Salt has 10 units in stock")
    public void saltHas10UnitsInStock() {
        inventory.put("Salt",10);
        thresholds.put("Salt",5);
    }

    @Then("it should not suggest restocking Salt")
    public void itShouldNotSuggestRestockingSalt() {
        assertFalse(restockSuggestions.contains("Salt"));
        System.out.println("Salt does not need restocking.");
    }

    @Given("Oil has 3 units and Pepper has 1 unit")
    public void OilHas3UnitsAndPepperHas1Units() {
        inventory.put("Oil",3);
        inventory.put("Pepper",1);
    }

    @And("the threshold for each is 5 units")
    public void theThresholdForEachIs5Units() {
        thresholds.put("Oil",5);
        thresholds.put("Pepper",5);
    }

    @When("the system performs a restock check")
    public void theSystemPerformsARestockCheck() {
        restockSuggestions.clear(); // Reset
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            int threshold = thresholds.getOrDefault(entry.getKey(), 0);
            if (entry.getValue() < threshold) {
                restockSuggestions.add(entry.getKey());
            }
        }
    }

    @Then("it should suggest restocking both Oil and Pepper")
    public void itShouldSuggestRestockingBothOilPepper() {
        assertTrue(restockSuggestions.containsAll(Arrays.asList("Oil", "Pepper")));
        System.out.println("Suggested to restock: Oil and Pepper");
    }

}

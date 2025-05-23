package org.example.ahmad_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import com.example.cooking_proj.*;

import static org.junit.jupiter.api.Assertions.*;

public class Inventory_Supply_management_4Test {

    private Inventory_Supply_managment_4 inventory;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory_Supply_managment_4();
        inventory.addIngredient("Flour", 10, 3);
        inventory.addIngredient("Eggs", 5, 2);
        inventory.addIngredient("Milk", 7, 4);
    }

    @Test
    public void testAddIngredient() {
        inventory.addIngredient("Butter", 8, 3);
        // Verify that the ingredient is added correctly
        assertEquals(8, inventory.getQuantities().get("Butter"));
        assertEquals(3, inventory.getThresholds().get("Butter"));
    }

    @Test
    public void testUseIngredient() {
        inventory.useIngredient("Flour", 4);
        // Verify the new quantity after use
        assertEquals(6, inventory.getQuantities().get("Flour"));

        // Test that the quantity doesn't go below 0
        inventory.useIngredient("Flour", 10);
        assertEquals(0, inventory.getQuantities().get("Flour"));
    }

    @Test
    public void testUseNonExistentIngredient() {
        // Try to use an ingredient that doesn't exist
        inventory.useIngredient("Sugar", 5);
        // There should be no "Sugar" in the inventory, so verify it hasn't been modified
        assertNull(inventory.getQuantities().get("Sugar"));
    }

    @Test
    public void testCheckStockLevels() {
        // Here, we would check the output printed by checkStockLevels()
        inventory.checkStockLevels();
        // Verify that stock levels are correctly printed and alert for low stock
    }

    @Test
    public void testSuggestRestocking() {
        inventory.suggestRestocking();
        // Verify that the suggestion correctly identifies items that need restocking
        // For instance, "Eggs" and "Milk" should be listed if their quantities are at or below threshold
    }

    @Test
    public void testFetchRealTimePrices() {
        List<String> items = Arrays.asList("Flour", "Eggs", "Milk");
        inventory.fetchRealTimePrices(items);
        // Ensure real-time prices are fetched and displayed correctly
    }

    @Test
    public void testAutoGeneratePurchaseOrders() {
        inventory.autoGeneratePurchaseOrders();
        // Verify that purchase orders are generated based on quantity thresholds
        // For example, any ingredient with quantity >= 3 should be listed
    }

    @Test
    public void testCheckStockLevelsWithAllRestock() {
        inventory.addIngredient("Butter", 1, 3);  // Threshold is 3, so it should need restocking.
        inventory.checkStockLevels();
        // Verify that "Butter" is identified as needing restocking
    }

    @Test
    public void testMultipleRestocks() {
        inventory.addIngredient("Olive Oil", 2, 5);
        inventory.addIngredient("Butter", 3, 4);
        inventory.addIngredient("Milk", 1, 4);

        // Suggest restocking and verify that items like "Olive Oil", "Milk" are marked for restocking
        inventory.suggestRestocking();
    }

    @Test
    public void testEmptyInventory() {
        // Create a new empty inventory
        Inventory_Supply_managment_4 emptyInventory = new Inventory_Supply_managment_4();

        // Suggest restocking and check that no ingredients are available
        emptyInventory.suggestRestocking();  // Nothing to restock

        // Check stock levels for an empty inventory
        emptyInventory.checkStockLevels();  // No stock should be printed
    }

    @Test
    public void testRestockMultipleIngredients() {
        inventory.addIngredient("Olive Oil", 2, 3);
        inventory.addIngredient("Butter", 3, 2);

        // Use some ingredients and test restocking
        inventory.useIngredient("Olive Oil", 2);
        inventory.useIngredient("Butter", 2);

        inventory.suggestRestocking();  // Check if both "Olive Oil" and "Butter" need restocking
    }

    @Test
    public void testNoRestockRequired() {
        // All ingredients should have quantities above their thresholds
        inventory.addIngredient("Olive Oil", 6, 3);
        inventory.addIngredient("Butter", 5, 4);

        // No ingredients should need restocking
        inventory.suggestRestocking(); // Should not print anything
    }
}

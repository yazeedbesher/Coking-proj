package com.example.cooking_proj;

import java.util.*;

public class Inventory_Supply_managment_4 {

    private Map<String, Integer> quantities = new HashMap<>();
    private Map<String, Integer> thresholds = new HashMap<>();

    public void addIngredient(String name, int quantity, int threshold) {
        quantities.put(name, quantity);
        thresholds.put(name, threshold);
    }

    public void useIngredient(String name, int amount) {
        if (quantities.containsKey(name)) {
            int newQty = quantities.get(name) - amount;
            quantities.put(name, Math.max(newQty, 0));
        } else {
            System.out.println("Ingredient not found: " + name);
        }
    }

    public void checkStockLevels() {
        System.out.println("\n Stock Levels:");
        for (String name : quantities.keySet()) {
            int quantity = quantities.get(name);
            int threshold = thresholds.get(name);
            System.out.println("- " + name + ": " + quantity + " units (threshold: " + threshold + ")");
            if (quantity <= threshold) {
                System.out.println("   Needs restocking!");
            }
        }
    }

    public void suggestRestocking() {
        System.out.println("\n Suggested Restocking:");
        for (String name : quantities.keySet()) {
            int quantity = quantities.get(name);
            int threshold = thresholds.get(name);
            if (quantity <= threshold) {
                System.out.println( name + " - Current: " + quantity + " (Threshold: " + threshold + ")");
            }
        }
    }

    public void fetchRealTimePrices(List<String> items) {
        System.out.println("\n Real-Time Supplier Prices:");
        for (String item : items) {
            System.out.println(item + ": $" + getMockPrice(item));
        }
    }

    public void autoGeneratePurchaseOrders() {
        System.out.println("\n Auto-Generated Purchase Orders:");
        for (String name : quantities.keySet()) {
            if (quantities.get(name) >= 3) {
                System.out.println(" Purchase Order for: " + name);
            }
        }
    }

    private double getMockPrice(String item) {
        Map<String, Double> prices = new HashMap<>();
        prices.put("Flour", 1.5);
        prices.put("Eggs", 0.2);
        prices.put("Milk", 2.0);
        prices.put("Olive Oil", 5.0);
        prices.put("Butter", 3.5);
        return prices.getOrDefault(item, 0.0);
    }


    public Map<String, Integer> getQuantities() {
    return quantities;
    }

    public Map<String, Integer> getThresholds() {
    return thresholds;
    }
}

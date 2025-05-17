package com.example.cooking_proj;

import java.util.*;

public class StockSystem {

    private Map<String, Integer> quantities;
    private Map<String, Integer> thresholds;

    private final List<String> acknowledgedAlerts = new ArrayList<>();
    private final List<String> duplicateAlerts = new ArrayList<>();

    public StockSystem(Map<String, Integer> quantities, Map<String, Integer> thresholds) {
        this.quantities = quantities;
        this.thresholds = thresholds;
    }

    public boolean checkAndSendAlert(String ingredient) {
        int quantity = quantities.getOrDefault(ingredient, 0);
        int threshold = thresholds.getOrDefault(ingredient, 0);

        if (quantity < threshold) {
            if (acknowledgedAlerts.contains(ingredient)) {
                if (!duplicateAlerts.contains(ingredient)) {
                    duplicateAlerts.add(ingredient);
                }
                return true;
            }
            return true;
        }
        return false;
    }

    public void acknowledgeAlert(String ingredient) {
        if (!acknowledgedAlerts.contains(ingredient)) {
            acknowledgedAlerts.add(ingredient);
        }
    }

    public boolean isDuplicateAlert(String ingredient) {
        return duplicateAlerts.contains(ingredient);
    }

    public boolean isManagerAware(String ingredient) {
        return acknowledgedAlerts.contains(ingredient);
    }

    public boolean shouldSuggestRestocking(String ingredient) {
        int quantity = quantities.getOrDefault(ingredient, 0);
        int threshold = thresholds.getOrDefault(ingredient, 0);
        return quantity < threshold;
    }

    public String generateLowStockAlertMessage(String ingredient, String managerName) {
        int quantity = quantities.getOrDefault(ingredient, 0);
        int threshold = thresholds.getOrDefault(ingredient, 0);

        return "Hello " + managerName +
                ",\n⚠️ The stock for ingredient: (" + ingredient + ") is low.\n" +
                "Current Quantity: (" + quantity + ")\n" +
                "Minimum Required Threshold: (" + threshold + ")\n" +
                "Please consider restocking soon.";
    }
}

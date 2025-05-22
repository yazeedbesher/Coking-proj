package com.example.cooking_proj;

import java.util.*;

public class Create_Custome_Meal_2 {
    List<String> ingredients ;// المكونات المتوفرة
    public Map<String, String> incompatiblePairs = new HashMap<>();
    List<String> selectedIngredients; // المكونات المختارة
    List<String> selectedAllegries;
    List<String> Meals;
    List<List> create_meal;
    List<Integer> quantity;
    Map<String, String> substitutionSuggestions = new HashMap<>();// عبي فيها المكونات المقترحة كبديل
    String suggestedAlternative = "  ";
    StockSystem stockSystem;
    Map<List<String>, List<Integer>> Stock;

    public Create_Custome_Meal_2() {
        ingredients = new ArrayList<>();
        quantity = new ArrayList<>();
        Stock = new HashMap<>();
        create_meal = new ArrayList<>();
        selectedIngredients = new ArrayList<>();
        selectedAllegries = new ArrayList<>();
        Meals = new ArrayList<>();

        incompatiblePairs.put("Cheese", "Fish");
        incompatiblePairs.put("Tomato", "milk");
        incompatiblePairs.put("pasta", "Fish");
        incompatiblePairs.put("Lettuce", "Cheese");

        substitutionSuggestions.put("Rice", "pasta");
        substitutionSuggestions.put("Cheese", "Milk");
        substitutionSuggestions.put("Beef", "Chicken");
        substitutionSuggestions.put("Tomato", "Lettuce");
        substitutionSuggestions.put("Lemon", "Salt");

        Meals.add("Kabsa");
        Meals.add("Lazania");
        Meals.add("Fish with Tomato");
        Meals.add("Fried Chicken");

        stockSystem= new StockSystem();
    }

    public String suggest_alternative(String ingredient) {
        for (String sa : selectedAllegries) {
            if (!sa.equals(ingredient)) {
                suggestedAlternative = substitutionSuggestions.get(ingredient);
                System.out.println("Chef ! We had Subtitute "+ingredient+ " with "+ suggestedAlternative);
                break;
            }
        }
        return suggestedAlternative;
    }

    public List<List> create_meal(List<String> preference, List<String> allergies) {
        Stock = stockSystem.getStock();
        Map.Entry<List<String>, List<Integer>> stockMap = Stock.entrySet().iterator().next();
        ingredients = stockMap.getKey();
        quantity = stockMap.getValue();

        this.selectedAllegries = allergies;
        this.selectedIngredients = preference;

        Set<String> seen = new HashSet<>();
        handleUnavailableOrAllergicIngredients(seen);
        handleIncompatibleIngredients();
        handleEmptyStorageItems();

        for (String s : selectedIngredients) {
            stockSystem.decrease_quantity(s);
        }

        create_meal.add(selectedIngredients);
        create_meal.add(selectedAllegries);
        return create_meal;
    }

    private void handleUnavailableOrAllergicIngredients(Set<String> seen) {
        for (int i = 0; i < selectedIngredients.size(); i++) {
            String ingredient = selectedIngredients.get(i);

            if (isUnavailable(ingredient, seen)) {
                replaceAndNotifyUnavailable(ingredient, seen);
            }

            if (isAllergic(ingredient)) {
                replaceAndNotifyAllergy(ingredient);
            }
        }
    }

    private boolean isUnavailable(String ingredient, Set<String> seen) {
        return !ingredients.contains(ingredient) && !seen.contains(ingredient);
    }

    private void replaceAndNotifyUnavailable(String ingredient, Set<String> seen) {
        seen.add(ingredient);
        suggestedAlternative = suggest_alternative(ingredient);
        replaceIngredient(ingredient, suggestedAlternative);
        System.out.println("Sorry, we don't have " + ingredient + ", so the alternative will be " + suggestedAlternative);
    }

    private boolean isAllergic(String ingredient) {
        return selectedAllegries.contains(ingredient);
    }

    private void replaceAndNotifyAllergy(String ingredient) {
        suggestedAlternative = suggest_alternative(ingredient);
        replaceIngredient(ingredient, suggestedAlternative);
        System.out.println("Warning: " + ingredient + " is in the allergy list, so the alternative will be " + suggestedAlternative);
    }

    private void handleIncompatibleIngredients() {
        for (int i = 0; i < selectedIngredients.size(); i++) {
            String ingredient1 = selectedIngredients.get(i);

            for (int j = i + 1; j < selectedIngredients.size(); j++) {
                String ingredient2 = selectedIngredients.get(j);

                if (isIncompatible(ingredient1, ingredient2)) {
                    suggestedAlternative = suggest_alternative(ingredient1);
                    replaceIngredient(ingredient1, suggestedAlternative);
                    System.out.println("Incompatible Pair Found: " + ingredient1 + " and " + ingredient2 +
                            ". Suggested alternative: " + suggestedAlternative);
                }
            }
        }
    }

    private boolean isIncompatible(String ing1, String ing2) {
        return incompatiblePairs.containsKey(ing1) && incompatiblePairs.get(ing1).equals(ing2);
    }

    private void handleEmptyStorageItems() {
        List<String> updatedIngredients = new ArrayList<>();
        Iterator<String> iterator = selectedIngredients.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            stockSystem.Check_quantity(s);

            if (stockSystem.is_empty_storage(s)) {
                suggestedAlternative = suggest_alternative(s);
                System.out.println("Sorry Because We Don't Have " + s + " So Your Alternative Will Be " + suggestedAlternative);
                updatedIngredients.add(suggestedAlternative);
                iterator.remove();
            }
        }

        selectedIngredients.addAll(updatedIngredients);
    }

    private void replaceIngredient(String oldIng, String newIng) {
        selectedIngredients.remove(oldIng);
        selectedIngredients.add(newIng);
    }


    public List<String>GetMeals(){
        return Meals;
    }

}

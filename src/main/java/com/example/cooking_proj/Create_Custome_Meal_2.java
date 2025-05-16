package com.example.cooking_proj;

import java.util.*;

public class Create_Custome_Meal_2 {
    List<String> ingredients = new ArrayList<>();// المكونات المتوفرة
    Map<String, String> incompatiblePairs = new HashMap<>();
    List<String> selectedIngredients; // المكونات المختارة
    List<String> selectedAllegries;
    boolean alertChef = false;
    String notification = "You Have Recieced a New Task To do";
    String mealname = "Meal";
    Scheduling_Task_Managment_3 sch_task;

    Map<String, String> substitutionSuggestions = new HashMap<>();// عبي فيها المكونات المقترحة كبديل
    String suggestedAlternative = "  ";

    public Create_Custome_Meal_2() {
        selectedIngredients = new ArrayList<>();
        selectedAllegries = new ArrayList<>();

        incompatiblePairs.put("Cheese", "Fish");
        incompatiblePairs.put("Tomato", "milk");
        incompatiblePairs.put("pasta", "Fish");
        incompatiblePairs.put("Lettuce", "Cheese");

        substitutionSuggestions.put("pasta", "Rice");
        substitutionSuggestions.put("Cheese", "Milk");
        substitutionSuggestions.put("Beef", "Chicken");
        substitutionSuggestions.put("Tomato", "Lettuce");
        substitutionSuggestions.put("Lemon", "Salt");

        ingredients.add("Chicken");
        ingredients.add("pasta");
        ingredients.add("Rice");
        ingredients.add("Tomato");
        ingredients.add("Lettuce");
        ingredients.add("Cheese");
        ingredients.add("milk");
        ingredients.add("Fish");

    }

    public void add_ingredient(String ingredient) {
        ingredients.add(ingredient);
    }

    public void select_ingredient(String ingredient) {
        selectedIngredients.add(ingredient);
    }

    public void add_incompatible_pair(String pair1, String pair2) {
        incompatiblePairs.put(pair1, pair2);
    }

    public void add_suggested_alternative(String ingredient, String suggestedAlternative) {
        substitutionSuggestions.put(ingredient, suggestedAlternative);
    }

    public String suggest_alternative(String ingredient) {
        for (String sa : selectedAllegries) {
            if (!sa.equals(ingredient)) {
                suggestedAlternative = substitutionSuggestions.get(ingredient);
                break;
            }
        }
        return suggestedAlternative;
    }

    public void alertChef() {

    }

    public void create_meal(List<String> Preference, List<String> Allergies) {
        this.selectedAllegries = Allergies;
        this.selectedIngredients = Preference;

        Set<String> seen = new HashSet<>();

        for (int i = 0; i < selectedIngredients.size(); i++) {
            String ingredient1 = selectedIngredients.get(i);

            if (!ingredients.contains(ingredient1) && !seen.contains(ingredient1)) {
                seen.add(ingredient1);
                suggestedAlternative = suggest_alternative(ingredient1);
                System.out.println("Sorry, we don't have " + ingredient1 + ", so the alternative will be " + suggestedAlternative);
                alertChef();
            }

            if (selectedAllegries.contains(ingredient1)) {
                suggestedAlternative = suggest_alternative(ingredient1);
                System.out.println("Warning: " + ingredient1 + " is in the allergy list, so the alternative will be " + suggestedAlternative);
                alertChef();
            }


            for (int j = i + 1; j < selectedIngredients.size(); j++) {
                String ingredient2 = selectedIngredients.get(j);

                if (incompatiblePairs.containsKey(ingredient1)) {
                    String incompatibleWith = incompatiblePairs.get(ingredient1);
                    if (incompatibleWith.equals(ingredient2)) {
                        suggestedAlternative = suggest_alternative(ingredient1);
                        System.out.println("Incompatible Pair Found: " + ingredient1 + " and " + ingredient2 +
                                ". Suggested alternative: " + suggestedAlternative);
                        alertChef();
                    }
                }
            }
        }
        // here we will start cook .
    }




    @Override
    public String toString() {
        notification = notification + mealname + "\n";
    return notification;
}

}

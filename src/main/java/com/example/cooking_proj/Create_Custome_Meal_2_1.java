package com.example.cooking_proj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Create_Custome_Meal_2_1 {
    List<String> ingredients = new ArrayList<>(); // المكونات المتوفرة
    Map<String , String> incompatiblePairs = new HashMap<>();
    List<String> selectedIngredients = new ArrayList<>(); // المكونات المختارة
    boolean validationPassed = true;

    public Create_Custome_Meal_2_1(List<String> ingredients, List<String> meals, Map<String , String> incompatiblePairs, List<String> selectedIngredients) {
     this.ingredients = ingredients;
     this.incompatiblePairs = incompatiblePairs;
     this.selectedIngredients = selectedIngredients;
    }

    public void add_ingredient(String ingredient){
        ingredients.add(ingredient);
    }

    public void select_ingredient(String ingredient){
        selectedIngredients.add(ingredient);
    }

    public void add_incompatible_pair(String pair1, String pair2){
        incompatiblePairs.put(pair1, pair2);
    }

    public void create_meal(){

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

}

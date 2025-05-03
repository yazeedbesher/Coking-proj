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
    boolean alertChef = false;

    Map<String, String> substitutionSuggestions = new HashMap<>(); // عبي فيها المكونات المقترحة كبديل
    String suggestedAlternative = "  ";

    public Create_Custome_Meal_2_1(List<String> ingredients, Map<String , String> incompatiblePairs, List<String> selectedIngredients) {
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

    public void add_suggested_alternative(String ingredient, String suggestedAlternative){
        substitutionSuggestions.put(ingredient, suggestedAlternative);
    }

    public String suggest_alternative(String ingredient){
        suggestedAlternative= substitutionSuggestions.get(ingredient);
        return suggestedAlternative;
    }
    public void alertChef(){

    }
    public void create_meal(List<String> selectedIngredients){

        for (String ingredient1 : selectedIngredients) {

            for (String ingredient2 : selectedIngredients) {
                if (incompatiblePairs.containsKey(ingredient1) && incompatiblePairs.get(ingredient1).equals(ingredient2)) {
                    validationPassed = false;
                    suggestedAlternative = suggest_alternative(ingredient1); // تبديل المكون الغير متوافق
                    alertChef();
                    break;
                }

                if(!selectedIngredients.contains(ingredient2)){
                    validationPassed = false;
                    suggestedAlternative = suggest_alternative(ingredient2); // تبديل المكون الغير متوفر
                    alertChef();
                    break;
                }

                if(!selectedIngredients.contains(ingredient1)){
                    validationPassed = false;
                    suggestedAlternative = suggest_alternative(ingredient1); // تبديل المكون الغير متوفر
                    alertChef();
                    break;
                }

            }

        }

    }



}

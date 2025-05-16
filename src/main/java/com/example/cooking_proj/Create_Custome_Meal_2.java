package com.example.cooking_proj;

import java.util.*;

public class Create_Custome_Meal_2 {
    List<String> ingredients = new ArrayList<>();// المكونات المتوفرة
    Map<String , String> incompatiblePairs =  new HashMap<>();
    List<String> selectedIngredients; // المكونات المختارة
    boolean alertChef = false;
    String notification = "You Have Recieced a New Task To do" ;
    String mealname = "Meal";
    Scheduling_Task_Managment_3 sch_task;

    Map<String, String> substitutionSuggestions =  new HashMap<>();// عبي فيها المكونات المقترحة كبديل
    String suggestedAlternative = "  ";

    public Create_Custome_Meal_2(List<String> myselectedIngredients) {
     selectedIngredients = new ArrayList<>();
     selectedIngredients.addAll(myselectedIngredients);

        incompatiblePairs.put("Fish", "Cheese");
        incompatiblePairs.put("Tomato", "milk");
        incompatiblePairs.put("Fish", "Lettuce");
        incompatiblePairs.put("pasta", "Fish");
        incompatiblePairs.put("Lettuce", "Cheese");

        substitutionSuggestions.put("Rice", "pasta");
        substitutionSuggestions.put("Cheese", "Milk");
        substitutionSuggestions.put("Chicken", "Beef");
        substitutionSuggestions.put("Tomato", "milk");
        substitutionSuggestions.put("Lettuce", "Tomato");

        ingredients.add("Chicken");
        ingredients.add("pasta");
        ingredients.add("Rice");
        ingredients.add("Tomato");
        ingredients.add("Lettuce");
        ingredients.add("Cheese");
        ingredients.add("milk");
        ingredients.add("Fish");
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

    public void create_meal(){

        for (String ingredient1 : selectedIngredients) {
            for (String ingredient2 : selectedIngredients) {
                if (incompatiblePairs.containsKey(ingredient1) && incompatiblePairs.get(ingredient1).equals(ingredient2)) {
                    suggestedAlternative = suggest_alternative(ingredient1); // تبديل المكون الغير متوافق
                    alertChef();
                    break;
                }

                if(!selectedIngredients.contains(ingredient2)){
                    suggestedAlternative = suggest_alternative(ingredient2); // تبديل المكون الغير متوفر
                    alertChef();
                    break;
                }

                if(!selectedIngredients.contains(ingredient1)){
                    suggestedAlternative = suggest_alternative(ingredient1); // تبديل المكون الغير متوفر
                    alertChef();
                    break;
                }
                // start creating the Meal .

            }

        }
        sch_task.Task_Managment();
    }

@Override
    public String toString() {
        notification = notification + mealname + "\n";
    return notification;
}

}

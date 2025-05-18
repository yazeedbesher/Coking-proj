package com.example.cooking_proj;

import java.util.*;

public class Create_Custome_Meal_2 {
    List<String> ingredients ;// المكونات المتوفرة
    Map<String, String> incompatiblePairs = new HashMap<>();
    List<String> selectedIngredients; // المكونات المختارة
    List<String> selectedAllegries;
    String notification = "You Have Recieced a New Task To do";
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
                System.out.println("Chef ! We had Subtitute "+ingredient+ "With "+ suggestedAlternative);
                break;
            }
        }
        return suggestedAlternative;
    }

    public void alertChef() {

    }

    public List<List> create_meal(List<String> Preference, List<String> Allergies) {
        Stock = stockSystem.getStock();

        Map.Entry<List<String>, List<Integer>> StockMap = Stock.entrySet().iterator().next();
        ingredients = StockMap.getKey();
        quantity = StockMap.getValue();

        this.selectedAllegries = Allergies;
        this.selectedIngredients = Preference;

        Set<String> seen = new HashSet<>();

        for (int i = 0; i < selectedIngredients.size(); i++) {
            String ingredient1 = selectedIngredients.get(i);

            if(stockSystem.Check_quantity(ingredient1)){

            if (!ingredients.contains(ingredient1) && !seen.contains(ingredient1)) {
                seen.add(ingredient1);
                suggestedAlternative = suggest_alternative(ingredient1);
                selectedIngredients.remove(ingredient1);
                selectedIngredients.add(suggestedAlternative);
                System.out.println("Sorry, we don't have " + ingredient1 + ", so the alternative will be " + suggestedAlternative);
                alertChef();
            }

            if (selectedAllegries.contains(ingredient1)) {
                suggestedAlternative = suggest_alternative(ingredient1);
                selectedIngredients.remove(ingredient1);
                selectedIngredients.add(suggestedAlternative);
                System.out.println("Warning: " + ingredient1 + " is in the allergy list, so the alternative will be " + suggestedAlternative);
                alertChef();
            }


            for (int j = i + 1; j < selectedIngredients.size(); j++) {
                String ingredient2 = selectedIngredients.get(j);

                if (incompatiblePairs.containsKey(ingredient1)) {
                    String incompatibleWith = incompatiblePairs.get(ingredient1);
                    if (incompatibleWith.equals(ingredient2)) {
                        suggestedAlternative = suggest_alternative(ingredient1);
                        selectedIngredients.remove(ingredient1);
                        selectedIngredients.add(suggestedAlternative);
                        System.out.println("Incompatible Pair Found: " + ingredient1 + " and " + ingredient2 +
                                ". Suggested alternative: " + suggestedAlternative);
                        alertChef();
                    }
                }
            }
        }
            else{
                suggestedAlternative = suggest_alternative(ingredient1);
                selectedIngredients.remove(ingredient1);
                selectedIngredients.add(suggestedAlternative);
                System.out.println("Sorry We dont Have "+ingredient1+ "Now So the Alternative Will Be + "+suggestedAlternative);
            }
        }
        create_meal.add(selectedIngredients);
       create_meal.add(selectedAllegries);

        return create_meal;
    }
    public List<String>GetMeals(){
        return Meals;
    }




    @Override
    public String toString() {
        notification = notification + "\n";
    return notification;
}

}

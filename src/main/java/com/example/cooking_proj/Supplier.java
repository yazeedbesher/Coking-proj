package com.example.cooking_proj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Supplier {
    List<String> ingredients;
    List<Integer> Price;
    Map<List<String>, List<Integer>> supply;

    public Supplier() {
        ingredients = new ArrayList<>();
        Price = new ArrayList<>();
        supply = new HashMap<>();

        ingredients.add("Chicken");
        Price.add(30);
        ingredients.add("pasta");
        Price.add(8);
        ingredients.add("Rice");
        Price.add(5);
        ingredients.add("Tomato");
        Price.add(3);
        ingredients.add("Lettuce");
        Price.add(2);
        ingredients.add("Cheese");
        Price.add(7);
        ingredients.add("milk");
        Price.add(9);
        ingredients.add("Fish");
        Price.add(45);
        ingredients.add("Egg");
        Price.add(1);
        ingredients.add("Onion");
        Price.add(2);

        supply.put(ingredients, Price);
    }

    public Map<List<String>, List<Integer>> getSupply() {
        return supply;
    }

    public Integer Check_Price(String ingredient) {
        int index = ingredients.indexOf(ingredient);
        if (index == -1 || index >= Price.size()) {
            return null;  // ingredient not found or index out of range
        }
        return Price.get(index);
    }
}

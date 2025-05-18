package com.example.cooking_proj;

import java.util.*;

public class StockSystem {

    List<String> ingredients;
    List<Integer> quantity;
    Map<List<String>, List<Integer>> Stock;
    Manager manager;

    public StockSystem() {
        Stock = new HashMap<>();
        ingredients = new ArrayList<>();
        quantity = new ArrayList<>();

        ingredients.add("Chicken");
        quantity.add(3);
        ingredients.add("pasta");
        quantity.add(5);
        ingredients.add("Rice");
        quantity.add(1);
        ingredients.add("Tomato");
        quantity.add(6);
        ingredients.add("Lettuce");
        quantity.add(8);
        ingredients.add("Cheese");
        quantity.add(4);
        ingredients.add("milk");
        quantity.add(3);
        ingredients.add("Fish");
        quantity.add(4);

        Stock.put(ingredients, quantity);
    }

    public Map<List<String>, List<Integer>> getStock(){
        return Stock;
    }

    public boolean Check_quantity(String ingredient){
        boolean flag = true;

        if (ingredients.contains(ingredient)) {
            int index = ingredients.indexOf(ingredient);
            int correspondingValue = quantity.get(index);

            if(correspondingValue < 4) {
                if(correspondingValue == 0) {
                    Empty_storage(ingredient,correspondingValue);
                    Automatic_Restocking(ingredient);
                    return false;
                }
                if(correspondingValue == 1 ) {
                    Almost_End(ingredient,correspondingValue);
                    Automatic_Restocking(ingredient);
                     return flag;
                }
                Alert_quantity(ingredient,correspondingValue);
                Automatic_Restocking(ingredient);
            }

        }
        return flag;
    }

    public void Automatic_Restocking(String ingredient) {
        System.out.println("Depend on Low Storage quantity -> System Automatic Restocking "+ ingredient );

        if (ingredients.contains(ingredient)) {
            int index = ingredients.indexOf(ingredient);
            int correspondingValue = quantity.get(index);
            quantity.set(index, correspondingValue += 3);
            System.out.println("The new quantity of "+ ingredient+" is "+quantity.get(index) );
        }

    }

    public void Alert_quantity(String name,Integer quantity){
        System.out.println("Manager Alert : The Storages has Low -> " +name + " The quantity is Very Low : "+ quantity);
        System.out.println("Try To Contact with Any Supplier immedietly !");
    }
    public void Almost_End(String name,Integer quantity){
        System.out.println("Manager Alert:This is Last Pease of -> " +name);
        System.out.println("Try To Contact with Any Supplier immedietly !");
    }
    public void Empty_storage(String name,Integer quantity){
        System.out.println("Manager Alert:We Dont Have -> " +name);
        System.out.println("Try To Contact with Any Supplier immedietly !");
    }

}

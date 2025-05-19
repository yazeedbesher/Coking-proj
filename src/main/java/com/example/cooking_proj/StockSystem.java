package com.example.cooking_proj;

import java.util.*;

public class StockSystem {

    List<String> ingredients;
    List<Integer> quantity;
    Map<List<String>, List<Integer>> Stock;
    Supplier supplier;

    public StockSystem() {
        Stock = new HashMap<>();
        ingredients = new ArrayList<>();
        quantity = new ArrayList<>();
        supplier = new Supplier();

        ingredients.add("Chicken");
        quantity.add(3);
        ingredients.add("pasta");
        quantity.add(5);
        ingredients.add("Rice");
        quantity.add(0);
        ingredients.add("Tomato");
        quantity.add(6);
        ingredients.add("Lettuce");
        quantity.add(8);
        ingredients.add("Cheese");
        quantity.add(4);
        ingredients.add("milk");
        quantity.add(3);
        ingredients.add("Egg");
        quantity.add(10);
        ingredients.add("Onion");
        quantity.add(12);

        Stock.put(ingredients, quantity);
    }

    public Map<List<String>, List<Integer>> getStock(){
        return Stock;
    }

    public void Check_quantity(String ingredient){

        if (ingredients.contains(ingredient)) {
            int index = ingredients.indexOf(ingredient);
            int correspondingValue = quantity.get(index);

            if(correspondingValue < 4) {
                if(correspondingValue == 0) {
                    Empty_storage(ingredient,correspondingValue);
                    Automatic_Restocking(ingredient);
                    return;
                }
                if(correspondingValue == 1 ) {
                    Almost_End(ingredient,correspondingValue);
                    Automatic_Restocking(ingredient);
                    return;
                }
                Alert_quantity(ingredient,correspondingValue);
                Automatic_Restocking(ingredient);
            }

        }
    }

    public void decrease_quantity(String ingredient){
        int index = ingredients.indexOf(ingredient);
        int correspondingValue = quantity.get(index);
        quantity.set(index, correspondingValue - 1);
        System.out.println("The new quantity of "+ ingredient+" is "+quantity.get(index) );
    }

    public void increase_quantity(Integer quantity_buy,String ingredient){
        int index = ingredients.indexOf(ingredient);
        int correspondingValue = quantity.get(index);
        quantity.set(index, correspondingValue + quantity_buy);
        System.out.println("The new quantity of "+ ingredient+" is "+quantity.get(index) );
    }

    public void Automatic_Restocking(String ingredient) {
        System.out.println("System : Depend on Low Storage quantity -> System suggest  Automatic Restocking "+ ingredient );

        System.out.println("Manager : Do You Want Automatic Restocking For " + ingredient + "\n" +"The Price is :"+supplier.Check_Price(ingredient)+ " ?  0- No 1-Yes");
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());

        if(id==1) {
            if (ingredients.contains(ingredient)) {
                int index = ingredients.indexOf(ingredient);
                int correspondingValue = quantity.get(index);
                quantity.set(index, correspondingValue += 3);
                System.out.println("Buy Done Successfully !  ");
            }
        }
        else if(id==0) {
            int index = ingredients.indexOf(ingredient);
            int correspondingValue = quantity.get(index);
            System.out.println("Be Careful ! The quantity of " + ingredient + " is " + correspondingValue);
        }
    }

    public boolean is_empty_storage(String ingredient){
        int index = ingredients.indexOf(ingredient);
        int correspondingValue = quantity.get(index);

        if(correspondingValue==0) {
            return true;
        }
        return false;
    }

    public void Alert_quantity(String name,Integer quantity){
        System.out.println("Manager Alert : The Storages has Low -> " +name + " The quantity is Very Low : "+ quantity);
        System.out.println("Try To Contact with Any Supplier immedietly !");
    }
    public void Almost_End(String name,Integer quantity){
        System.out.println("Manager Alert :This is Last Pease of -> " +name);
        System.out.println("Try To Contact with Any Supplier immedietly !");
    }
    public void Empty_storage(String name,Integer quantity){
        System.out.println("Manager Alert :We Dont Have -> " +name);
        System.out.println("Try To Contact with Any Supplier immedietly !");
    }

}

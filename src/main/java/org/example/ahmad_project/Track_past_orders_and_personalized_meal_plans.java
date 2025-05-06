package org.example.ahmad_project;

import java.util.ArrayList;

public class Track_past_orders_and_personalized_meal_plans {
    ArrayList<String> past_orders;
    ArrayList<String> personalized_meals;

    public Track_past_orders_and_personalized_meal_plans(){
        past_orders = new ArrayList<>();
        personalized_meals = new ArrayList<>();

    }

    public void addPastOrder(String order){
        if(order!=null||(!past_orders.contains(order))) {
            past_orders.add(order);
        }
    }
    public ArrayList <String> getPastOrder(){
        if(past_orders.isEmpty()) {
            return new ArrayList<>();
        }
            return past_orders;
    }



    public boolean addPersonalizedMealPlan(String meal){
        if (meal==null||meal.isEmpty()) {
            return false;
        }
        if(personalized_meals.contains(meal)) {
            return false;
        }
        else {
            personalized_meals.add(meal);
            return true;
        }
    }


}


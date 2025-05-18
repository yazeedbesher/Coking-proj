package com.example.cooking_proj;

import java.util.ArrayList;
import java.util.List;

public class Track_past_orders_and_personalized_meal_plans {
    List<Order> past_orders;
    ArrayList<String> personalized_meals;


    public Track_past_orders_and_personalized_meal_plans(){
        past_orders = new ArrayList<>();
        personalized_meals = new ArrayList<>();

    }

    public boolean addPastOrder(Order order){
        if (order==null){return false;}

        if(!past_orders.contains(order)) {
            past_orders.add(order);

        }
        return true;
    }

    public List<Order> getPastOrders(){
        if(past_orders.isEmpty()) {
            return null;
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


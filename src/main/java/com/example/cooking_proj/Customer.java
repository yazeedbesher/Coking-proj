package com.example.cooking_proj;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    int customerID;
    String customerName;
    String customerAddress;
    String customerPhone;
    ArrayList<Order> orders;
    List<String> preference;
    List<String> Allergies;
    Create_Custome_Meal_2 custome_Meal;
    dietary_preferences_and_allergies dietary_preferences_and_allergies;

    public Customer(int customerID, String customerName, String customerAddress, String customerPhone) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        orders = new ArrayList<>();
        preference = new ArrayList<>();
        Allergies = new ArrayList<>();
        dietary_preferences_and_allergies = new dietary_preferences_and_allergies();
        custome_Meal= new Create_Custome_Meal_2();

    }

    public void addOrder(Order order) {
        if(order==null){
            JOptionPane.showMessageDialog(null,"Please enter a valid order");
            return;
        }
        orders.add(order);
    }


    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void create_order() {

        List<String> preference= dietary_preferences_and_allergies.addPreference();
        List<String> Allergies= dietary_preferences_and_allergies.addAllergies();

         custome_Meal = new Create_Custome_Meal_2();
         custome_Meal.create_meal(preference,Allergies);
    }

}

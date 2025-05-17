package com.example.cooking_proj;

import javax.swing.*;
import java.util.*;

public class Customer extends Person{
    int customerID;
    String customerName;
    String customerAddress;
    String customerPhone;
    ArrayList<Order> orders;
    List<String> preference;
    List<String> Allergies;
    Create_Custome_Meal_2 custome_Meal;
    dietary_preferences_and_allergies dietary_preferences_and_allergies;
    Order order;
    List<List> create_mealMap;

    public Customer(int customerID, String customerName, String customerAddress, String customerPhone) {
        super(customerID,customerName);
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        orders = new ArrayList<>();
        preference = new ArrayList<>();
        Allergies = new ArrayList<>();
        dietary_preferences_and_allergies = new dietary_preferences_and_allergies();
        custome_Meal= new Create_Custome_Meal_2();
        create_mealMap = new ArrayList<>();

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

    public void make_order() {
        System.out.println("Choose / 1-Show Order History 2-Custome My Order 3-Choose Meal");
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());
        if(id==1){}
        if(id==2){
            List<String> preference= dietary_preferences_and_allergies.addPreference();
            List<String> Allergies= dietary_preferences_and_allergies.addAllergies();

            custome_Meal = new Create_Custome_Meal_2();
            create_mealMap = custome_Meal.create_meal(preference,Allergies);

            preference = create_mealMap.get(0);
            Allergies = create_mealMap.get(1);

            System.out.println("Your Preference" +preference);
            System.out.println("Your Allergies" +Allergies);



        }
        else if(id==3){}

}
public List<String> getPreference() {
        return preference;
}
public List<String> getAllergies() {
        return Allergies;
}

}

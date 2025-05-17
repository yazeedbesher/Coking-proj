package com.example.cooking_proj;

import javax.swing.*;
import java.util.*;

public class Customer extends Person{
    int customerID;
    String customerName;
    String customerAddress;
    String customerPhone;
    List<String> preference;
    List<String> Allergies;
    Create_Custome_Meal_2 custome_Meal;
    dietary_preferences_and_allergies dietary_preferences_and_allergies;
    Order order;
    List<Order> orders;
    List<List> create_mealMap;
    List<String>Meals;
    Manager manager;
    Chef chef;
    List<String>AvailableMeals;

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
        Meals = new ArrayList<>();
        AvailableMeals= new ArrayList<>();

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

    public List<Order> getOrders() {
        return orders;
    }

    public void make_order(List<Chef> Chefs,Manager manager) {
        System.out.println("Choose /: 1-Choose Meal 2-Custome My Order 3-My History");
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());

        if(id==1){
            Meals=custome_Meal.GetMeals();
            int i=1;
            System.out.println("Choose Your Meal");
            for (String item : Meals) {
                System.out.println(i+"- "+ item);
                i++;
            }
            int meal = Integer.parseInt(scanner.nextLine());
            String mealName = Meals.get(meal-1);

            manager.assign_Task(Chefs,mealName);
            System.out.println("Your Meal Will Be "+ mealName);

            // Ahmad -> here define the Order object and add it to the list here

        }

        if(id==2){
            List<String> preference= dietary_preferences_and_allergies.addPreference();
            List<String> Allergies= dietary_preferences_and_allergies.addAllergies();

            custome_Meal = new Create_Custome_Meal_2();
            create_mealMap = custome_Meal.create_meal(preference,Allergies);

            AvailableMeals = manager.assign_custome_task(Chefs,create_mealMap);
            System.out.println("Your Available Meals :" +AvailableMeals + "\n"+"Choose What You Want !");
            int j=1;
            for (String item : AvailableMeals) {
                System.out.println(j + "- " + item);
                j++;
            }
            int meal = Integer.parseInt(scanner.nextLine());
            String mealName = AvailableMeals.get(meal-1);
            System.out.println("Your Meal Will Be " + mealName + " Enjoy :)");

            // Ahmad -> here define the Order object and add it to the list here

        }
        if(id==3){
             // Ahmad : here depend on the List<Order> we will print the orders then choose one of them to make the chef create again
            if(orders.isEmpty()){
                System.out.println("Sorry Your History Is Empty !");
            }
        }

}
public List<String> getPreference() {
        return preference;
}
public List<String> getAllergies() {
        return Allergies;
}
public void AddOrder(Order order) {
        orders.add(order);
}

}

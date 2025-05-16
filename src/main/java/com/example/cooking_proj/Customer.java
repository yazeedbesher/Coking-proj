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
    List<String> selectedIngredients;
    Create_Custome_Meal_2 custome_Meal_2;
    Signin signin;

    public Customer(int customerID, String customerName, String customerAddress, String customerPhone) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        orders = new ArrayList<>();

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
        List<String> selectedIngredients = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many Ingredients would you like to enter? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.print("Enter Ingredients " + (i + 1) + ": ");
            String input = scanner.nextLine();
            selectedIngredients.add(input);
        }
        scanner.close();

        Create_Custome_Meal_2 custome_Meal = new Create_Custome_Meal_2(selectedIngredients);
        custome_Meal.create_meal();
    }

}

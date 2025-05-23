package com.example.cooking_proj;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    int orderID;
    int customerID;
    String customerName;
    String chefName;
    public String mealName;
    LocalDateTime orderDate;
    LocalDateTime pickUpTime;

    public Order(int orderID, int customerID, String customerName, String chefName, String mealName, LocalDateTime pickUpTime) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.chefName = chefName;
        this.mealName = mealName;
        this.orderDate = LocalDateTime.now();
        this.pickUpTime = pickUpTime;
    }



    public int getOrderID() {
        return orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getChefName() {
        return chefName;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public LocalDateTime getPickUpTime() {
        return pickUpTime;
    }

    public String getMealName() {
        return mealName;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String orderDateString = orderDate.format(formatter);
        String pickUpTimeString = pickUpTime.format(formatter);

        return "Order ID: " + orderID +
                ", Customer ID: " + customerID +
                ", Customer Name: " + customerName +
                ", Chef Name: " + chefName +
                ", Meal Name: " + mealName +
                ", Order Date: " + orderDateString +
                ", Pick Up Time: " + pickUpTimeString;
    }
}
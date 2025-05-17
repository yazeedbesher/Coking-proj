package com.example.cooking_proj;

import java.time.LocalDateTime;

public class Order {
    int orderID;
    int customerID;
    String customerName;
    String chefName;
    LocalDateTime orderDate;
    String orderName;
    String orderDescription;
    LocalDateTime PickUpTime;

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

    public String getOrderName() {
        return orderName;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public LocalDateTime getPickUpTime() {
        return PickUpTime;
    }

    public Order(int orderID, int customerID, String customerName, String chefName,
                 LocalDateTime orderDate, String orderName, String orderDescription, LocalDateTime pickUpTime) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.chefName = chefName;
        this.orderDate = orderDate;
        this.orderName = orderName;
        this.orderDescription = orderDescription;
        this.PickUpTime = pickUpTime;
    }

    @Override
    public String toString() {
        return "orderID: " + orderID +
                ", OrderDate: " + orderDate +
                ", OrderName: " + orderName +
                ", OrderDescription: " + orderDescription;
    }
}

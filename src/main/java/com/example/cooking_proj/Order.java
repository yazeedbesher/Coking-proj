package com.example.cooking_proj;

import java.time.LocalDateTime;

public class Order {
    int orderID;
    int customerID;
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

    public Order(int orderID, int customerID, LocalDateTime orderDate, String orderName, String orderDescription, LocalDateTime PickUpTime) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.orderName = orderName;
        this.orderDescription = orderDescription;
        this.PickUpTime = PickUpTime;
    }


}

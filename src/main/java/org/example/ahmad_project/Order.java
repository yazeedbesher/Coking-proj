package org.example.ahmad_project;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

public class Order {
    int orderID;
    int customerID;
    LocalDateTime orderDate;
    String orderName;
    String orderDescription;

    public Order(int orderID, int customerID, LocalDateTime orderDate, String orderName, String orderDescription) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.orderName = orderName;
        this.orderDescription = orderDescription;
    }


}

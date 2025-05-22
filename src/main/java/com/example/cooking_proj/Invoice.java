package com.example.cooking_proj;

import java.time.format.DateTimeFormatter;

public class Invoice {
String invoice;
    String Line;
public Invoice() {
    invoice="";
    Line = "========================================\n";
}
public void generateInvoice(Order order) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    String orderDateString = order.getOrderDate().format(formatter);
    String pickUpTimeString = order.getPickUpTime().format(formatter);
    invoice += Line;
    invoice += "              Order Invoice             \n";
    invoice += Line;
    invoice += "Order ID         : " + order.getOrderID() + "\n";
    invoice += "Order Date       : " + orderDateString + "\n";
    invoice += "Pick-up Time     : " + pickUpTimeString + "\n";
    invoice += Line;
    invoice += "Customer Information\n";
    invoice += "Customer ID      : " + order.customerID + "\n";
    invoice += "Customer Name    : " + order.customerName + "\n";
    invoice += Line;
    invoice += "Order Details\n";
    invoice += "Meal Name        : " + order.mealName + "\n";
    invoice += "Chef Name        : " + order.chefName + "\n";
    invoice += "Quantity         : " + "1" + "\n";
    invoice += Line;
    invoice += "       Thank you for your order!        \n";
    invoice += Line;

    System.out.println();
    System.out.println();
    System.out.println(invoice);
    System.out.println();
    System.out.println();

}

}

package com.example.cooking_proj;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Invoice {
    String invoice;
    public Invoice() {
        invoice = "";
    }

    public void generateInvoice(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String orderDateString = order.getOrderDate().format(formatter);
        String pickUpTimeString = order.getPickUpTime().format(formatter);
        invoice += "========================================\n";
        invoice += "              Order Invoice             \n";
        invoice += "========================================\n";
        invoice += "Order ID         : " + order.getOrderID() + "\n";
        invoice += "Order Date       : " + orderDateString + "\n";
        invoice += "Pick-up Time     : " + pickUpTimeString + "\n";
        invoice += "----------------------------------------\n";
        invoice += "Customer Information\n";
        invoice += "Customer ID      : " + order.customerID + "\n";
        invoice += "Customer Name    : " + order.customerName + "\n";
        invoice += "----------------------------------------\n";
        invoice += "Order Details\n";
        invoice += "Meal Name        : " + order.mealName + "\n";
        invoice += "Chef Name        : " + order.chefName + "\n";
        invoice += "Quantity         : " + "1" + "\n";
        invoice += "========================================\n";
        invoice += "       Thank you for your order!        \n";
        invoice += "========================================\n";

        System.out.println();
        System.out.println();
        System.out.println(invoice);
        System.out.println();
        System.out.println();
    }

    public String getInvoice() {
        return invoice;
    }
}
package com.example.cooking_proj;

import javax.swing.*;
import java.util.ArrayList;

public class Customer {
    int customerID;
    String customerName;
    String customerAddress;
    String customerPhone;
    ArrayList<Order> orders;



    public Customer(int customerID, String customerName, String customerAddress, String customerPhone) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        orders =new ArrayList<Order>();

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
}

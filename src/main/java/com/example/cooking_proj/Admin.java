package com.example.cooking_proj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends Person{
    private String name;
    private int ID;
    private String Address;
    private String phoneNumber;
    Scanner scanner=new Scanner(System.in);



    public Admin(int customerID, String customerName, String customerAddress, String customerPhone)
    {
        super(customerID,customerName);
        this.name = customerName;
        this.Address = customerAddress;
        this.phoneNumber = customerPhone;
        this.ID = customerID;

    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getPassword()
    {
        return Address;
    }
    public void setPassword(String Address)
    {
        this.Address = Address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString()
    {
        return name;
    }


    public void manegeCustomerOrderHistory(List<Customer> customers){



            System.out.println("Please enter Customer ID");
            int customerId = Integer.parseInt(scanner.nextLine());
            for (Customer customer : customers) {
                if (customer.getCustomerID() == customerId) {
                    System.out.println("What would you like to do?");
                    System.out.println("1. Show Order History 2. Add Orders to Order History");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1: {
                            displayCustomerOrderHistory(customer);
                            break;
                        }
                        case 2: {

                            break;
                        }
                    }
                }
            }
    }
    public static void displayCustomerOrderHistory(Customer customer){
        List<Order> past_orders;
        past_orders=customer.getCustomerPastOrders();
        for (Order order : past_orders) {
            System.out.println("-"+order);
        }
    }
    public void createFinanceReport(){

    }



}
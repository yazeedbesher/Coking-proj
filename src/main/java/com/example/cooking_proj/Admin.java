package com.example.cooking_proj;

import io.cucumber.java.bs.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends Person{
    boolean ifCustomerFound = false;
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
             while(true){
                int customerId = Integer.parseInt(scanner.nextLine());

                for (Customer customer : customers) {
                    if (customer.getCustomerID() == customerId) {
                        ifCustomerFound = true;

                            System.out.println("What would you like to do?");
                            System.out.println("1. Show Order History 2. Add Order to Orders History 0. Exit ");
                            int choice = Integer.parseInt(scanner.nextLine());

                            if (choice == 0) {
                                return;
                            }

                            else if (choice == 1) {
                                displayCustomerOrderHistory(customer);
                                System.out.println("What would you like to do?");
                                System.out.println("1. Show Order History for another Customer 0. Exit");
                                int c = Integer.parseInt(scanner.nextLine());
                                if(c == 0){return;}
                                else if (c == 1){manegeCustomerOrderHistory(customers);}
                            }

                            else if (choice == 2) {
                                break;

                            }
                    }
                }

                if (!ifCustomerFound) {
                    System.out.println("Invalid Customer ID /0- Exit  1-Try Again ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 0) {return;}
                    else if (choice == 1) {
                        manegeCustomerOrderHistory(customers);
                    }
                }
                break;
             }
    }
    public static void displayCustomerOrderHistory(Customer customer){

        if(customer.getCustomerPastOrders()!=null){
            int i=1;
            for (Order order : customer.getCustomerPastOrders()) {
            System.out.println(i+"- "+order.toString());
        }
        }else {
            System.out.println("Order History is empty\n");
        }

    }
    public void createFinanceReport(List<Customer> customers, List<Chef> chefs){
        GenerateInvoicesAndTrackFinancialReports FinanceReport=new GenerateInvoicesAndTrackFinancialReports();
        FinanceReport.generateTrackFinancialReport(customers, chefs);
    }

}
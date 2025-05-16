package com.example.cooking_proj;

import java.util.List;
import java.util.Scanner;

public class Signin {

    public static Customer login(List<Customer> customerList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Sign in:");
        System.out.print("Enter your ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Customer customer : customerList) {
            if (customer.getCustomerID() == id) {
                System.out.println("Welcome back, " + customer.getCustomerName() + "!");
                return customer;
            }
        }

        System.out.println("Customer not found.");
        return null;
    }
}

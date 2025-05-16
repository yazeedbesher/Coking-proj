package com.example.cooking_proj;

import java.util.List;
import java.util.Scanner;

public class Signup {
    public static Customer registerCustomer(List<Customer> customerList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You're a new customer. Please sign up:");

        System.out.print("Enter your ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        System.out.print("Enter your phone: ");
        String phone = scanner.nextLine();

        Customer newCustomer = new Customer(id, name, address, phone);
        customerList.add(newCustomer);
        System.out.println("Sign-up successful. Welcome, " + name + "!");

        return newCustomer;
    }
}

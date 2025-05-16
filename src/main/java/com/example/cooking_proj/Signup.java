package com.example.cooking_proj;

import io.cucumber.java.ro.Si;

import java.util.Scanner;

public class Signup {
Signin signin;

    public Signup() {
        signin = new Signin();
    }
    public void adduser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID :");
        int ID = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter User Name :");
        String input = scanner.nextLine();
        System.out.println("Enter Address :");
        String Address = scanner.nextLine();
        System.out.println("Enter customerPhone:");
        String Phone = scanner.nextLine();
        Customer customer = new Customer(ID, input, Address, Phone);

        signin.customers.add(customer);
    }


}

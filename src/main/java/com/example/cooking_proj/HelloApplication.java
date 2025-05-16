package com.example.cooking_proj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication {

    public static void main(String[] args) {

        List<Customer> registeredCustomers = new ArrayList<>();

        registeredCustomers.add(new Customer(1222, "Ahmad", "Nablus", "0599111373"));
        registeredCustomers.add(new Customer(1223, "Abd", "Jenin", "0595639831"));
        registeredCustomers.add(new Customer(1224, "Ali", "Ramallah", "0597500172"));
        registeredCustomers.add(new Customer(1225, "Mohammed", "Nablus", "0592729162"));

        Customer currentCustomer = Signin.login(registeredCustomers);

        if (currentCustomer == null) {
            currentCustomer = Signup.registerCustomer(registeredCustomers);
        }


        System.out.println("Logged in as: " + currentCustomer.getCustomerName());

    }

}
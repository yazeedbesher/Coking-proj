package com.example.cooking_proj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HelloApplication {


    public static void main(String[] args) {

            List<Customer> registeredCustomers = new ArrayList<>();
            List<Chef> registeredChefs = new ArrayList<>();
            List<Admin> registeredAdmins = new ArrayList<>();
            List<Manager> registeredManagers = new ArrayList<>();
            StockSystem stockSystem = new StockSystem();
            Supplier supplier = new Supplier();

            Admin admin = new Admin(222, "Saad", "Jenin", "0595638731");
            registeredAdmins.add(admin);

             Manager manager = new Manager("Khaled", 5001, "Ramallah", "0599111373");
             registeredManagers.add(manager);

            registeredChefs.add(new Chef(2222, "Ali", "0595111111", 2.5, 0.0));
            registeredChefs.add(new Chef(2223, "Bob", "0595111112", 1.5, 0.0));
            registeredChefs.add(new Chef(2224, "John", "0595111113", 3.5, 0.0));

            registeredCustomers.add(new Customer(1222, "Ahmad", "Nablus", "0599111373"));
            registeredCustomers.add(new Customer(1223, "Abd", "Jenin", "0595639831"));
            registeredCustomers.add(new Customer(1224, "Ali", "Ramallah", "0597500172"));
            registeredCustomers.add(new Customer(1225, "Mohammed", "Nablus", "0592729162"));

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Welcome ! you want to Sign in as ? ");
                System.out.println("1-Admin 2-Manager 3-Chef 4-Customer OR 0-Exit");
                int id = Integer.parseInt(scanner.nextLine());

                if (id == 0) {
                    System.out.println("Thank you for using our application :)");
                    break;
                }

                else if (id == 1) {
                    Admin currentAdmin = Signin.login(registeredAdmins);
                    if (currentAdmin != null) {

                        while (true) {
                            System.out.println("What do you want to do ");
                            System.out.println("1-Customer Order History 2-Creat Report 0-Exit");
                            int choice = Integer.parseInt(scanner.nextLine());
                            if (choice == 0) {
                                break;
                            } else if (choice == 1) {
                                admin.manegeCustomerOrderHistory(registeredCustomers,registeredChefs);
                            } else if (choice == 2) {

                                admin.createFinanceReport(registeredCustomers, registeredChefs);

                            }

                        }
                    }
                }

                else if (id == 2) {
                    Manager currentManager = Signin.login(registeredManagers);
                    if (currentManager != null) {
                        while (true) {
                            System.out.println("What do you want to do ");
                            System.out.println("1-Stock quantity 2-Buy From Supplier 0-Exit");
                            int choice = Integer.parseInt(scanner.nextLine());
                            if (choice == 0) {
                                break;
                            } else if (choice == 1) {
                                Map<List<String>, List<Integer>> stock = stockSystem.getStock();
                                for (Map.Entry<List<String>, List<Integer>> entry : stock.entrySet()) {
                                    List<String> keyList = entry.getKey();
                                    List<Integer> valueList = entry.getValue();

                                    System.out.println("We Have in Stock : ");
                                    for(int i = 0; i < valueList.size(); i++) {
                                        System.out.println(keyList.get(i) + " : " + valueList.get(i));
                                    }
                                }
                                System.out.println("Do you Want to Do Somthing else? 0-No 1-Yes");
                                int choise = Integer.parseInt(scanner.nextLine());
                                if(choise==0){
                                    break;
                                }
                            } else if (choice == 2) {
                                Map<List<String>, List<Integer>> stock = supplier.getSupply();
                                for (Map.Entry<List<String>, List<Integer>> entry : stock.entrySet()) {
                                    List<String> keyList = entry.getKey();
                                    List<Integer> valueList = entry.getValue();

                                    System.out.println("We Have in Market : ");
                                    for(int i = 0; i < valueList.size(); i++) {
                                        System.out.println((i+1)+"- "+keyList.get(i) + " : " + valueList.get(i)+" $");
                                    }
                                    System.out.println("Choose What You want to Buy :");
                                    int buy = Integer.parseInt(scanner.nextLine());
                                    String ingredent_BUY = keyList.get(buy-1);
                                    System.out.println("how Much do you want to Buy ?");
                                    int quantity_buy = Integer.parseInt(scanner.nextLine());
                                    stockSystem.increase_quantity(quantity_buy,ingredent_BUY);
                                    System.out.println("This will Cost :" +(valueList.get(buy-1) * quantity_buy)+ " $");
                                }
                                System.out.println("Do you Want to Do Somthing else? 0-No 1-Yes");
                                int choise = Integer.parseInt(scanner.nextLine());
                                if(choise==0){
                                    break;
                                }
                            }

                        }
                    }
                }

                else if (id == 3) {
                        Chef currentChef = Signin.login(registeredChefs);
                        if (currentChef != null) {

                                currentChef.showCustomerOrderHistory(registeredCustomers);

                        }
                }

                else if (id == 4) {

                        Customer currentCustomer = Signin.login(registeredCustomers);

                        if (currentCustomer == null) {
                            currentCustomer = Signup.signup(registeredCustomers);
                        }

                        System.out.println("Logged in as: " + currentCustomer.getCustomerName());

                        currentCustomer.make_order(registeredChefs, manager);

                }

            }//Ahmad
    }
}

package com.example.cooking_proj;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Chef extends Person {
    private String name;
    private int ID;
    private String phoneNumber;
    private Double expretise;
    private Double workload;
    boolean chefsAvailable = true;
    String notification = "You Have Recieced a New Task To do";
    List<String> Custome_Meals;
    List<String> Meals;
    boolean ifCustomerFound;
    List<String> MealsAvailable;
    Scanner scanner = new Scanner(System.in);

    public Chef(int ID, String name, String phoneNumber, Double expretise, Double workload) {
        super(ID, name);
        this.name = name;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.expretise = expretise;
        this.workload = workload;
        Custome_Meals = new ArrayList<>();
        Meals = new ArrayList<>();
        MealsAvailable = new ArrayList<>();


        Meals.add("Kabsa");
        Meals.add("Lazania");
        Meals.add("Fish with Tomato");
        Meals.add("Fried Chicken");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void Create_Meal(String meal) {
        workload++;


    }

    public List<String> Create_Custome_Meal(List<List> ingredients) {
        workload++;
        List<String> Preference = ingredients.get(0);
        List<String> Allegreis = ingredients.get(1);

        System.out.println("Chef : This is THe Customer Prefrence is : ");
        int w = 1;
        for (String d : Preference) {
            System.out.println(w + "- " + d);
            w++;
        }
        MealsAvailable.clear();
        for (String c : Preference) {
            Preference.remove(c);
            if (Preference.isEmpty()) {
                if (c.equals("Chicken")) {
                    MealsAvailable.add("Fried Chicken");
                    break;
                }
                if (c.equals("Rice")) {
                    MealsAvailable.add("Cooked Rice");
                    break;
                }
            }
            for (String a : Preference) {
                if (a.equals("Chicken")) {
                    MealsAvailable.add("Fried Chicken");
                    if (c.equals("Rice")) {
                        MealsAvailable.add("Kabsa"); // enter rice then chicken
                    }
                    if (c.equals("pasta")) {
                        MealsAvailable.add("Lazania");
                    }
                }
                if (a.equals("Fish")) {
                    if (c.equals("Tomato")) {
                        MealsAvailable.add("Fish with Tomato");
                    }
                }
            }
        }

        return MealsAvailable;
    }

    public void startRemainder(Order order) {
        NotificationsAndAlerts chef_Notification = new NotificationsAndAlerts();
        chef_Notification.UpcomingOrdersReminder(2, order, 2);
    }

    public Double getExpretise() {
        return expretise;
    }

    public Double getWorkload() {
        return workload;
    }


    public void showCustomerOrderHistory(List<Customer> customers){

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
                        System.out.println("1. Show Order History for another Customer  0. Exit ");
                        int c = Integer.parseInt(scanner.nextLine());
                        if(c == 0){return;}
                        else if (c == 1){showCustomerOrderHistory(customers);}

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
                    showCustomerOrderHistory(customers);
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
}

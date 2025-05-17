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
        List<Chef> registeredChefs = new ArrayList<>();
        List<Admin> registeredAdmins = new ArrayList<>();
        List<Manager> registeredManagers = new ArrayList<>();

        Manager manager = new Manager("Khaled",5001,"Ramallah","0599111373");
        registeredManagers.add(manager);

        Admin admin = new Admin(9222,"Saad","Jenin","0595638731");
        registeredAdmins.add(admin);

        registeredChefs.add(new Chef(2222,"Ali","0595111111",2.5,2.2));
        registeredChefs.add(new Chef(2223,"Bob","0595111112",1.5,1.82));
        registeredChefs.add(new Chef(2224,"John","0595111113",3.5,3.2));

        registeredCustomers.add(new Customer(1222, "Ahmad", "Nablus", "0599111373"));
        registeredCustomers.add(new Customer(1223, "Abd", "Jenin", "0595639831"));
        registeredCustomers.add(new Customer(1224, "Ali", "Ramallah", "0597500172"));
        registeredCustomers.add(new Customer(1225, "Mohammed", "Nablus", "0592729162"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome ! you want to Sign in as ? ");
        System.out.println("1-Admin 2-Manager 3-Chef 4-Customer");
        int id = Integer.parseInt(scanner.nextLine());

        if (id == 1) {
            Admin admin1= Signin.login(registeredAdmins);

        }
        if (id == 2) {
             Manager manager1= Signin.login(registeredManagers);
        }
        if (id == 3) {

            Chef chef = Signin.login(registeredChefs);

        }
        if (id == 4) {
//

            Customer currentCustomer = Signin.login(registeredCustomers);

            if (currentCustomer == null) {
                currentCustomer = Signup.signup(registeredCustomers);
            }

            System.out.println("Logged in as: " + currentCustomer.getCustomerName());

            while (true){
                currentCustomer.make_order();
                System.out.println("Do You Want To Create Another Meal ? ");
                System.out.println("0-NO 1-Yes");
                String choice = scanner.nextLine();
                if(choice.equals("1")){currentCustomer.make_order();}
                else if(choice.equals("0")){break;}
            }

        }
    }
}
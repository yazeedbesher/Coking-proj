package com.example.cooking_proj;

import java.util.Map;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

import static com.example.cooking_proj.Chef.displayCustomerOrderHistory;

//Ahmad
public class HelloApplication {
    static int ordersTDs=200;
    static Scanner scanner = new Scanner(System.in);
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


            while (true) {
                System.out.println("Welcome ! you want to Sign in as ? ");
                System.out.println("1-Admin 2-Manager 3-Chef 4-Customer OR 0-Exit");
                int id = Integer.parseInt(scanner.nextLine());

                if (id == 0) {
                    System.out.println("Thank you for using our application :)");
                    break;
                }

                else if (id == 1) {
                    AdminWork(registeredAdmins,registeredCustomers,registeredChefs);
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
                    chefWork(registeredChefs,registeredCustomers);
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
    static void AdminWork(List<Admin> admins, List<Customer> customers, List<Chef> chefs) {
        Scanner scanner = new Scanner(System.in);
        boolean ifCustomerFound = false;
        Boolean ifChefFound=false;
        Admin currentAdmin = Signin.login(admins);
        if (currentAdmin != null) {

            while (true) {
                System.out.println("What do you want to do ");
                System.out.println("1-Customer Order History 2-Creat Report 0-Exit");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    break;
                } else if (choice == 1) {
                    System.out.println("Please enter Customer ID");
                    int customerId = Integer.parseInt(scanner.nextLine());

                    while(true){
                        for (Customer customer : customers) {
                            if (customer.getCustomerID() == customerId) {
                                ifCustomerFound = true;
                                while (true) {
                                    System.out.println("What would you like to do?");
                                    System.out.println("1. Show Order History 2. Add Order to Orders History 0. Exit ");
                                    int choice1 = Integer.parseInt(scanner.nextLine());

                                    if (choice1 == 0) {
                                        break;
                                    } else if (choice1 == 1) {
                                        Admin.displayCustomerOrderHistory(customer);
                                    } else if (choice1 == 2) {
                                        //currentAdmin.addOrderToOrderHistory(customer, chefs);
                                        while (true) {
                                            System.out.println("Please Enter Chef Name: ");
                                            String chefName = scanner.nextLine();
                                            for (Chef chef : chefs) {
                                                if (chef.getName().equals(chefName)) {
                                                    System.out.println("Please Enter Meal Name: ");
                                                    String mealName = scanner.nextLine();
                                                    Order newOrder = new Order(HelloApplication.ordersTDs++, customerId, customer.getCustomerName(), chef.getName(), mealName);
                                                    customer.pastOrders.addPastOrder(newOrder);
                                                    ifChefFound = true;
                                                }
                                            }
                                            if (!ifChefFound) {
                                                System.out.println("Invalid Chef Name");
                                                continue;
                                            }
                                            break;

                                        }
                                    }
                                }
                            }
                        }
                        if (!ifCustomerFound) {
                            System.out.println("Invalid Customer ID ");
                            break;
                        }
                        break;
                    }
                } else if (choice == 2) {

                    currentAdmin.createFinanceReport(customers, chefs);

                }

            }
        }
    }


    static void chefWork(List<Chef> chefs, List<Customer> customers) {
        boolean ifCustomerFound=false;
        Chef currentChef = Signin.login(chefs);
        if (currentChef != null) {
            System.out.println("Please enter Customer ID");
            while(true){
                int customerId = Integer.parseInt(scanner.nextLine());

                for (Customer customer : customers) {
                    if (customer.getCustomerID() == customerId) {
                        ifCustomerFound = true;

                        System.out.println("1. Show Order History 0. Exit ");
                        int choice = Integer.parseInt(scanner.nextLine());

                        if (choice == 0) {
                            return;
                        }

                        else if (choice == 1) {
                            displayCustomerOrderHistory(customer);
                            System.out.println("What would you like to do?");
                            System.out.println("1.Add These Meals in My kitchen Recommendation 0. Exit ");
                            int c = Integer.parseInt(scanner.nextLine());
                            if(c == 0){break;}
                            if(c == 1) {
                                //Ahmad
                                currentChef.showCustomerOrderHistory(customer);
                            }
                            }
                        }
                    }

                    if (!ifCustomerFound) {
                        System.out.println("Invalid Customer ID");
                    }
                    break;
                }

            }

        }
    }



package com.example.cooking_proj;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Customer extends Person{

    int customerID;
    String customerName;
    String customerAddress;
    String customerPhone;
    List<String> preference;
    List<String> Allergies;
    Create_Custome_Meal_2 custome_Meal;
    dietary_preferences_and_allergies dietary_preferences_and_allergies;
    List<Order> orders;
    List<List> create_mealMap;
    List<String>Meals;
    List<String>AvailableMeals;
    NotificationsAndAlerts customer_Notification;
    Order order;
    Track_past_orders_and_personalized_meal_plans pastOrders;

    public Customer(int customerID, String customerName, String customerAddress, String customerPhone) {
        super(customerID,customerName);
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        preference = new ArrayList<>();
        Allergies = new ArrayList<>();
        dietary_preferences_and_allergies = new dietary_preferences_and_allergies();
        custome_Meal= new Create_Custome_Meal_2();
        create_mealMap = new ArrayList<>();
        orders = new ArrayList<>();

        Meals = new ArrayList<>();
        AvailableMeals= new ArrayList<>();
        pastOrders=new Track_past_orders_and_personalized_meal_plans();
        customer_Notification = new NotificationsAndAlerts();
    }


    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public List<String> getPreference() {
        return preference;
    }
    public List<String> getAllergies() {
        return Allergies;
    }

//    public void make_order(,int State) {
//
//
//
//        if (id == 1) {
//
//
//        }
//
//        if (id == 2) {
//            preference = dietary_preferences_and_allergies.addPreference();
//            Allergies = dietary_preferences_and_allergies.addAllergies();
//            custome_Meal = new Create_Custome_Meal_2();
//            create_mealMap = custome_Meal.create_meal(preference, Allergies);
//            AvailableMeals = manager.assign_custome_task(Chefs, create_mealMap);
//            System.out.println("Your Available Meals :" + AvailableMeals + "\n" + "Choose What You Want !");
//            int j = 1;
//            System.out.println("0- Nothing, Thank You!");
//            for (String item : AvailableMeals) {
//                System.out.println(j + "- " + item);
//                j++;
//            }
//            int meal = Integer.parseInt(scanner.nextLine());
//            if(meal==0){
//                break;
//            }
//            String mealName = AvailableMeals.get(meal - 1);
//            System.out.println("Chef : We assigned You a Task To Cook  " + mealName);
//            String chefName = manager.getChef_name();
//
//            order = manager.initlize_order(getCustomerID(), getCustomerName(), chefName, mealName,pickUpTime);
//
//            customer_Notification.UpcomingOrdersReminder(1, order, 1);
//            pastOrders.addPastOrder(order);
//            GenerateInvoicesAndTrackFinancialReports invoice =new GenerateInvoicesAndTrackFinancialReports();
//            invoice.generateInvoice(order);
//
//            preference.clear();
//            Allergies.clear();
//
//        }
//        if (id == 3) {
//
//            if(pastOrders.getPastOrders()==null){
//                System.out.println("Sorry Your History Is Empty !");
//            }
//            else{
//                System.out.println("Your Past Meals: \n");
//                int i=1;
//                for (Order order : pastOrders.getPastOrders()) {
//                    System.out.println(i + "- " + order.getMealName());
//                    i++;
//                }
//            }
//        }
//
//
//
//
//    }
//    public void makeOrder1(List<Chef> Chefs, Manager manager, LocalDateTime pickUpTime){
//
//        String mealName = Meals.get(meal - 1);
//        String chefName = manager.assign_Task(Chefs, mealName);
//        System.out.println("Chef : We assigned You a Task To Cook  " + mealName);
//
//        Random rand = new Random();
//        int randomInt = rand.nextInt(100);
//
//        order = manager.initlize_order(getCustomerID(), getCustomerName(), chefName, mealName,pickUpTime);
//
//        customer_Notification.UpcomingOrdersReminder(1, order, 1);
//        pastOrders.addPastOrder(order);
//        GenerateInvoicesAndTrackFinancialReports invoice =new GenerateInvoicesAndTrackFinancialReports();
//        invoice.generateInvoice(order);
//
//    }
//    public void makeOrder2(List<Chef> Chefs, Manager manager, LocalDateTime pickUpTime){
//
//
//
//    }
//    public void makeOrder3(List<Chef> Chefs, Manager manager, LocalDateTime pickUpTime){}

    public List<Order> getCustomerPastOrders () {
        return pastOrders.getPastOrders();
    }
}

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
    public List<String>Meals;
    List<String>AvailableMeals;
    NotificationsAndAlerts customer_Notification;
    Order order;
    public Track_past_orders_and_personalized_meal_plans pastOrders;

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
    public void setMeals(List<String>meals){
        Meals = meals;
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

    public void setcustomerpreference(List<String> Preference){this.preference = Preference;}
    public void seecustomerAllegries( List<String> allergies){this.Allergies = allergies;}
    public List<String> getPreference() {
        return preference;
    }
    public List<String> getAllergies() {
        return Allergies;
    }



    public void makeOrder1(List<Chef> Chefs, Manager manager, LocalDateTime pickUpTime,int meal){

        String mealName = Meals.get(meal - 1);
        System.out.println("We are here "+mealName);
        String chefName = manager.assign_Task(Chefs, mealName);
        System.out.println("Chef : We assigned You a Task To Cook  " + mealName);

        Random rand = new Random();
        int randomInt = rand.nextInt(100);

        order = manager.initlize_order(getCustomerID(), getCustomerName(), chefName, mealName,pickUpTime);

        customer_Notification.UpcomingOrdersReminder(1, order, 1);
       pastOrders.addPastOrder(order);
        GenerateInvoicesAndTrackFinancialReports invoice =new GenerateInvoicesAndTrackFinancialReports();
        invoice.generateInvoice(order);

    }

    public List<Order> getCustomerPastOrders () {
        return pastOrders.getPastOrders();
    }


}

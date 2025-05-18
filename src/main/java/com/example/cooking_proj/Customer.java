package com.example.cooking_proj;

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
    //Order order;
    //List<Order> orders;
    List<List> create_mealMap;
    List<String>Meals;
    Manager manager;
    Chef chef;
    List<String>AvailableMeals;
    NotificationsAndAlerts customer_Notification;

    Track_past_orders_and_personalized_meal_plans pastOrders;

    public Customer(int customerID, String customerName, String customerAddress, String customerPhone) {
        super(customerID,customerName);
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        //orders = new ArrayList<>();
        preference = new ArrayList<>();
        Allergies = new ArrayList<>();
        dietary_preferences_and_allergies = new dietary_preferences_and_allergies();
        custome_Meal= new Create_Custome_Meal_2();
        create_mealMap = new ArrayList<>();


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
//    public List<Order> getPastOrders() {
//        return pastOrders.getPastOrders();
//    }
    public void make_order(List<Chef> Chefs,Manager manager) {
        while (true){
        System.out.println("Choose /: 1-Choose Meal 2-Custome My Order 3-My History");
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());

        if (id == 1) {
            Meals = custome_Meal.GetMeals();
            int i = 1;
            System.out.println("Choose Your Meal");
            for (String item : Meals) {
                System.out.println(i + "- " + item);
                i++;
            }
            int meal = Integer.parseInt(scanner.nextLine());
            String mealName = Meals.get(meal - 1);
            String chefName = manager.assign_Task(Chefs, mealName);
            System.out.println("Your Meal Will Be " + mealName);

            Order order = manager.initlize_order(getCustomerID(), getCustomerName(), chefName, mealName);
            //orders.add(order);//the define of Order object
            customer_Notification.UpcomingOrdersReminder(1, order, 1);
            pastOrders.addPastOrder(order); //add it to the Past Order list
            // Ahmad -> here define the Order object and add it to the list here (DONE)

        }

        if (id == 2) {
            preference = dietary_preferences_and_allergies.addPreference();
            Allergies = dietary_preferences_and_allergies.addAllergies();

            custome_Meal = new Create_Custome_Meal_2();
            create_mealMap = custome_Meal.create_meal(preference, Allergies);

            AvailableMeals = manager.assign_custome_task(Chefs, create_mealMap);
            System.out.println("Your Available Meals :" + AvailableMeals + "\n" + "Choose What You Want !");
            int j = 1;
            for (String item : AvailableMeals) {
                System.out.println(j + "- " + item);
                j++;
            }
            int meal = Integer.parseInt(scanner.nextLine());
            String mealName = AvailableMeals.get(meal - 1);
            System.out.println("Your Meal Will Be " + mealName + " Enjoy :)");
            String chefName = manager.getChef_name();


//            manager.initlize_order(getCustomerID(),getCustomerName(),chefName,mealName);//the define of Order object
//            customer_Notification = new NotificationsAndAlerts();
//            customer_Notification.UpcomingOrdersReminder(1,manager.getOrder1(),1);
//            pastOrders.addPastOrder(manager.getOrder1()); //add it to the Past Order list
//            // Ahmad -> here define the Order object and add it to the list here (DONE)

        }
        if (id == 3) {
             //Ahmad : here depend on the List<Order> we will print the orders then choose one of them to make the chef create again
            if(pastOrders.getPastOrders()==null){
                System.out.println("Sorry Your History Is Empty !");
            }
            else{

                System.out.println("Your Past Meals: \n");
                int i=1;
                for (Order order : pastOrders.getPastOrders()) {
                    System.out.println(i + "- " + order.getMealName());
                    i++;
                }
                //Yazeed contenue the order
            }
        }
        System.out.println("Do You Want To Do Anything Else ? ");
        System.out.println("0-NO 1-Yes");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {

        } else if (choice.equals("0")) {
            System.out.println("Thank You , Welcome!");
            return;
        }


    }}
    public List<Order> getCustomerPastOrders () {
        return pastOrders.getPastOrders();
    }
}

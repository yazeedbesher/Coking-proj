package com.example.cooking_proj;

import java.util.*;

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

    List<String> MealsAvailable;
    Scanner scanner = new Scanner(System.in);
    List<Order> Addorders;

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
        Addorders = new ArrayList<>();

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
        List<String> Allergies = ingredients.get(1);
        MealsAvailable.clear();

        System.out.println("Chef : The Customer's Preferences are:");
        int w = 1;
        for (String d : Preference) {
            System.out.println(w + "- " + d);
            w++;
        }

        // تحويل التفضيلات إلى مجموعة لتسهيل الفحص بدون ترتيب
        Set<String> preferenceSet = new HashSet<>(Preference);

        // اقتراحات بناءً على التفضيلات بدون ترتيب
        if (preferenceSet.contains("Chicken")) {
            MealsAvailable.add("Fried Chicken");
        }
        if (preferenceSet.contains("Rice")) {
            MealsAvailable.add("Cooked Rice");
        }
        if (preferenceSet.contains("Rice") && preferenceSet.contains("Chicken")) {
            MealsAvailable.add("Kabsa");
        }
        if (preferenceSet.contains("pasta") && preferenceSet.contains("Chicken")) {
            MealsAvailable.add("Lazania");
        }
        if (preferenceSet.contains("Fish") && preferenceSet.contains("Tomato")) {
            MealsAvailable.add("Fish with Tomato");
        }
        if (preferenceSet.contains("Egg") && preferenceSet.contains("Cheese")) {
            MealsAvailable.add("Cheese Omelette");
        }

        // add more

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


    public void showCustomerOrderHistory(Customer customer) {


        if (customer.getCustomerPastOrders() == null) {
            System.out.println("Your Orders History is Empty , Try Again :(");
            return;
        }
        Addorders = customer.getCustomerPastOrders();
        for (Order order : Addorders) {
            if (!Meals.contains(order.mealName)) ;
            {
                Meals.add(order.mealName);
                System.out.println(order.mealName + " Added To the Kitchen");
            }
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

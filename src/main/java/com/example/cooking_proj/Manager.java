package com.example.cooking_proj;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Person {
    int ordersId=1;
    private String name;
    private int ID;// for login
    private String Address;
    private String phoneNumber;
    Chef Task_chef;
    List<String> Meals;



    public Manager(String name, int ID, String Address, String phoneNumber) {
        super(ID,name);
        this.name = name;
        this.ID = ID;
        this.Address = Address;
        this.phoneNumber = phoneNumber;
        Meals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public int getID() {
        return ID;
    }
    public String getPassword() {
        return Address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setID(int ID)
    {
        this.ID = ID;
    }
    public void setPassword(String password)
    {
        this.Address = password;
    }

    @Override
    public String toString()
    {
        return name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> assign_custome_task(List<Chef> Chefs,List<List>ingredients){
        Double Chef0  =Chefs.get(0).getExpretise()+ -1 * (Chefs.get(0).getWorkload());

        for (Chef chef : Chefs){
          Double other = chef.getExpretise() + -1 * (chef.getWorkload());
          if(Chef0>other){
              Task_chef = Chefs.get(0);
          }
          else{
              Task_chef = chef;
          }
        }

        System.out.println("Your Chef is "+Task_chef.getName());
        System.out.println("System : Chef "+Task_chef.getName()+ " You Had a New Task , Start now !");

        Meals= Task_chef.Create_Custome_Meal(ingredients);
        return Meals;
    }
    public String getChef_name() {
        return Task_chef.getName();
    }

    public String assign_Task(List<Chef> Chefs, String meal){

        Double Chef0  =Chefs.get(0).getExpretise()+ -1 * (Chefs.get(0).getWorkload());

        for (Chef chef : Chefs){
            Double other = chef.getExpretise() + -1 * (chef.getWorkload());
            if(Chef0>other){
                Task_chef = Chefs.get(0);
            }
            else{
                Task_chef = chef;
            }
        }

        System.out.println("Your Chef is "+Task_chef.getName());

        Task_chef.Create_Meal(meal);

        return Task_chef.getName();
    }



    public Order initlize_order(int customerID, String customerName, String chefName, String mealName){


        Order order = new Order(ordersId++, customerID, customerName, chefName, mealName);
        Task_chef.startRemainder(order);
        return order;

    }



}

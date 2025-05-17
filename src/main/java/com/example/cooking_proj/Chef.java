package com.example.cooking_proj;

import java.util.ArrayList;
import java.util.List;

public class Chef extends Person{
    private String name;
    private int ID;
    private String phoneNumber;
    private Double expretise;
    private Double workload;
    boolean chefsAvailable = true;
    List<Create_Custome_Meal_2> tasks = new ArrayList<>();
    String notification = "You Have Recieced a New Task To do" ;

    public Chef(int ID,String name,String phoneNumber,Double expretise,Double workload) {
        super(ID,name);
        this.name = name;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.expretise = expretise;
        this.workload = workload;
    }

    public String getName() {
        return name;
    }
    public int getID() {
        return ID;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setID(int ID)
    {
        this.ID = ID;
    }
    @Override
    public String toString()
    {
        return name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void add_task(Create_Custome_Meal_2 task){
        tasks.add(task);
        System.out.println(task);
        Create_Meal();
    }

    public List<String> Create_Meal(){
        List<String> meals = new ArrayList<>();
        return meals;
    }
}

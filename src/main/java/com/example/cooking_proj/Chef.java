package com.example.cooking_proj;

import java.util.ArrayList;
import java.util.List;

public class Chef {
    private String name;
    private int ID;
    private String password;
    private String phoneNumber;
    private int expretise;
    private int workload;
    boolean chefsAvailable = true;
    List<Create_Custome_Meal_2> tasks = new ArrayList<>();
    String notification = "You Have Recieced a New Task To do" ;

    public Chef(String name, int ID, String password, String phoneNumber,int expretise,int workload) {
        this.name = name;
        this.ID = ID;
        this.password = password;
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
    public String getPassword() {
        return password;
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
        this.password = password;
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

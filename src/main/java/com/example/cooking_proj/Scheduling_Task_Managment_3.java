package com.example.cooking_proj;

import java.util.ArrayList;
import java.util.List;

public class Scheduling_Task_Managment_3{
    List<Chef> chefs = new ArrayList<>();
    int temp = 0 ;
    manager m;
    Create_Custome_Meal_2 meal;

    public Scheduling_Task_Managment_3() {
        this.chefs = chefs;
    }

    public void Task_Managment() {
       for(Chef chef : chefs){
           if(chef.tasks.size() <= temp){
               temp = chef.tasks.size();
           }
           m.assign_task(meal,chef);
       }
    }

}

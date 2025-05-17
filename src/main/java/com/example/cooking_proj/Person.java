package com.example.cooking_proj;

public abstract class Person {
    int customerID;
    String customerName;

    public Person(int id, String name) {
         this.customerID=id;
       this.customerName=name;
    }

    public int getUserID() {
        return customerID;
    }

    public String getUserName() {
        return customerName;
    }

}

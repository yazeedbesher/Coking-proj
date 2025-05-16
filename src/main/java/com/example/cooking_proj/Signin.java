package com.example.cooking_proj;


import java.util.*;

public class Signin {
Signup signup;
    List<Customer> customers;

    public Signin() {
        customers = new ArrayList<>();
        signup = new Signup();
        Customer cust1 = new Customer(1221, "yazeed", "jordan", "0599111373");
        Customer cust2 = new Customer(1222, "Ahmad", "jordan", "0599111373");
        Customer cust3 = new Customer(1223, "ABD", "jordan", "0599111373");
        customers.add(cust1);
        customers.add(cust2);
        customers.add(cust3);
    }
    public boolean valid_user(int id){
        for (Customer c : customers) {
            if(c.getCustomerID() == id){
                return true;
            }
            else{
                return false;
            }
        }
        return true;
    }



}
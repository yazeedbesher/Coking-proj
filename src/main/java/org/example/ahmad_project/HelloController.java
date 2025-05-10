package org.example.ahmad_project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.*;
import java.util.ArrayList;

public class HelloController {
ArrayList<Customer> customers=new ArrayList<Customer>();
    public boolean validateCustomer(int customerID) {
        for (Customer c : customers) {
            if (c.getCustomerID() == customerID) {
                return true;
            }
        }

        return false;}

    public boolean addCustomer(Customer c) {
        if (!validateCustomer(c.getCustomerID())) {
        customers.add(c);
        return true;}
        return false;
    }
    Customer customer=new Customer(1,"Ahmad","asd","123");

    boolean f=addCustomer(customer);


    @FXML
    protected void onHelloButtonClick() {

       // System.out.println("Hello World!");
        JOptionPane.showMessageDialog(null,"Ahmad Project");

       // welcomeText.setText("Welcome to JavaFX Application!");
    }



}
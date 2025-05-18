package com.example.cooking_proj;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FinanceReport {
//    int allOrdersTotal;
//    int chefOrdersCount;
//    int customerOrdersCount;
    List<Customer> customers;
    List<Chef> chefs;
    public FinanceReport() {
        customers = new ArrayList<>();
        chefs = new ArrayList<>();
    }
    public void generateFinanceReport(List<Customer> customers, List<Chef> chefs) {
        this.customers = customers;
       String report = "";
       report += "Total orders total: " + getAllOrdersCount() + "\n";
       for (Chef chef : chefs) {
           report+="Chef Name: " + chef.getName() +" Orders: "+getChefOrdersCount(chef)+"\n";
       }
       for (Customer customer : customers) {
           report+="Customer Name: "+customer.getCustomerName()+" Orders: "+getcustomerOrdersCount(customer)+"\n";
       }
       JOptionPane.showMessageDialog(null, report);



    }

//    public int getAllOrdersCount() {
//        int allOrdersCount = 0;
//        for(Customer customer : customers) {
//            for (Order order :customer.getCustomerPastOrders()){
//            allOrdersCount++;}
//        }
//        return allOrdersCount;
//    }
//
//    public int getChefOrdersCount(Chef chef) {
//        int chefOrdersCount = 0;
//            for(Customer customer : customers) {
//                for (Order order :customer.getCustomerPastOrders()){
//                    if(order.getChefName().equals(chef.getName())){
//                        chefOrdersCount++;
//                    }
//                }
//            }
//        return chefOrdersCount;
//    }
//
//    public int getcustomerOrdersCount(Customer customer) {
//        return customer.getCustomerPastOrders().size();
//    }
public int getAllOrdersCount() {
    int allOrdersCount = 0;
    for (Customer customer : customers) {
        List<Order> pastOrders = customer.getCustomerPastOrders();
        if (pastOrders != null) {
            allOrdersCount += pastOrders.size();
        }
    }
    return allOrdersCount;
}
    public int getChefOrdersCount(Chef chef) {
        int chefOrdersCount = 0;
        for (Customer customer : customers) {
            List<Order> pastOrders = customer.getCustomerPastOrders();
            if (pastOrders != null) {
                for (Order order : pastOrders) {
                    if (order.getChefName().equals(chef.getName())) {
                        chefOrdersCount++;
                    }
                }
            }
        }
        return chefOrdersCount;
    }

    public int getcustomerOrdersCount(Customer customer) {
        List<Order> pastOrders = customer.getCustomerPastOrders();
        return pastOrders == null ? 0 : pastOrders.size();
    }


}

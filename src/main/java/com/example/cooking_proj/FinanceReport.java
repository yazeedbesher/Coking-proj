package com.example.cooking_proj;

import java.util.ArrayList;
import java.util.List;

public class FinanceReport {
    List<Customer> customers;
    List<Chef> chefs;
    String report;

    public FinanceReport() {
        customers = new ArrayList<>();
        chefs = new ArrayList<>();
        report = "";
    }

    public void generateFinanceReport(List<Customer> customers, List<Chef> chefs) {
        this.customers = customers;
        this.chefs = chefs;
        report = "";

        report += "=========== Order Summary ===========\n";
        report += "Total Orders: " + getAllOrdersCount() + "\n\n";

        report += "=========== Orders Per Chef =========\n";
        for (Chef chef : chefs) {
            report += "Chef Name: " + chef.getName() +
                    " | Orders: " + getChefOrdersCount(chef) + "\n";
        }
        report += "\n";

        report += "========= Orders Per Customer =======\n";
        for (Customer customer : customers) {
            report += "Customer Name: " + customer.getCustomerName() +
                    " | Orders: " + getcustomerOrdersCount(customer) + "\n";
        }
        report += "=====================================\n";

        System.out.println();
        System.out.println();
        System.out.println(report);
        System.out.println();
        System.out.println();
    }

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

    public String getReport() {
        return report;
    }
}
package com.example.cooking_proj;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin extends Person {

    private static final Logger LOGGER = Logger.getLogger(Admin.class.getName());

    private String name;
    private int ID;
    private String Address;
    private String phoneNumber;

    public Admin(int customerID, String customerName, String customerAddress, String customerPhone) {
        super(customerID, customerName);
        this.name = customerName;
        this.Address = customerAddress;
        this.phoneNumber = customerPhone;
        this.ID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return Address;
    }

    public void setPassword(String Address) {
        this.Address = Address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void displayCustomerOrderHistory(Customer customer) {
        if (customer.getCustomerPastOrders() != null) {
            int i = 1;
            for (Order order : customer.getCustomerPastOrders()) {
                LOGGER.log(Level.INFO, "{0}- {1}", new Object[]{i, order.toString()});
                i++;
            }
        } else {
            LOGGER.log(Level.INFO, "Order History is empty\n");
        }
    }

    public void createFinanceReport(List<Customer> customers, List<Chef> chefs) {
        GenerateInvoicesAndTrackFinancialReports financeReport = new GenerateInvoicesAndTrackFinancialReports();
        financeReport.generateTrackFinancialReport(customers, chefs);
    }
}

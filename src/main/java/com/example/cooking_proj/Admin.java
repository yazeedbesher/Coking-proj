package com.example.cooking_proj;

import java.util.List;

public class Admin extends Person{

    private String name;
    private int ID;
    private String Address;
    private String phoneNumber;

    public Admin(int customerID, String customerName, String customerAddress, String customerPhone)
    {
        super(customerID,customerName);
        this.name = customerName;
        this.Address = customerAddress;
        this.phoneNumber = customerPhone;
        this.ID = customerID;

    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getPassword()
    {
        return Address;
    }
    public void setPassword(String Address)
    {
        this.Address = Address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString()
    {
        return name;
    }


    public static void displayCustomerOrderHistory(Customer customer){

        if(customer.getCustomerPastOrders()!=null){
            int i=1;
            for (Order order : customer.getCustomerPastOrders()) {
                System.out.println(i+"- "+order.toString());
            }
        }else {
            System.out.println("Order History is empty\n");
        }

    }



    public void createFinanceReport(List<Customer> customers, List<Chef> chefs){
        GenerateInvoicesAndTrackFinancialReports FinanceReport=new GenerateInvoicesAndTrackFinancialReports();

        FinanceReport.generateTrackFinancialReport(customers, chefs);
    }

}
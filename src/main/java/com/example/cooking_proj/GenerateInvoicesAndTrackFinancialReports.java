package com.example.cooking_proj;

import java.util.ArrayList;

public class GenerateInvoicesAndTrackFinancialReports {

Invoice invoice;
FinanceReport financeReport;
boolean ErrorAtDataBase=false;
boolean ErrorAtSystem=false;

public void makeErrorAtDataBase() {
    ErrorAtDataBase=true;
}
public void makeErrorAtSystem() {
    ErrorAtSystem=true;
}

public boolean generateInvoice(int customerID, String customerName,Order order) {
    if(customerName == null || customerName == ""||order==null){
        return false;
    }
    if(ErrorAtDataBase){
        return false;
    }
    Invoice invoice = new Invoice();
    invoice.generateInvoice(customerID, customerName, order);
    return true;
}

public boolean generateTrackFinancialReport(ArrayList<Order> orders) {
    if(orders==null|| orders.isEmpty()){
        financeReport = new FinanceReport();
        financeReport.generateFinanceReport(new ArrayList<Order>());
        return true;
    }
    if(ErrorAtSystem){
        return false;
    }
    financeReport = new FinanceReport();
    financeReport.generateFinanceReport(orders);
    return true;

}







}

package com.example.cooking_proj;

import java.util.List;

public class GenerateInvoicesAndTrackFinancialReports {
List<Invoice> Invoices;
List<FinanceReport> FinanceReports;


public boolean generateInvoice(int customerID, String customerName,Order order) {
    if(customerName == null || customerName.isEmpty() ||order==null){
        return false;
    }

    Invoice invoice = new Invoice();
    Invoices.add(invoice);
    invoice.generateInvoice(order);
    return true;
}

public void generateTrackFinancialReport(List<Customer> customers, List<Chef> chefs) {
    if(customers==null|| customers.isEmpty()){
        return;
    }
    if(chefs==null||chefs.isEmpty()){
        return;
    }
    FinanceReport financeReport = new FinanceReport();
    financeReport.generateFinanceReport(customers, chefs);

}







}

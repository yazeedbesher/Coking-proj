package com.example.cooking_proj;

import java.util.List;

public class GenerateInvoicesAndTrackFinancialReports {



public void generateInvoice(Order order) {
    if(order==null){
        return;
    }
    Invoice invoice = new Invoice();
    invoice.generateInvoice(order);
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

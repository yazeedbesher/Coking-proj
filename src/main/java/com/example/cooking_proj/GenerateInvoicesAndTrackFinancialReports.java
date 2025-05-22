package com.example.cooking_proj;

import java.util.List;

public class GenerateInvoicesAndTrackFinancialReports {

    public boolean generateInvoice(Order order) {
        if (order == null) {
            return false;
        }
        Invoice invoice = new Invoice();
        invoice.generateInvoice(order);
        return true;
    }

    public boolean generateTrackFinancialReport(List<Customer> customers, List<Chef> chefs) {
        if (customers == null || customers.isEmpty()) {
            return false;
        }
        if (chefs == null || chefs.isEmpty()) {
            return false;
        }
        FinanceReport financeReport = new FinanceReport();
        financeReport.generateFinanceReport(customers, chefs);
        return true;
    }
}

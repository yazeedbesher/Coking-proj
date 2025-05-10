package org.example.ahmad_project.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ahmad_project.GenerateInvoicesAndTrackFinancialReports;
import org.example.ahmad_project.Order;
import org.junit.Assert;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Date;

public class InvoicesAndTrackFinancialReports1 {
    GenerateInvoicesAndTrackFinancialReports gen = new GenerateInvoicesAndTrackFinancialReports();
    Order order = new Order(1,1, LocalDateTime.now(),"Order1","Ahmad Order");
    boolean result ;


    @When("the customer confirms an order that contains no products")
    public void theCustomerConfirmsAnOrderThatContainsNoProducts() {
        //JOptionPane.showMessageDialog(null," order contains no products");
        result=gen.generateInvoice(1,"ahmad",null);
    }
    @Then("the system will display an error message: Cannot create invoice, no products found in the order")
    public void theSystemWillDisplayAnErrorMessageCannotCreateInvoiceNoProductsFoundInTheOrder() {
        Assert.assertFalse(result);
        //JOptionPane.showMessageDialog(null, "Cannot create invoice, no products found in the order");
    }



    @When("the system encounters a database error during invoice creation")
    public void theSystemEncountersADatabaseErrorDuringInvoiceCreation() {
        gen.makeErrorAtDataBase();
        result = gen.generateInvoice(1,"ahmad",order);
    }
    @Then("the system will display an error message: Failed to create invoice due to a system error")
    public void theSystemWillDisplayAnErrorMessageFailedToCreateInvoiceDueToASystemError() {
        Assert.assertFalse(result);
        //JOptionPane.showMessageDialog(null, "Failed to create invoice due to a system error");
    }

    @When("the customer confirms an order that contains valid customer and product information")
    public void theCustomerConfirmsAnOrderThatContainsValidCustomerAndProductInformation() {
        //JOptionPane.showMessageDialog(null,"Customer confirms an order that contains valid customer and product information");
        result=gen.generateInvoice(1,"ahmad",order);
    }
    @Then("the system will generate an invoice automatically")
    public void theSystemWillGenerateAnInvoiceAutomatically() {
        Assert.assertTrue(result);
    }
    @Then("the system will display a success message: Invoice created successfully")
    public void theSystemWillDisplayASuccessMessageInvoiceCreatedSuccessfully() {
        //JOptionPane.showMessageDialog(null,"Invoice created successfully");
    }




}

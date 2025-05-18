package org.example.ahmad_project.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.cooking_proj.GenerateInvoicesAndTrackFinancialReports;
import com.example.cooking_proj.Order;
import org.junit.Assert;

import java.time.LocalDateTime;

public class InvoicesAndTrackFinancialReports1 {
    GenerateInvoicesAndTrackFinancialReports gen = new GenerateInvoicesAndTrackFinancialReports();
    Order order1 = new Order(1, 1, "Customer Ahmad", "Chef Ahmad", LocalDateTime.now(), "Meal 1", "Snack", LocalDateTime.now().plusSeconds(30));
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





    @When("the customer confirms an order that contains valid customer and product information")
    public void theCustomerConfirmsAnOrderThatContainsValidCustomerAndProductInformation() {
        //JOptionPane.showMessageDialog(null,"Customer confirms an order that contains valid customer and product information");
        result=gen.generateInvoice(1,"ahmad",order1);
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

package org.example.ahmad_project;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.cooking_proj.GenerateInvoicesAndTrackFinancialReports;
import com.example.cooking_proj.Order;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class InvoicesAndTrackFinancialReports2 {

    GenerateInvoicesAndTrackFinancialReports gen=new GenerateInvoicesAndTrackFinancialReports();
    ArrayList<Order> orders=new ArrayList<>();
    boolean result;
    @When("the admin sends an empty list to the report generator")
    public void theAdminSendsAnEmptyListToTheReportGenerator() {
        //JOptionPane.showMessageDialog(null,"Please select the orders");
        //result =gen.generateTrackFinancialReport(null);
    }
    @Then("the system shows: No orders to include in the report")
    public void theSystemShowsNoOrdersToIncludeInTheReport() {
        Assert.assertTrue( result);
        //JOptionPane.showMessageDialog(null,"No orders to include in the report");
    }
    @Then("the system returns true")
    public void theSystemReturnsTrue() {
        //JOptionPane.showMessageDialog(null," the system returns true");
    }







    @When("the admin sends a non-empty list to the report generator")
    public void theAdminSendsANonEmptyListToTheReportGenerator() {
        //JOptionPane.showMessageDialog(null, "Please select the orders");
        //orders.add(new Order(1, 1, "Customer Ahmad", "Chef Ahmad", LocalDateTime.now(), "Meal 1", "Snack", LocalDateTime.now().plusSeconds(30)));
        //result = gen.generateTrackFinancialReport(orders);
    }
    @Then("the system creates a report from the orders")
    public void theSystemCreatesAReportFromTheOrders() {
        Assert.assertTrue( result);
        //JOptionPane.showMessageDialog(null," Report created");
    }
    @Then("the system shows: Report generated successfully")
    public void theSystemShowsReportGeneratedSuccessfully() {
        //JOptionPane.showMessageDialog(null, "Report generated successfully");
    }


}

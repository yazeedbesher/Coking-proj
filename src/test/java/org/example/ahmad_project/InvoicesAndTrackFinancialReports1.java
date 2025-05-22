package org.example.ahmad_project;

import com.example.cooking_proj.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InvoicesAndTrackFinancialReports1 {

    GenerateInvoicesAndTrackFinancialReports gen = new GenerateInvoicesAndTrackFinancialReports();
    boolean result;
    Order order;
    List<Customer> customerList;
    List<Chef> chefList;

    @When("the customer confirms an order that contains no products")
    public void theCustomerConfirmsAnOrderThatContainsNoProducts() {
        Customer customer = new Customer(1, "Ahmad", "123 Main St", "555-1234");
        order = new Order(0, 0, customer.getCustomerName(), "Chef Ahmad", LocalDateTime.now(), "", "Snack", LocalDateTime.now().plusSeconds(30));
        result = gen.generateInvoice(order);
    }

    @Then("the system will display an error message: Cannot create invoice, no products found in the order")
    public void theSystemWillDisplayErrorNoProducts() {
        Assert.assertFalse(result);
    }

    @Then("the system will return false")
    public void theSystemWillReturnFalse() {
        Assert.assertFalse(result);
    }

    // ✅ 2. Valid order
    @When("the customer confirms an order that contains valid customer and product information")
    public void theCustomerConfirmsValidOrder() {
        Customer customer = new Customer(2, "Lina", "456 Main St", "555-5678");
        order = new Order(1, 1, customer.getCustomerName(), "Chef Lina", LocalDateTime.now(), "Meal 1", "Main Course", LocalDateTime.now().plusHours(1));
        result = gen.generateInvoice(order);
    }

    @Then("the system will generate an invoice automatically")
    public void theSystemWillGenerateInvoice() {
        Assert.assertTrue(result);
    }

    @Then("the system will display a success message: Invoice created successfully")
    public void theSystemWillDisplaySuccessMessage() {
        Assert.assertTrue(result);
    }

    @Then("the system will return true")
    public void theSystemWillReturnTrue() {
        Assert.assertTrue(result);
    }

    // ✅ 3. Order is null
    @When("the customer confirms a null order")
    public void theCustomerConfirmsANullOrder() {
        order = null;
        result = gen.generateInvoice(order);
    }

    @Then("the system will return false for null order")
    public void theSystemWillReturnFalseForNullOrder() {
        Assert.assertFalse(result);
    }

    // ✅ 4. Empty customer and chef lists
    @When("the admin sends an empty list to the report generator")
    public void theAdminSendsEmptyList() {
        customerList = new ArrayList<>();
        chefList = new ArrayList<>();
        result = gen.generateTrackFinancialReport(customerList, chefList);
    }

    @Then("the system shows: No orders to include in the report")
    public void theSystemShowsNoOrders() {
        Assert.assertFalse(result);
    }

    // ✅ 5. Non-empty customer and chef lists with orders
    @When("the admin sends a non-empty list to the report generator")
    public void theAdminSendsNonEmptyList() {
        Customer customer = new Customer(3, "Omar", "789 Main St", "555-9999");
        Order order = new Order(2, 2, customer.getCustomerName(), "Chef Sami", LocalDateTime.now(), "Meal X", "Dessert", LocalDateTime.now().plusMinutes(40));
        customer.getCustomerPastOrders().add(order);
        customerList = List.of(customer);
        chefList = List.of(new Chef());
        result = gen.generateTrackFinancialReport(customerList, chefList);
    }

    @Then("the system creates a report from the orders")
    public void theSystemCreatesReport() {
        Assert.assertTrue(result);
    }

    @Then("the system shows: Report generated successfully")
    public void theSystemShowsReportSuccess() {
        Assert.assertTrue(result);
    }

    // ✅ 6. Null customers list
    @When("the admin sends null as customers list and a valid chefs list")
    public void adminSendsNullCustomers() {
        customerList = null;
        chefList = List.of(new Chef());
        result = gen.generateTrackFinancialReport(customerList, chefList);
    }

    @Then("the system will return false for null customers")
    public void systemReturnsFalseForNullCustomers() {
        Assert.assertFalse(result);
    }

    // ✅ 7. Null chefs list
    @When("the admin sends valid customers list and null chefs list")
    public void adminSendsNullChefs() {
        Customer customer = new Customer(4, "Sara", "111 Main St", "555-0000");
        customerList = List.of(customer);
        chefList = null;
        result = gen.generateTrackFinancialReport(customerList, chefList);
    }

    @Then("the system will return false for null chefs")
    public void systemReturnsFalseForNullChefs() {
        Assert.assertFalse(result);
    }

    // ✅ 8. Both lists null
    @When("the admin sends null lists to the report generator")
    public void adminSendsNullLists() {
        customerList = null;
        chefList = null;
        result = gen.generateTrackFinancialReport(customerList, chefList);
    }

    @Then("the system will return false for null lists")
    public void systemReturnsFalseForNullLists() {
        Assert.assertFalse(result);
    }

    // ✅ 9. Customers list with no past orders
    @When("the admin sends customers without any orders and valid chefs list")
    public void customersWithoutOrders() {
        Customer customer = new Customer(5, "Nour", "222 Main St", "555-8888");
        customerList = List.of(customer);
        chefList = List.of(new Chef());
        result = gen.generateTrackFinancialReport(customerList, chefList);
    }

    @Then("the system will return true but the report might be empty")
    public void reportMightBeEmpty() {
        Assert.assertTrue(result); // still considered "generated"
    }
}

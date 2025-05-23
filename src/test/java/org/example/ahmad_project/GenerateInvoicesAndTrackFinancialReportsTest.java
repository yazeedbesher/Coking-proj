package org.example.ahmad_project;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import com.example.cooking_proj.*;

public class GenerateInvoicesAndTrackFinancialReportsTest {

    @Test
    public void testGenerateInvoice_ValidOrder() {
        // Setup
        LocalDateTime pickUpTime = LocalDateTime.now().plusHours(2);
        Order order = new Order(1, 101, "John Doe", "Chef A", "Kabsa", pickUpTime);

        GenerateInvoicesAndTrackFinancialReports invoiceGenerator = new GenerateInvoicesAndTrackFinancialReports();

        // Act
        boolean result = invoiceGenerator.generateInvoice(order);

        // Assert
        assertTrue(result, "Invoice should be generated for a valid order");
    }

    @Test
    public void testGenerateInvoice_NullOrder() {
        // Setup
        GenerateInvoicesAndTrackFinancialReports invoiceGenerator = new GenerateInvoicesAndTrackFinancialReports();

        // Act
        boolean result = invoiceGenerator.generateInvoice(null);

        // Assert
        assertFalse(result, "Invoice should not be generated for a null order");
    }

    @Test
    public void testGenerateTrackFinancialReport_ValidCustomersAndChefs() {
        // Setup
        List<Customer> customers = new ArrayList<>();
        List<Chef> chefs = new ArrayList<>();

        Customer customer1 = new Customer(101, "John Doe", "123 Street", "123456789");
        Chef chef1 = new Chef(201, "Chef A", "987654321", 5.0, 3.0);

        customers.add(customer1);
        chefs.add(chef1);

        GenerateInvoicesAndTrackFinancialReports reportGenerator = new GenerateInvoicesAndTrackFinancialReports();

        // Act
        boolean result = reportGenerator.generateTrackFinancialReport(customers, chefs);

        // Assert
        assertTrue(result, "Financial report should be generated for valid customers and chefs");
    }

    @Test
    public void testGenerateTrackFinancialReport_EmptyCustomers() {
        // Setup
        List<Customer> customers = new ArrayList<>();
        List<Chef> chefs = new ArrayList<>();

        Chef chef1 = new Chef(201, "Chef A", "987654321", 5.0, 3.0);
        chefs.add(chef1);

        GenerateInvoicesAndTrackFinancialReports reportGenerator = new GenerateInvoicesAndTrackFinancialReports();

        // Act
        boolean result = reportGenerator.generateTrackFinancialReport(customers, chefs);

        // Assert
        assertFalse(result, "Financial report should not be generated for empty customer list");
    }

    @Test
    public void testGenerateTrackFinancialReport_EmptyChefs() {
        // Setup
        List<Customer> customers = new ArrayList<>();
        List<Chef> chefs = new ArrayList<>();

        Customer customer1 = new Customer(101, "John Doe", "123 Street", "123456789");
        customers.add(customer1);

        GenerateInvoicesAndTrackFinancialReports reportGenerator = new GenerateInvoicesAndTrackFinancialReports();

        // Act
        boolean result = reportGenerator.generateTrackFinancialReport(customers, chefs);

        // Assert
        assertFalse(result, "Financial report should not be generated for empty chef list");
    }

    @Test
    public void testGenerateTrackFinancialReport_NullCustomers() {
        // Setup
        List<Chef> chefs = new ArrayList<>();
        Chef chef1 = new Chef(201, "Chef A", "987654321", 5.0, 3.0);
        chefs.add(chef1);

        GenerateInvoicesAndTrackFinancialReports reportGenerator = new GenerateInvoicesAndTrackFinancialReports();

        // Act
        boolean result = reportGenerator.generateTrackFinancialReport(null, chefs);

        // Assert
        assertFalse(result, "Financial report should not be generated for null customer list");
    }

    @Test
    public void testGenerateTrackFinancialReport_NullChefs() {
        // Setup
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer(101, "John Doe", "123 Street", "123456789");
        customers.add(customer1);

        GenerateInvoicesAndTrackFinancialReports reportGenerator = new GenerateInvoicesAndTrackFinancialReports();

        // Act
        boolean result = reportGenerator.generateTrackFinancialReport(customers, null);

        // Assert
        assertFalse(result, "Financial report should not be generated for null chef list");
    }
}

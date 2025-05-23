package org.example.ahmad_project;

import com.example.cooking_proj.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FinanceReportTest {
    private FinanceReport financeReport;

    @BeforeEach
    void setUp() {
        financeReport = new FinanceReport();
    }

    private Order createOrder(int orderId, int customerId, String customerName, String chefName, String mealName) {
        return new Order(orderId, customerId, customerName, chefName, mealName, LocalDateTime.now());
    }

    private Customer createCustomerWithOrders(String customerName, int customerID, List<Order> orders) {
        Customer customer = new Customer(customerID, customerName, "Address", "12345");
        for (Order order : orders) {
            customer.pastOrders.addPastOrder(order);
        }
        return customer;
    }

    @Test
    void testAllOrdersCount_withMultipleCustomers() {
        List<Order> orders1 = List.of(
                createOrder(1, 1, "Ahmad", "Chef A", "Kabsa"),
                createOrder(2, 1, "Ahmad", "Chef A", "Fish")
        );
        List<Order> orders2 = List.of(
                createOrder(3, 2, "Sara", "Chef B", "Pizza")
        );

        List<Customer> customers = List.of(
                createCustomerWithOrders("Ahmad", 1, orders1),
                createCustomerWithOrders("Sara", 2, orders2)
        );

        financeReport.generateFinanceReport(customers, new ArrayList<>());
        assertEquals(3, financeReport.getAllOrdersCount());
    }

    @Test
    void testChefOrdersCount_singleChef() {
        Order order1 = createOrder(1, 1, "Ahmad", "Chef A", "Kabsa");
        Order order2 = createOrder(2, 2, "Sara", "Chef A", "Fish");
        Customer customer1 = createCustomerWithOrders("Ahmad", 1, List.of(order1));
        Customer customer2 = createCustomerWithOrders("Sara", 2, List.of(order2));

        Chef chefA = new Chef(1, "Chef A", "1234", 5.0, 2.0);

        financeReport.generateFinanceReport(List.of(customer1, customer2), List.of(chefA));
        assertEquals(2, financeReport.getChefOrdersCount(chefA));
    }

    @Test
    void testCustomerOrdersCount_multipleOrders() {
        List<Order> orders = List.of(
                createOrder(1, 1, "Ahmad", "Chef A", "Kabsa"),
                createOrder(2, 1, "Ahmad", "Chef A", "Fish")
        );
        Customer customer = createCustomerWithOrders("Ahmad", 1, orders);

        assertEquals(2, financeReport.getcustomerOrdersCount(customer));
    }

    @Test
    void testCustomerWithNoOrders() {
        Customer customer = new Customer(3, "Empty", "Nowhere", "000");
        assertEquals(0, financeReport.getcustomerOrdersCount(customer));
    }

    @Test
    void testChefWithNoOrders() {
        Customer customer = new Customer(4, "Nada", "Street", "222");
        Chef chef = new Chef(10, "Chef C", "999", 4.5, 1.0);

        financeReport.generateFinanceReport(List.of(customer), List.of(chef));
        assertEquals(0, financeReport.getChefOrdersCount(chef));
    }

    @Test
    void testNoCustomersOrChefs() {
        financeReport.generateFinanceReport(new ArrayList<>(), new ArrayList<>());
        assertEquals(0, financeReport.getAllOrdersCount());
    }

    @Test
    void testReportOutput_containsValidData() {
        Order order = createOrder(1, 1, "Zaid", "Chef Z", "Zinger");
        Customer customer = createCustomerWithOrders("Zaid", 1, List.of(order));
        Chef chef = new Chef(5, "Chef Z", "911", 4.0, 2.0);

        financeReport.generateFinanceReport(List.of(customer), List.of(chef));
        String reportContent = financeReport.getReport();
        assertTrue(reportContent.contains("Total Orders: 1"));
        assertTrue(reportContent.contains("Customer Name: Zaid"));
        assertTrue(reportContent.contains("Chef Name: Chef Z"));
    }
}
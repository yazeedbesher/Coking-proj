package org.example.ahmad_project;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.*;
import com.example.cooking_proj.*;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @Test
    void testConstructorAndGetters() {
        Admin admin = new Admin(1, "Admin1", "Amman", "0799999999");

        assertEquals("Admin1", admin.getName());
        assertEquals("Amman", admin.getPassword());
        assertEquals("0799999999", admin.getPhoneNumber());
    }

    @Test
    void testSetters() {
        Admin admin = new Admin(2, "Old Name", "Old Address", "0700000000");
        admin.setName("New Name");
        admin.setPassword("New Address");
        admin.setPhoneNumber("0711111111");

        assertEquals("New Name", admin.getName());
        assertEquals("New Address", admin.getPassword());
        assertEquals("0711111111", admin.getPhoneNumber());
    }

    @Test
    void testToStringReturnsName() {
        Admin admin = new Admin(3, "TestAdmin", "Zarqa", "0722222222");
        assertEquals("TestAdmin", admin.toString());
    }

    @Test
    void testDisplayCustomerOrderHistoryWithOrders() {
        Customer customer = new Customer(1001, "Ali", "Irbid", "0771234567");

        // إنشاء طلبين وهميين
        Order order1 = new Order(1, 1001, "Ali", "Chef1", "Kabsa", LocalDateTime.now().plusDays(1));
        Order order2 = new Order(2, 1001, "Ali", "Chef2", "Lazania", LocalDateTime.now().plusDays(2));

        customer.pastOrders.addPastOrder(order1);
        customer.pastOrders.addPastOrder(order2);

        System.out.println("== Expected: 2 orders listed ==");
        Admin.displayCustomerOrderHistory(customer);
    }

    @Test
    void testDisplayCustomerOrderHistoryEmpty() {
        Customer customer = new Customer(1002, "Mona", "Aqaba", "0788888888");

        System.out.println("== Expected: Order History is empty ==");
        Admin.displayCustomerOrderHistory(customer);
    }

    @Test
    void testCreateFinanceReportWithValidData() {
        Admin admin = new Admin(4, "FinanceAdmin", "Madaba", "0733333333");

        Customer customer = new Customer(1003, "Omar", "Irbid", "0791231234");
        Chef chef = new Chef(2001, "Chef Tarek", "0798765432", 4.0, 2.0);

        List<Customer> customers = new ArrayList<>();
        customers.add(customer);

        List<Chef> chefs = new ArrayList<>();
        chefs.add(chef);

        admin.createFinanceReport(customers, chefs);
        // مخرجات من generateTrackFinancialReport تظهر على الـ console
    }

    @Test
    void testCreateFinanceReportWithEmptyLists() {
        Admin admin = new Admin(5, "EmptyAdmin", "Jerash", "0744444444");

        List<Customer> customers = new ArrayList<>();
        List<Chef> chefs = new ArrayList<>();

        admin.createFinanceReport(customers, chefs);
        // لأن الكلاس GenerateInvoicesAndTrackFinancialReports يتحقق من القوائم الفارغة ويطبع تقريرًا بسيطًا
    }
}

package org.example.ahmad_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import com.example.cooking_proj.*;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    private Customer customer;
    private Manager manager;
    private List<Chef> chefs;

    @BeforeEach
    public void setUp() {
        // إعداد البيانات الأولية
        customer = new Customer(1, "John Doe", "123 Street", "555-1234");
        manager = new Manager("Manager", 101, "Manager Address", "555-9876");

        // إنشاء بعض الطهاة لاختبار المهام
        Chef chef1 = new Chef(1, "Chef A", "555-1111", 8.0, 5.0);
        Chef chef2 = new Chef(2, "Chef B", "555-2222", 9.0, 6.0);
        chefs = Arrays.asList(chef1, chef2);

        // إضافة تفضيلات و حساسية للزبون
        customer.setcustomerpreference(Arrays.asList("Chicken", "Rice"));
        customer.seecustomerAllegries(Arrays.asList("Peanuts"));
    }

    @Test
    public void testCustomerInitialization() {
        assertNotNull(customer);
        assertEquals(1, customer.getCustomerID());
        assertEquals("John Doe", customer.getCustomerName());
        assertEquals("123 Street", customer.getCustomerAddress());
        assertEquals("555-1234", customer.getCustomerPhone());
    }

    @Test
    public void testSetMeals() {
        List<String> meals = Arrays.asList("Kabsa", "Fried Chicken", "Pasta");
        customer.setMeals(meals);
        assertEquals(3, customer.Meals.size());
        assertTrue(customer.Meals.contains("Kabsa"));
    }

    @Test
    public void testMakeOrder() {
        LocalDateTime pickUpTime = LocalDateTime.now().plusHours(2);
        customer.setMeals(Arrays.asList("Kabsa", "Fried Chicken", "Pasta"));
        customer.makeOrder1(chefs, manager, pickUpTime, 1);  // "Kabsa"

        List<Order> pastOrders = customer.getCustomerPastOrders();
        assertNotNull(pastOrders);
        assertEquals(1, pastOrders.size());
        assertEquals("Kabsa", pastOrders.get(0).getMealName());
        assertEquals("Chef B", pastOrders.get(0).getChefName()); // بناءً على المنطق في assign_Task
    }

    @Test
    public void testCustomerOrderHistory() {
        LocalDateTime pickUpTime = LocalDateTime.now().plusHours(1);
        customer.setMeals(Arrays.asList("Fried Chicken"));
        customer.makeOrder1(chefs, manager, pickUpTime, 1);  // "Fried Chicken"



        List<Order> pastOrders = customer.getCustomerPastOrders();
        assertNotNull(pastOrders);
        assertEquals(1, pastOrders.size());
        assertEquals("Fried Chicken", pastOrders.get(0).getMealName());
    }

    @Test
    public void testAddPreference() {
        List<String> preferences = customer.getPreference();
        assertNotNull(preferences);
        assertTrue(preferences.contains("Chicken"));
        assertTrue(preferences.contains("Rice"));
    }

    @Test
    public void testAddAllergy() {
        List<String> allergies = customer.getAllergies();
        assertNotNull(allergies);
        assertTrue(allergies.contains("Peanuts"));
    }
}

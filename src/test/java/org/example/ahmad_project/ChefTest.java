package org.example.ahmad_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;
import com.example.cooking_proj.*;

import static org.junit.jupiter.api.Assertions.*;

class ChefTest {

    Chef chef;
    Customer customer;
    Manager manager;
    Order order;

    @BeforeEach
    void setUp() {
        chef = new Chef(1, "Ali", "0551234567", 5.0, 2.0);
        customer = new Customer(10, "Ahmed", "Riyadh", "0500000000");
        manager = new Manager("Hassan", 101, "AdminStreet", "0588888888");
    }

    @Test
    void testConstructorInitialization() {
        assertEquals("Ali", chef.getName());
        assertEquals(5.0, chef.getExpretise());
        assertEquals(2.0, chef.getWorkload());
        assertTrue(chef.Meals.contains("Kabsa"));
    }

    @Test
    void testCreateMealIncreasesWorkload() {
        double initialWorkload = chef.getWorkload();
        chef.Create_Meal("Kabsa");
        assertEquals(initialWorkload + 1, chef.getWorkload());
    }

    @Test
    void testCreateCustomMeal_withPreferences() {
        List<String> preferences = Arrays.asList("Chicken", "Rice");
        List<String> allergies = Arrays.asList("Peanut");
        List<List> ingredients = new ArrayList<>();
        ingredients.add(preferences);
        ingredients.add(allergies);

        List<String> result = chef.Create_Custome_Meal(ingredients);

        assertTrue(result.contains("Kabsa"));
        assertTrue(result.contains("Fried Chicken"));
        assertTrue(result.contains("Cooked Rice"));
    }

    @Test
    void testStartReminderWithValidOrder() {
        LocalDateTime pickupTime = LocalDateTime.now().plusHours(2);
        Order order = new Order(1, 10, "Ahmed", "Ali", "Kabsa", pickupTime);

        assertDoesNotThrow(() -> chef.startRemainder(order));
    }

    @Test
    void testShowCustomerOrderHistory_AddsToChefMeals() {
        // إعداد طلب سابق للعميل
        Order pastOrder = new Order(1, 10, "Ahmed", "Ali", "NewDish", LocalDateTime.now().plusHours(3));
        customer.pastOrders.addPastOrder(pastOrder);

        int initialSize = chef.Meals.size();
        chef.showCustomerOrderHistory(customer);
        assertTrue(chef.Meals.contains("NewDish"));
        assertTrue(chef.Meals.size() >= initialSize + 1);
    }

    @Test
    void testDisplayCustomerOrderHistory_withOrders() {
        Order pastOrder = new Order(1, 10, "Ahmed", "Ali", "NewDish", LocalDateTime.now().plusHours(2));
        customer.pastOrders.addPastOrder(pastOrder);

        assertDoesNotThrow(() -> Chef.displayCustomerOrderHistory(customer));
    }

    @Test
    void testDisplayCustomerOrderHistory_withoutOrders() {
        // لا توجد أوامر
        assertDoesNotThrow(() -> Chef.displayCustomerOrderHistory(customer));
    }
}

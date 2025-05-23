package org.example.ahmad_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import com.example.cooking_proj.*;

class Track_past_orders_and_personalized_meal_plansTest {

    private Track_past_orders_and_personalized_meal_plans trackPastOrders;
    private Order order1;
    private Order order2;

    @BeforeEach
    void setUp() {
        // إنشاء كائنات Track_past_orders_and_personalized_meal_plans و Order
        trackPastOrders = new Track_past_orders_and_personalized_meal_plans();

        // إنشاء كائنات Order مع بيانات افتراضية
        LocalDateTime pickUpTime1 = LocalDateTime.of(2025, 5, 23, 12, 30);
        order1 = new Order(1, 101, "Ahmad", "John", "Chicken Pasta", pickUpTime1);

        LocalDateTime pickUpTime2 = LocalDateTime.of(2025, 5, 24, 18, 00);
        order2 = new Order(2, 102, "Sara", "David", "Tomato Salad", pickUpTime2);
    }

    @Test
    void testAddPastOrder() {
        // إضافة طلب جديد والتحقق من إضافته بنجاح
        boolean result = trackPastOrders.addPastOrder(order1);
        assertTrue(result, "Order should be added successfully");
        assertEquals(1, trackPastOrders.getPastOrders().size(), "Should have one past order");
    }

    @Test
    void testGetPastOrdersWhenEmpty() {
        // التأكد من أنه لا توجد طلبات في البداية
        assertNull(trackPastOrders.getPastOrders(), "Past orders should be null when no orders are added");
    }

    @Test
    void testGetPastOrdersAfterAdding() {
        // إضافة طلب ثم التأكد من استرجاعه
        trackPastOrders.addPastOrder(order1);
        trackPastOrders.addPastOrder(order2);
        assertNotNull(trackPastOrders.getPastOrders(), "Past orders should not be null after adding orders");
        assertEquals(2, trackPastOrders.getPastOrders().size(), "Should have two past orders");
    }

    @Test
    void testAddPersonalizedMealPlan() {
        // إضافة خطة وجبة مخصصة والتحقق من إضافتها بنجاح
        boolean result = trackPastOrders.addPersonalizedMealPlan("Vegan Salad");
        assertTrue(result, "Personalized meal should be added successfully");
    }

    @Test
    void testAddDuplicatePersonalizedMealPlan() {
        // إضافة نفس الوجبة المخصصة مرتين والتحقق من عدم إضافتها
        trackPastOrders.addPersonalizedMealPlan("Vegan Salad");
        boolean result = trackPastOrders.addPersonalizedMealPlan("Vegan Salad");
        assertFalse(result, "Duplicate personalized meals should not be added");
    }

    @Test
    void testAddNullPersonalizedMealPlan() {
        // محاولة إضافة وجبة مخصصة null والتحقق من أنها غير مقبولة
        boolean result = trackPastOrders.addPersonalizedMealPlan(null);
        assertFalse(result, "Null personalized meals should not be added");
    }

    @Test
    void testAddEmptyPersonalizedMealPlan() {
        // محاولة إضافة وجبة مخصصة فارغة والتحقق من رفضها
        boolean result = trackPastOrders.addPersonalizedMealPlan("");
        assertFalse(result, "Empty personalized meals should not be added");
    }
}

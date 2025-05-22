package org.example.ahmad_project;

import com.example.cooking_proj.NotificationsAndAlerts;
import com.example.cooking_proj.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class NotificationsAndAlertsTest {

    @Test
    void testValidCustomerReminderBeforeTime() {
        Order order = new Order(1, 1, "Ahmad", "Chef Sami", "Pizza",
                LocalDateTime.now().plusHours(2));
        NotificationsAndAlerts n = new NotificationsAndAlerts();

        boolean result = n.UpcomingOrdersReminder(1, order, 1);
        assertTrue(result);
    }

    @Test
    void testValidChefReminderBeforeTime() {
        Order order = new Order(2, 2, "Yousef", "Chef Fadi", "Mansaf",
                LocalDateTime.now().plusHours(2));
        NotificationsAndAlerts n = new NotificationsAndAlerts();

        boolean result = n.UpcomingOrdersReminder(1, order, 2);
        assertTrue(result);
    }

    @Test
    void testReminderTimePassed() {
        Order order = new Order(3, 3, "Maya", "Chef Hana", "Burger",
                LocalDateTime.now().minusMinutes(5));
        NotificationsAndAlerts n = new NotificationsAndAlerts();

        boolean result = n.UpcomingOrdersReminder(1, order, 1);
        assertFalse(result);
    }

    @Test
    void testCustomerNameMissing() {
        Order order = new Order(4, 4, "", "Chef A", "Kofta",
                LocalDateTime.now().plusMinutes(30));
        NotificationsAndAlerts n = new NotificationsAndAlerts();

        boolean result = n.UpcomingOrdersReminder(1, order, 1);
        assertFalse(result);
    }

    @Test
    void testChefNameMissing() {
        Order order = new Order(5, 5, "Lana", "", "Shawarma",
                LocalDateTime.now().plusMinutes(30));
        NotificationsAndAlerts n = new NotificationsAndAlerts();

        boolean result = n.UpcomingOrdersReminder(1, order, 2);
        assertFalse(result);
    }

    @Test
    void testInvalidReminderType() {
        Order order = new Order(6, 6, "Khalid", "Chef Noor", "Soup",
                LocalDateTime.now().plusMinutes(30));
        NotificationsAndAlerts n = new NotificationsAndAlerts();

        boolean result = n.UpcomingOrdersReminder(1, order, 99);
        assertFalse(result);
    }

    @Test
    void testSendCustomerReminderNow() {
        Order order = new Order(7, 7, "Alaa", "Chef Moe", "Salad",
                LocalDateTime.now().plusMinutes(30));
        NotificationsAndAlerts n = new NotificationsAndAlerts();

        assertDoesNotThrow(() -> n.sendCustomerReminderNow(order));
    }

    @Test
    void testSendChefReminderNow() {
        Order order = new Order(8, 8, "Tariq", "Chef Omar", "Cake",
                LocalDateTime.now().plusMinutes(30));
        NotificationsAndAlerts n = new NotificationsAndAlerts();

        assertDoesNotThrow(() -> n.sendChefReminderNow(order));
    }
}

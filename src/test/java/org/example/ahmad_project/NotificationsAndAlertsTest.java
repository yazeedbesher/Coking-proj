package org.example.ahmad_project;

import com.example.cooking_proj.NotificationsAndAlerts;
import com.example.cooking_proj.Order;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class NotificationsAndAlertsTest {

    @Test
    public void testReminderFailsDueToPastTime() {
        Order order = new Order(1, 1, "Ahmad", "Chef Ahmad", "Rice", LocalDateTime.now().minusHours(1));
        boolean result = new NotificationsAndAlerts().UpcomingOrdersReminder(1, order, 1);
        Assert.assertFalse(result);
    }

    @Test
    public void testCustomerReminderSentNow() {
        Order order = new Order(1, 1, "Ahmad", "Chef Ahmad", "Pizza", LocalDateTime.now().plusMinutes(30));
        boolean result = new NotificationsAndAlerts().UpcomingOrdersReminder(1, order, 1);
        Assert.assertTrue(result);
    }

    @Test
    public void testCustomerReminderFailsDueToMissingName() {
        Order order = new Order(1, 1, "", "Chef Ahmad", "Salad", LocalDateTime.now().plusHours(2));
        boolean result = new NotificationsAndAlerts().UpcomingOrdersReminder(1, order, 1);
        Assert.assertFalse(result);
    }

    @Test
    public void testChefReminderSentNow() {
        Order order = new Order(1, 1, "Ahmad", "Chef Ahmad", "Soup", LocalDateTime.now().plusMinutes(20));
        boolean result = new NotificationsAndAlerts().UpcomingOrdersReminder(1, order, 2);
        Assert.assertTrue(result);
    }

    @Test
    public void testChefReminderFailsDueToMissingChefName() {
        Order order = new Order(1, 1, "Ahmad", "", "Rice", LocalDateTime.now().plusHours(2));
        boolean result = new NotificationsAndAlerts().UpcomingOrdersReminder(1, order, 2);
        Assert.assertFalse(result);
    }

    @Test
    public void testReminderFailsDueToInvalidType() {
        Order order = new Order(1, 1, "Ahmad", "Chef Ahmad", "Rice", LocalDateTime.now().plusHours(1));
        boolean result = new NotificationsAndAlerts().UpcomingOrdersReminder(1, order, 99);
        Assert.assertFalse(result);
    }

    @Test
    public void testReminderScheduledForFuture() {
        Order order = new Order(1, 1, "Ahmad", "Chef Ahmad", "Burger", LocalDateTime.now().plusHours(3));
        boolean result = new NotificationsAndAlerts().UpcomingOrdersReminder(1, order, 1);
        Assert.assertTrue(result);
    }
}

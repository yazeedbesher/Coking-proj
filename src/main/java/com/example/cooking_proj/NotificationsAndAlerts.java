package com.example.cooking_proj;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class NotificationsAndAlerts {
    int reminderFor;
    long TimeToRemainInSeconds;

    public boolean UpcomingOrdersReminder(int timeBeforeReminderInHours, Order order, int reminderFor) {
        this.reminderFor = reminderFor;

        try {
            if (order.getPickUpTime().isBefore(LocalDateTime.now())) {
                System.err.println("Reminder failed: The delivery time has already passed.");
                return false;
            }

            // التحقق من الاسم حسب نوع التذكير
            if (reminderFor == 1) { // للزبون
                if (order.getCustomerName() == null || order.getCustomerName().isEmpty()) {
                    System.err.println("Reminder failed: Invalid customer data.");
                    return false;
                }
            } else if (reminderFor == 2) { // للطاهي
                if (order.getChefName() == null || order.getChefName().isEmpty()) {
                    System.err.println("Reminder failed: Invalid chef data.");
                    return false;
                }
            } else {
                System.err.println("Reminder failed: Invalid reminder type.");
                return false;
            }

            int timeBeforeReminderInSeconds = timeBeforeReminderInHours * 3600;

            TimeToRemainInSeconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), order.getPickUpTime());

            if (TimeToRemainInSeconds > timeBeforeReminderInSeconds) {
                Reminder(TimeToRemainInSeconds - timeBeforeReminderInSeconds, order);
            } else {
                if (reminderFor == 1) {
                    sendCustomerReminderNow(order);
                } else if (reminderFor == 2) {
                    sendChefReminderNow(order);
                }
            }

            return true;
        } catch (Exception e) {
            System.err.println("Reminder failed: " + e.getMessage());
            return false;
        }
    }

    public void Reminder(long delayInSeconds, Order order) {
        Thread timerThread = new Thread(() -> {
            try {
                Thread.sleep(delayInSeconds * 1000);
                if (reminderFor == 1) {
                    sendCustomerReminderNow(order);
                } else if (reminderFor == 2) {
                    sendChefReminderNow(order);
                }
            } catch (InterruptedException e) {
                System.err.println("Reminder thread interrupted: " + e.getMessage());
            }
        });
        timerThread.start();
    }

    public void sendCustomerReminderNow(Order order) {
        try {
            String message = "Hello " + order.getCustomerName() +
                    ",\nYour order will arrive at:\n(" + order.getPickUpTime() +
                    ")\nOrder Description:\n(" + order.getOrderDescription() + ")";
            System.out.println(message);
        } catch (Exception e) {
            System.err.println("Notification service failed: " + e.getMessage());
            throw new RuntimeException("Notification service failed", e);
        }
    }

    public void sendChefReminderNow(Order order) {
        try {
            String message = "Hello Chef " + order.getChefName() +
                    ",\nYou have to prepare an order to be delivered on:\n(" + order.getPickUpTime() +
                    ")\nOrder Description:\n(" + order.getOrderDescription() + ")";
            System.out.println(message);
        } catch (Exception e) {
            System.err.println("Notification service failed: " + e.getMessage());
            throw new RuntimeException("Notification service failed", e);
        }
    }
}

package com.example.cooking_proj;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class NotificationsAndAlerts {
    long TimeToRemain;
    boolean runTimeError = false;
    public void makeRunTimeError(){
        runTimeError = true;
    }

    public boolean UpcomingOrdersReminder(int timeBeforeReminder, Order order) {
        if(runTimeError){
            //JOptionPane.showMessageDialog(null, order.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            int timeBeforeReminder2 = timeBeforeReminder * 60; // minutes
            TimeToRemain = ChronoUnit.SECONDS.between(LocalDateTime.now(), order.getPickUpTime());

            if (TimeToRemain > timeBeforeReminder2) {
                Reminder(TimeToRemain - timeBeforeReminder2, order);
            } else {
                sendReminderNow(order);
            }

            return true;
        } catch (Exception e) {
            System.err.println("Reminder failed: " + e.getMessage()); // Logging
            return false;
        }
    }

    public void Reminder(long delayInSeconds, Order order) {
        Thread timerThread = new Thread(() -> {
            try {
                Thread.sleep(delayInSeconds * 1000);
                sendReminderNow(order);
            } catch (InterruptedException e) {
                System.err.println("Reminder thread interrupted: " + e.getMessage());
            }
        });
        timerThread.start();
    }

    public void sendReminderNow(Order order) {
        try {
            String message = "your order will arrive at:\n(" + order.getPickUpTime().toString() + ")\norder Description:\n(" + order.orderDescription + ")";
            //JOptionPane.showMessageDialog(null, message, message, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.err.println("Notification service failed: " + e.getMessage()); // Logging
            throw new RuntimeException("Notification service failed", e);
        }
    }
}

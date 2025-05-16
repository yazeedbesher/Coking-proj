package com.example.cooking_proj;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class NotificationsAndAlerts {
    long TimeToRemain;

    public boolean UpcomingOrdersReminder(int ReminderTime,Order order) {
        try {
            ReminderTime = ReminderTime * 60; // hours * 60 min
            TimeToRemain = ChronoUnit.SECONDS.between(LocalDateTime.now(),order.getPickUpTime());

            if (TimeToRemain>ReminderTime){
                System.out.println("TimeToRemain: "+TimeToRemain);
                System.out.println("ReminderTime: "+ReminderTime);
                TimeToRemain -= ReminderTime;
                System.out.println("TimeToRemain: "+TimeToRemain);
                //Reminder(TimeToRemain-ReminderTime);

            }
            String UpcomingOrdersReminder="";
            UpcomingOrdersReminder+="your order will arrive at:\n("+order.PickUpTime.toString()+")\norder Description:\n("+order.orderDescription+")";
            //JOptionPane.showMessageDialog(null, UpcomingOrdersReminder,"Upcoming Orders Reminder",JOptionPane.INFORMATION_MESSAGE);
            return true;
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    return false;
    }






    public void Reminder(long Time) throws InterruptedException {
        Thread timerThread = new Thread(() -> {
            try {
                for (long i = Time; i > 0; i--) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        });
        timerThread.start();


    }
}

package com.example.cooking_proj;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Order {
    int orderID;
    int customerID;
    String customerName;
    String chefName;
    String mealName;
    LocalDateTime orderDate;
    LocalDateTime pickUpTime;

    public int getOrderID() {
        return orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getChefName() {
        return chefName;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public LocalDateTime getPickUpTime() {
        return pickUpTime;
    }

    public String getMealName() {
        return mealName;
    }

    public Order(int orderID, int customerID, String customerName, String chefName, String mealName) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.chefName = chefName;
        this.mealName = mealName;
        this.orderDate=LocalDateTime.now();
        this.pickUpTime = SelectTime();
    }

    @Override
    public String toString() {
        return "orderID: " + orderID +
                ", OrderDate: " + orderDate ;
    }


    LocalDateTime SelectTime(){
        Scanner scanner = new Scanner(System.in);

        LocalDate today = LocalDate.now();
        System.out.println("Please enter your order date:");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + today.plusDays(i));
        }
        int dateChoice = scanner.nextInt();
        LocalDate selectedDate = today.plusDays(dateChoice - 1);
        System.out.println("\nPlease enter your order Time:");
        LocalTime[] times = new LocalTime[8];
        for (int i = 0; i < 8; i++) {
            times[i] = LocalTime.of(10 + i, 0);
            System.out.println((i + 1) + ". " + times[i].format(DateTimeFormatter.ofPattern("HH:mm")));
        }
        int timeChoice = scanner.nextInt();
        LocalTime selectedTime = times[timeChoice - 1];
        return LocalDateTime.of(selectedDate, selectedTime);
    }
}

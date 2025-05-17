package com.example.cooking_proj;

import java.util.List;
import java.util.Scanner;

public class Signin {

    public static <T extends Person> T login(List<T> userList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Sign in:");
        System.out.print("Enter your ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (T user : userList) {
            if (user.getUserID() == id) {
                System.out.println("Welcome back, " + user.getUserName() + "!");
                return user;
            }
        }

        System.out.println("User not found.");
        return null;
    }
}

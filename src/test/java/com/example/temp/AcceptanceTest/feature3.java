package com.example.temp.AcceptanceTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

import java.util.*;

public class feature3 {

    private Map<String, Integer> chefsWorkload = new HashMap<>(); // this for chef name
    private Map<String, String> chefTasks = new HashMap<>(); // this the assigned task for the chef
    private boolean chefsAvailable = true;
    private boolean notificationSent = false;
    private boolean customerReceivedMeal = false;

    @Given("the Kitchen manager assign task for chefs")
    public void theKitchenManagerAssignsTasksToChefs() {

        chefsWorkload.put("Chef John", 1);
        chefsWorkload.put("Chef Maria", 2);
        chefsWorkload.put("Chef Alex", 0); //this mean the chef is free

        System.out.println("Kitchen manager is preparing task assignments...");
    }

    @When("the chefs are available and not overloaded")
    public void theChefsAreAvailableAndNotOverloaded() {
        // check if any chef has 0 workload
        chefsAvailable = chefsWorkload.values().stream().anyMatch(workload -> workload <= 1);
        if (chefsAvailable) {
            System.out.println("Some chefs are available to take tasks.");
        } else {
            System.out.println("All chefs are busy currently.");
        }
    }

    @Then("the manager assigns tasks based on their workloads and expertise")
    public void theManagerAssignsTasksBasedOnTheirWorkloadsAndExpertise() {
        if (chefsAvailable) {
            for (Map.Entry<String, Integer> entry : chefsWorkload.entrySet()) {
                if (entry.getValue() <= 1) {
                    chefTasks.put(entry.getKey(), "Prepare special meal");
                    chefsWorkload.put(entry.getKey(), entry.getValue() + 1); // Increase workload
                    System.out.println(entry.getKey() + " has been assigned a new task.");
                    break; // Assign only to one chef for simplicity
                }
            }
        }
    }

    @Then("the chefs start preparing meals on time")
    public void theChefsStartPreparingMealsOnTime() {
        if (!chefTasks.isEmpty()) {
            System.out.println("Chefs started preparing meals on time.");
        } else {
            System.out.println("No tasks assigned yet.");
        }
    }

    @Given("the chef receives notifications about assigned tasks")
    public void theChefReceivesNotificationsAboutAssignedTasks() {
        notificationSent = true;
        System.out.println("Chef received notification about a new task.");
    }

    @Then("the customers receive their meals")
    public void theCustomersReceiveTheirMeals() {
        if (notificationSent && !chefTasks.isEmpty()) {
            customerReceivedMeal = true;
            System.out.println("Customers have received their meals.");
        } else {
            System.out.println("Meals are delayed. No notification or no task assigned.");
        }
    }
}



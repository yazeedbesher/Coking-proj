package org.example.ahmad_project;

import io.cucumber.java.en.*;

import java.util.*;

import static org.junit.Assert.*;

public class Scheduling_Task_Managment_3 {

    private Map<String, Integer> chefsWorkload = new HashMap<>();
    private Map<String, String> chefTasks = new HashMap<>();
    private boolean chefsAvailable = true;
    private boolean notificationSent = false;
    private boolean customerReceivedMeal = false;

    @Given("the Kitchen manager assign task for chefs")
    public void theKitchenManagerAssignsTasksToChefs() {
        chefsWorkload.clear();
        chefTasks.clear();
        chefsWorkload.put("Chef John", 1);
        chefsWorkload.put("Chef Maria", 2);
        chefsWorkload.put("Chef Alex", 0);
        System.out.println("Kitchen manager is preparing task assignments...");
    }

    @When("the chefs are available and not overloaded")
    public void theChefsAreAvailableAndNotOverloaded() {
        chefsAvailable = chefsWorkload.values().stream().anyMatch(workload -> workload <= 1);
        System.out.println(chefsAvailable ? "Some chefs are available to take tasks." : "All chefs are busy currently.");
    }

    @Then("the manager assigns tasks based on their workloads and expertise")
    public void theManagerAssignsTasksBasedOnTheirWorkloadsAndExpertise() {
        if (chefsAvailable) {
            for (Map.Entry<String, Integer> entry : chefsWorkload.entrySet()) {
                if (entry.getValue() <= 1) {
                    chefTasks.put(entry.getKey(), "Prepare special meal");
                    chefsWorkload.put(entry.getKey(), entry.getValue() + 1);
                    System.out.println(entry.getKey() + " has been assigned a new task.");
                    break;
                }
            }
        }
    }

    @Then("the chefs start preparing meals on time")
    public void theChefsStartPreparingMealsOnTime() {
        assertFalse("No tasks assigned yet.", chefTasks.isEmpty());
        System.out.println("Chefs started preparing meals on time.");
    }

    @Given("the chef receives notifications about assigned tasks")
    public void theChefReceivesNotificationsAboutAssignedTasks() {
        notificationSent = true;
        System.out.println("Chef received notification about a new task.");
    }

    @Then("the customers receive their meals")
    public void theCustomersReceiveTheirMeals() {
        customerReceivedMeal = notificationSent && !chefTasks.isEmpty();
        assertTrue("Meals are delayed.", customerReceivedMeal);
        System.out.println("Customers have received their meals.");
    }

    @Given("first chef already has 5 active tasks")
    public void firstChefAlreadyHas5ActiveTasks() {
        chefsWorkload.clear();
        chefsWorkload.put("Chef A", 5);
        System.out.println("Chef A has 5 active tasks.");
    }

    @And("second chef has 2 active tasks")
    public void secondChefHas2ActiveTasks() {
        chefsWorkload.put("Chef B", 2);
        System.out.println("Chef B has 2 active tasks.");
    }

    @When("a new task is created")
    public void aNewTaskIsCreated() {
        System.out.println("A new task has been created and is ready for assignment.");
    }

    @Then("the system should assign the task for second chef")
    public void theSystemShouldAssignTheTaskForSecondChef() {
        String selectedChef = chefsWorkload.entrySet().stream()
                .filter(entry -> entry.getValue() < 5)
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        assertNotNull("No available chef to assign the task.", selectedChef);
        chefTasks.put(selectedChef, "New special task");
        chefsWorkload.put(selectedChef, chefsWorkload.get(selectedChef) + 1);
        System.out.println("Assigned new task to: " + selectedChef);
    }

    @Given("Kitchen Staff Member Sam is available")
    public void KitchenStaffMemberSamIsAvailable() {
        chefsWorkload.clear();
        chefTasks.clear();
        chefsWorkload.put("Sam", 0);
        System.out.println("Sam is available for assignment.");
    }

    @And("a vegetable chopping task needs to be done")
    public void aVegetableChoppingTaskNeedsToBeDone() {
        System.out.println("Vegetable chopping task is pending.");
    }

    @When("the task is assigned")
    public void theTaskIsAssigned() {
        if (chefsWorkload.containsKey("Sam")) {
            chefTasks.put("Sam", "Chop vegetables");
            chefsWorkload.put("Sam", chefsWorkload.get("Sam") + 1);
        }
    }

    @Then("it should be assigned to Sam")
    public void itShouldBeAssignedToSam() {
        assertEquals("Chop vegetables", chefTasks.get("Sam"));
        System.out.println("Task successfully assigned to Sam.");
    }

    @Given("Chef Alex receives a new cooking task")
    public void ChefAlexReceivesNewCookingTask() {
        chefTasks.put("Chef Alex", "Cook seafood pasta");
        System.out.println("Chef Alex has been assigned a cooking task.");
    }

    @When("the task is due in 2 hours")
    public void theTaskIsDueIn2Hours() {
        System.out.println("The assigned task to Chef Alex is due in 2 hours.");
    }

    @Then("the notification should include the task deadline")
    public void theNotificationShouldIncludeTheTaskDeadline() {
        String task = chefTasks.get("Chef Alex");
        assertNotNull("No task found to notify Chef Alex.", task);
        notificationSent = true;
        System.out.println("Notification sent to Chef Alex: " + task + " (Deadline: 2 hours)");
    }

    @Given("Chef Jordan has already been notified about a task")
    public void ChefJordanHasAlreadyBeenNotifiedAboutATask() {
        chefTasks.put("Chef Jordan", "Bake lasagna");
        notificationSent = true;
        System.out.println("Chef Jordan was already notified about baking lasagna.");
    }

    @When("the same task is reassigned without change")
    public void theSameTaskIsReassignedWithoutChange() {
        System.out.println("Task reassigned to Chef Jordan without changes.");
    }

    @Then("the system should not send another notification")
    public void theSystemShouldNotSendAnotherNotification() {
        boolean resend = chefTasks.containsKey("Chef Jordan") && notificationSent;
        assertFalse("Unnecessary duplicate notification sent.", resend && notificationSent);
        System.out.println("No duplicate notification sent to Chef Jordan.");
    }
}

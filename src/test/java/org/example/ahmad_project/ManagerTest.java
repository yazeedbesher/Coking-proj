package org.example.ahmad_project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.example.cooking_proj.*;

public class ManagerTest {

    @Test
    public void testAssignCustomTask() {

        Chef chef1 = new Chef(1, "Chef 1", "123456789", 8.0, 3.0);
        Chef chef2 = new Chef(2, "Chef 2", "987654321", 7.5, 4.0);
        List<Chef> chefs = new ArrayList<>();
        chefs.add(chef1);
        chefs.add(chef2);


        Manager manager = new Manager("Manager", 1, "123 Street", "5551234");


        List<List> ingredients = new ArrayList<>();
        List<String> preferences = new ArrayList<>();
        preferences.add("Chicken");
        preferences.add("Rice");
        ingredients.add(preferences);
        ingredients.add(new ArrayList<>());


        List<String> meals = manager.assign_custome_task(chefs, ingredients);


        assertEquals(chef1.getName(), manager.getChef_name());
        assertNotNull(meals);
        assertTrue(meals.contains("Kabsa"));
        assertTrue(meals.contains("Fried Chicken"));
    }

    @Test
    public void testAssignTask() {

        Chef chef1 = new Chef(1, "Chef 1", "123456789", 8.0, 3.0);
        Chef chef2 = new Chef(2, "Chef 2", "987654321", 7.5, 4.0);
        List<Chef> chefs = new ArrayList<>();
        chefs.add(chef1);
        chefs.add(chef2);


        Manager manager = new Manager("Manager", 1, "123 Street", "5551234");


        String mealName = "Kabsa";
        String assignedChef = manager.assign_Task(chefs, mealName);


        assertEquals(chef1.getName(), assignedChef);
    }

    @Test
    public void testInitializeOrder() {

        Manager manager = new Manager("Manager", 1, "123 Street", "5551234");


        Chef chef1 = new Chef(1, "Chef 1", "123456789", 8.0, 3.0);
        Chef chef2 = new Chef(2, "Chef 2", "987654321", 7.5, 4.0);
        List<Chef> chefs = new ArrayList<>();
        chefs.add(chef1);
        chefs.add(chef2);


        manager.assign_Task(chefs, "Kabsa");


        LocalDateTime pickUpTime = LocalDateTime.now().plusHours(2);


        Order order = manager.initlize_order(1, "Customer 1", "Chef 1", "Kabsa", pickUpTime);


        assertNotNull(order);
        assertEquals(1, order.getCustomerID());
        assertEquals("Customer 1", order.getCustomerName());
        assertEquals("Chef 1", order.getChefName());
        assertEquals("Kabsa", order.getMealName());
        assertEquals(pickUpTime, order.getPickUpTime());
    }

}

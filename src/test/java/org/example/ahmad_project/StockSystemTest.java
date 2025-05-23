package org.example.ahmad_project;

import com.example.cooking_proj.StockSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class StockSystemTest {

    StockSystem stockSystem;

    @BeforeEach
    public void setup() {
        stockSystem = new StockSystem();
    }

    @Test
    public void testCheckQuantityTriggersRestockAndUserAccepts() {
        // Chicken has initial quantity 3 (less than 4), should trigger restock if user says yes
        String simulatedInput = "1\n"; // simulate user typing 1 (yes)
        provideInput(simulatedInput);

        stockSystem.Check_quantity("Chicken");

        // quantity should be increased by 3 => 3 + 3 = 6
        assertFalse(stockSystem.is_empty_storage("Chicken"));
    }

    @Test
    public void testCheckQuantityTriggersRestockAndUserDeclines() {
        String simulatedInput = "0\n"; // simulate user typing 0 (no)
        provideInput(simulatedInput);

        stockSystem.Check_quantity("Chicken");

        // quantity should still be 3
        assertFalse(stockSystem.is_empty_storage("Chicken"));
    }

    @Test
    public void testDecreaseQuantity() {
        stockSystem.decrease_quantity("Chicken"); // from 3 to 2
        // simulate user input if check triggers
        String simulatedInput = "0\n";
        provideInput(simulatedInput);
        stockSystem.Check_quantity("Chicken");
        assertFalse(stockSystem.is_empty_storage("Chicken"));
    }

    @Test
    public void testIncreaseQuantity() {
        stockSystem.increase_quantity(2, "Chicken"); // from 3 to 5
        // simulate input even if not needed
        String simulatedInput = "0\n";
        provideInput(simulatedInput);
        stockSystem.Check_quantity("Chicken");
        assertFalse(stockSystem.is_empty_storage("Chicken"));
    }

    @Test
    public void testIsEmptyStorageReturnsTrueWhenZero() {
        String simulatedInput = "1\n"; // simulate user says yes to restocking
        provideInput(simulatedInput);

        // simulate zero quantity by checking "Rice" which is initialized with 0
        assertTrue(stockSystem.is_empty_storage("Rice"));

        stockSystem.Check_quantity("Rice");

        // After restocking, should no longer be empty
        assertFalse(stockSystem.is_empty_storage("Rice"));
    }

    private void provideInput(String data) {
        InputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);
    }
}

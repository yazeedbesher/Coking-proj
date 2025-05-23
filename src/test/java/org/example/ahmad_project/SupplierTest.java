package org.example.ahmad_project;

import com.example.cooking_proj.Supplier;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SupplierTest {

    @Test
    public void testInitialSupplySetup() {
        Supplier supplier = new Supplier();

        Map<List<String>, List<Integer>> supply = supplier.getSupply();
        assertNotNull(supply);
        assertEquals(1, supply.size());

        List<String> ingredients = new ArrayList<>(supply.keySet().iterator().next());
        List<Integer> prices = supply.get(ingredients);

        assertEquals(10, ingredients.size());
        assertEquals(10, prices.size());
        assertTrue(ingredients.contains("Chicken"));
        assertTrue(ingredients.contains("pasta"));
        assertTrue(prices.contains(30));
        assertTrue(prices.contains(8));
    }

    @Test
    public void testCheckPrice_ExistingIngredient() {
        Supplier supplier = new Supplier();
        Integer price = supplier.Check_Price("Chicken");
        assertNotNull(price);
        assertEquals(30, price);
    }

    @Test
    public void testCheckPrice_NonExistingIngredient() {
        Supplier supplier = new Supplier();
        Integer price = supplier.Check_Price("Beef");
        assertNull(price);
    }
}

package org.example.ahmad_project;

import com.example.cooking_proj.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testGetUserID() {
        Customer customer = new Customer(101, "Ahmad", "Amman", "0790000000");
        assertEquals(101, customer.getUserID());
    }

    @Test
    public void testGetUserName() {
        Customer customer = new Customer(102, "Sara", "Irbid", "0788888888");
        assertEquals("Sara", customer.getUserName());
    }
}

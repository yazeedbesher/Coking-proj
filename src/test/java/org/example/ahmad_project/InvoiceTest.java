package org.example.ahmad_project;

import com.example.cooking_proj.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {
    private Invoice invoice;
    private Order order;

    @BeforeEach
    void setUp() {
        invoice = new Invoice();
        Customer customer = new Customer(1, "Ahmad", "123 Main St", "555-1234");
        LocalDateTime now = LocalDateTime.now();
        order = new Order(1, 1, customer.getCustomerName(), "Chef Ahmad", "Meal 1", now.plusHours(1)); // استخدام الكونستركتور الجديد
    }

    @Test
    void testGenerateInvoice_validOrder() {
        invoice.generateInvoice(order);
        String invoiceContent = invoice.getInvoice();
        assertTrue(invoiceContent.contains(String.valueOf(order.getOrderID()))); // تحويل int إلى String
        assertTrue(invoiceContent.contains(order.getCustomerName()));
        assertTrue(invoiceContent.contains(order.mealName));
        assertTrue(invoiceContent.contains(order.getPickUpTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
    }

    @Test
    void testGenerateInvoice_emptyMealName() {
        order.mealName = ""; // تغيير اسم الوجبة ليكون فارغ
        invoice.generateInvoice(order);
        String invoiceContent = invoice.getInvoice();
        assertTrue(invoiceContent.contains("Meal Name        : \n"));
        assertTrue(invoiceContent.contains(String.valueOf(order.getOrderID()))); // تحويل int إلى String
        assertTrue(invoiceContent.contains(order.getCustomerName()));
    }
}
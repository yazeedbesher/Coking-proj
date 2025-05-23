package org.example.ahmad_project;

import com.example.cooking_proj.Create_Custome_Meal_2;
import com.example.cooking_proj.StockSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class Create_Custome_Meal_2Test {
//    private Create_Custome_Meal_2 createCustomMeal;
//    private StockSystem stockSystem;
//
//    @BeforeEach
//    void setUp() {
//        createCustomMeal = new Create_Custome_Meal_2();
//        stockSystem = new StockSystem();
//    }
//
//    @Test
//    void testCreateMealWithUnavailableIngredient() {
//        // إعداد البيانات للاختبار
//        List<String> ingredients = new ArrayList<>(List.of("Rice", "Tomato", "Cheese"));
//        List<String> allergies = new ArrayList<>(List.of("Tomato"));
//
//        // محاكاة المدخلات باستخدام System.setIn() بدلاً من استخدام Scanner في StockSystem
//        System.setIn(new ByteArrayInputStream("data\n".getBytes()));  // هنا نضع مدخلات ثابتة
//
//        // التفاعل مع الكود
//        List<List> meal = createCustomMeal.create_meal(ingredients, allergies);
//
//        // التأكد من أن التغيير تم بنجاح
//        assertTrue(meal.get(0).contains("Rice"), "Expected ingredient Rice to be present after alternative suggestion.");
//    }
//
//    @Test
//    void testCreateMealWithEmptyStorage() {
//        // إعداد البيانات للاختبار
//        List<String> ingredients = new ArrayList<>(List.of("Rice", "Lettuce"));
//        List<String> allergies = new ArrayList<>();
//
//        // محاكاة المدخلات باستخدام System.setIn() بدلاً من استخدام Scanner في StockSystem
//        System.setIn(new ByteArrayInputStream("data\n".getBytes()));  // هنا نضع مدخلات ثابتة
//
//        // التفاعل مع الكود
//        List<List> meal = createCustomMeal.create_meal(ingredients, allergies);
//
//        // التأكد من أن البديل تم اقتراحه بشكل صحيح
//        assertTrue(meal.get(0).contains("Rice"), "Expected Rice to be added after restocking.");
//    }
//
//    @Test
//    void testCreateMealWithIncompatibleIngredients() {
//        // إعداد البيانات للاختبار
//        List<String> ingredients = new ArrayList<>(List.of("Cheese", "Fish"));
//        List<String> allergies = new ArrayList<>();
//
//        // محاكاة المدخلات باستخدام System.setIn() بدلاً من استخدام Scanner في StockSystem
//        System.setIn(new ByteArrayInputStream("data\n".getBytes()));  // هنا نضع مدخلات ثابتة
//
//        // التفاعل مع الكود
//        List<List> meal = createCustomMeal.create_meal(ingredients, allergies);
//
//        // التأكد من أن المكونات المتضاربة تم التعامل معها
//        assertTrue(meal.get(0).contains("Fish") || meal.get(0).contains("Cheese"),
//                "Expected incompatible ingredients to be handled correctly.");
//    }
//
//    @Test
//    void testCreateMealWithAllergicIngredient() {
//        // إعداد البيانات للاختبار
//        List<String> ingredients = new ArrayList<>(List.of("Tomato", "Cheese"));
//        List<String> allergies = new ArrayList<>(List.of("Tomato"));
//
//        // محاكاة المدخلات باستخدام System.setIn() بدلاً من استخدام Scanner في StockSystem
//        System.setIn(new ByteArrayInputStream("data\n".getBytes()));  // هنا نضع مدخلات ثابتة
//
//        // التفاعل مع الكود
//        List<List> meal = createCustomMeal.create_meal(ingredients, allergies);
//
//        // التأكد من أن البديل تم اقتراحه بشكل صحيح
//        assertTrue(meal.get(0).contains("Cheese"), "Expected Cheese to be present after allergy check.");
//    }
}

package com.example.cooking_proj;

import java.util.*;

public class dietary_preferences_and_allergies {
    static List<String> selectedAllergies;
    static List<String> selected_Preference;
    static StockSystem stockSystem;
    static Map<List<String>, List<Integer>> Stock;
    static List<String> ingredients ;

    public dietary_preferences_and_allergies() {
        selectedAllergies = new ArrayList<>();
        selected_Preference = new ArrayList<>();
        stockSystem = new StockSystem();
        Stock = new HashMap<>();
        ingredients = new ArrayList<>();
    }

public static List<String> addPreference(String vegan) {
    Stock = stockSystem.getStock();
    Map.Entry<List<String>, List<Integer>> StockMap = Stock.entrySet().iterator().next();
    ingredients = StockMap.getKey();

        Scanner scanner = new Scanner(System.in);
    System.out.print("How many Ingredients would you like to enter? ");
    int count = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < count; i++) {
        System.out.print("Enter Ingredients " + (i + 1) + ": ");
        String input = scanner.nextLine();
        if(!ingredients.contains(input)) {
            System.out.println("Sorry We Dont Have " + input + " right Now");
        }
        else{
            selected_Preference.add(input);
        }
    }
    return selected_Preference;
}

public static List<String> addAllergies() {

    Scanner scanner = new Scanner(System.in);

    System.out.print("How many Allergies would you like to enter? ");
    int countA = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < countA; i++) {
        System.out.print("Enter Allergies " + (i + 1) + ": ");
        String input = scanner.nextLine();
        selectedAllergies.add(input);
    }

    return selectedAllergies;

}

public List<String> getPreferences() {
   return selected_Preference;
}

public List<String> getAllergeis() {
        return selectedAllergies;}


    public boolean setPreferences(ArrayList<Object> objects) {
        return false;
    }

    public void setAllergies(ArrayList<String> objects) {
        this.selected_Preference = objects;
    }

    public ArrayList<String> getAllergies() {
        return (ArrayList<String>) selectedAllergies;
    }

    public void addAllergy(String peanuts) {
        this.selectedAllergies.add(peanuts);
    }

    public void clearPreferences() {
     selected_Preference.clear();
    }

    public void clearAllergies() {
        selectedAllergies.clear();
    }
}

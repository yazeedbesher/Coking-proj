package com.example.cooking_proj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class dietary_preferences_and_allergies {
    List<String> selectedAllergies;
    List<String> selected_Preference;


    public dietary_preferences_and_allergies() {
        selectedAllergies = new ArrayList<>();
        selected_Preference = new ArrayList<>();
    }

public List<String> addPreference() {
        Scanner scanner = new Scanner(System.in);

    System.out.print("How many Ingredients would you like to enter? ");
    int count = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < count; i++) {
        System.out.print("Enter Ingredients " + (i + 1) + ": ");
        String input = scanner.nextLine();
        selected_Preference.add(input);
    }
    return selected_Preference;
}

public List<String> addAllergies() {

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

//public boolean addPreferencesAndAllergies(ArrayList<String> preferences, ArrayList<String> allergies) {
//    if (preferences == null || preferences.isEmpty() ) {
//        return false;
//    }
//    if (allergies == null || allergies.isEmpty() ) {
//        for(String str : preferences) {
//            this.selected_Preference.add(str);
//        }
//
//        return true;
//    }
//    for(String str : preferences) {
//        this.selected_Preference.add(str);
//    }
//    for(String str : allergies) {
//    this.selectedAllergies.add(str);}
//    return true;
//}
//
//
//    public boolean getPreferencesAndAllergies(ArrayList<String> preferences, ArrayList<String> allergies){
//    if(this.selected_Preference == null ||this.selected_Preference.isEmpty()){
//    return false;
//    }
//
//
//    return true;
//    }
//
//
//    private ArrayList<String> List(String ... strings) {
//        ArrayList<String>list =new ArrayList<>();
//        for(String s: strings){
//            list.add(s);
//        }
//        return list;
//
//    }

}

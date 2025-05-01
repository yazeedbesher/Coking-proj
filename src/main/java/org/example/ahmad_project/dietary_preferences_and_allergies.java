package org.example.ahmad_project;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class dietary_preferences_and_allergies {
    List<String> preferences;
    List<String> allergies;
public dietary_preferences_and_allergies() {
    preferences = new ArrayList<String>();
    allergies = new ArrayList<>();
}

public boolean addPreferencesAndAllergies(ArrayList<String> preferences, ArrayList<String> allergies) {
    if (preferences == null || preferences.isEmpty() ) {
        JOptionPane.showMessageDialog(null, "Preferences is empty");
        return false;
    }
    if (allergies == null || allergies.isEmpty() ) {
        this.preferences = preferences;
        JOptionPane.showMessageDialog(null, "Preferences saved successfully");
        return true;
    }
    this.preferences = preferences;
    this.allergies = allergies;
    JOptionPane.showMessageDialog(null, "Preferences and Allergies saved successfully");
    return true;
}



}

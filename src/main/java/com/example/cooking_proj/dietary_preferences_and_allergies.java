package com.example.cooking_proj;

import java.util.ArrayList;

public class dietary_preferences_and_allergies {
    ArrayList<String> preferences;
    ArrayList<String> allergies;
    boolean thereIsPreference;
    boolean thereIsAllergies;

    public dietary_preferences_and_allergies() {
    preferences = new ArrayList<String>();
    allergies = new ArrayList<String>();
    thereIsPreference=false;
        thereIsAllergies=false;
    }

public boolean addPreference(ArrayList <String> preference) {
        if(preference==null||preference.isEmpty()){
            //JOptionPane.showMessageDialog(null, "no preference entered");
            return false;
        }
        //JOptionPane.showMessageDialog(null, "Your preferences have been updated");
        thereIsPreference=true;
        for(String s : preference){

            if(!this.preferences.contains(s)){
                this.preferences.add(s);
            }

        }
return true;
}

public boolean addAllergies(ArrayList <String> allergies) {

        if(allergies==null||allergies.isEmpty()){
           // JOptionPane.showMessageDialog(null, "no allergies entered");
            return false;
        }
        //JOptionPane.showMessageDialog(null, "Your allergies have been updated");
        thereIsAllergies=true;
        for(String s : allergies){
            if(!this.allergies.contains(s)){
                this.allergies.add(s);
            }

        }
        return true;
}

public ArrayList<String> getPreferences() {
        if(!thereIsPreference){
            //JOptionPane.showMessageDialog(null, "no preference to show");
            return new ArrayList<String>();
        }
        //JOptionPane.showMessageDialog(null, "preferences are showed");
        return preferences;
}
public ArrayList<String> getAllergies() {
        if(!thereIsAllergies){
            //JOptionPane.showMessageDialog(null, "no allergies to show");
            return new ArrayList<>();
        }
        //JOptionPane.showMessageDialog(null, "allergies are showed");
        return allergies;
}

//public boolean addPreferencesAndAllergies(ArrayList<String> preferences, ArrayList<String> allergies) {
//    if (preferences == null || preferences.isEmpty() ) {
//        JOptionPane.showMessageDialog(null, "Preferences is empty");
//        return false;
//    }
//    if (allergies == null || allergies.isEmpty() ) {
//        for(String str : preferences) {
//            this.preferences.add(str);
//        }
//        JOptionPane.showMessageDialog(null, "Preferences saved successfully");
//        return true;
//    }
//    for(String str : preferences) {
//        this.preferences.add(str);
//    }
//    for(String str : allergies) {
//    this.allergies.add(str);}
//    JOptionPane.showMessageDialog(null, "Preferences and Allergies saved successfully");
//    return true;
//}
//
//
//    public boolean getPreferencesAndAllergies(ArrayList<String> preferences, ArrayList<String> allergies){
//    if(this.preferences == null ||this.preferences.isEmpty()){
//    return false;
//    }
//
//
//    return true;
//    }


    private ArrayList<String> List(String ... strings) {
        ArrayList<String>list =new ArrayList<>();
        for(String s: strings){
            list.add(s);
        }
        return list;

    }

}

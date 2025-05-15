package org.example.ahmad_project.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
//import org.junit.Assert.assertEquals;
import java.util.ArrayList;

import com.example.cooking_proj.dietary_preferences_and_allergies;

public class dietary_preferences_and_allergiesTest {
    dietary_preferences_and_allergies PreAndAlle = new dietary_preferences_and_allergies();


//1
    @When("the customer leave the preferences field empty")
    public void theCustomerLeaveThePreferencesFieldEmpty() {
        ArrayList<String>Pre=new ArrayList<>();
        Assert.assertFalse(PreAndAlle.addPreference(Pre));
    }

//2
    @When("the customer enter dietary preferences")
    public void theCustomerEnterDietaryPreferences() {
        ArrayList<String>Pre=new ArrayList<>();
        Pre = List("Ahmad","Mayyaleh");
        Assert.assertTrue(PreAndAlle.addPreference(Pre));
    }


//3
    @When("the customer leave the allergies field empty")
    public void theCustomerLeaveTheAllergiesFieldEmpty() {
        ArrayList<String>AL=new ArrayList<>();
        Assert.assertFalse(PreAndAlle.addAllergies(AL));
    }


//4
    @When("the customer enter dietary allergies")
    public void theCustomerEnterDietaryAllergies() {
        ArrayList<String>AL=new ArrayList<>();
        AL = List("Yazeed","Besher");
        Assert.assertTrue(PreAndAlle.addAllergies(AL));
    }




    @Then("the system will pop up an error massage")
    public void theSystemWillPopUpAnErrorMassage() {

    }
    @Then("the system return false")
    public void theSystemReturnFalse() {
       //JOptionPane.showMessageDialog(null,"System return false");
    }

    @Then("the system return true")
    public void theSystemReturnTrue() {
       //JOptionPane.showMessageDialog(null,"System return true");
    }


    private ArrayList<String> List(String ... strings) {
        ArrayList<String>list =new ArrayList<>();
        for(String s: strings){
            list.add(s);
        }
        return list;

    }
}

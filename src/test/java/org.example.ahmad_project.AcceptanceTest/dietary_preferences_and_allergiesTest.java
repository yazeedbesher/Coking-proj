package org.example.ahmad_project.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//import org.junit.Assert.assertEquals;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.example.ahmad_project.dietary_preferences_and_allergies;

public class dietary_preferences_and_allergiesTest {
    dietary_preferences_and_allergies PreAndAlle = new dietary_preferences_and_allergies();

    @When("the customer leave the fields empty")
    public void theCustomerLeaveTheFieldsEmpty() {
        ArrayList<String>Pre=new ArrayList<>();
        ArrayList<String>Al=new ArrayList<>();
        Assert.assertFalse(PreAndAlle.addPreferencesAndAllergies(Pre, Al));
    }

    @Then("the system will pop up an error massage")
    public void theSystemWillPopUpAnErrorMassage() {

    }
    @Then("the system give the user another chance")
    public void theSystemGiveTheUserAnotherChance() {

    }



    @When("the customer enter dietary preferences")
    public void theCustomerEnterDietaryPreferences() {
        ArrayList<String>Pre=new ArrayList<>();
        Pre =List("Avocados","Healthy Fats","Vegetables");
        ArrayList<String>Al=new ArrayList<>();
        Assert.assertTrue(PreAndAlle.addPreferencesAndAllergies(Pre, Al));
    }
    @When("leave the allergies empty")
    public void leaveTheAllergiesEmpty() {

    }
    @Then("the system by default consider there is no allergies")
    public void theSystemByDefaultConsiderThereIsNoAllergies() {

    }
    @Then("the system allows the user to proceed without errors")
    public void theSystemAllowsTheUserToProceedWithoutErrors() {

    }
    @Then("the system save the data in user information")
    public void theSystemSaveTheDataInUserInformation() {

    }


    @When("the customer enter dietary preferences and allergies")
    public void theCustomerEnterDietaryPreferencesAndAllergies() {
        ArrayList<String>Pre=new ArrayList<>();
        Pre =List("Avocados","Healthy Fats","Vegetables");
        ArrayList<String>Al=new ArrayList<>();
        Al =List("Milk Allergy","Peanut Allergy","Wheat Allergy");
        Assert.assertTrue(PreAndAlle.addPreferencesAndAllergies(Pre, Al));

    }


    private ArrayList<String> List(String ... strings) {
        ArrayList<String>list =new ArrayList<>();
        for(String s: strings){
            list.add(s);
        }
        return list;

    }


}
